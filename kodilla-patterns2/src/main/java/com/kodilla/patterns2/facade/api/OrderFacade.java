package com.kodilla.patterns2.facade.api;

import com.kodilla.patterns2.facade.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@EnableAspectJAutoProxy
@Service
public class OrderFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFacade.class);
    private ShopService shopService;

    public OrderFacade(ShopService shopService) {
        this.shopService = shopService;
    }

    public void processOrder(OrderDto order, Long userId) throws OrderProcessingException {
        boolean wasError = false;
        Long orderId = shopService.openOrder(userId);
        LOGGER.info("Registering new order, ID: {}", orderId);
        if (orderId < 0) {
            LOGGER.error(OrderProcessingException.ERR_NOT_AUTHORISED);
            throw new OrderProcessingException(OrderProcessingException.ERR_NOT_AUTHORISED);
        }
        try {
            for (ItemDto orderItem : order.getItems()) {
                LOGGER.info("Adding item {}, {} pcs", orderItem.productId(), orderItem.quantity());
                shopService.addItem(orderId, orderItem.productId(), orderItem.quantity());
            }
            BigDecimal value = shopService.calculateValue(orderId);
            LOGGER.info("Order value is: {} USD", value);
            if (!shopService.doPayment(orderId)) {
                LOGGER.error(OrderProcessingException.ERR_PAYMENT_REJECTED);
                wasError = true;
                throw new OrderProcessingException(OrderProcessingException.ERR_PAYMENT_REJECTED);
            }
            LOGGER.info("Payment for order was done");
            if (!shopService.verifyOrder(orderId)) {
                LOGGER.error(OrderProcessingException.ERR_VERIFICATION_ERROR);
                wasError = true;
                throw new OrderProcessingException(OrderProcessingException.ERR_VERIFICATION_ERROR);
            }
            LOGGER.info("Order is ready to submit");
            if (!shopService.submitOrder(orderId)) {
                LOGGER.error(OrderProcessingException.ERR_SUBMITTING_ERROR);
                wasError = true;
                throw new OrderProcessingException(OrderProcessingException.ERR_SUBMITTING_ERROR);
            }
            LOGGER.info("Order {} submitted", orderId);
        } finally {
            if (wasError) {
                LOGGER.info("Cancelling order {}", orderId);
                shopService.cancelOrder(orderId);
            }
        }
    }
}
