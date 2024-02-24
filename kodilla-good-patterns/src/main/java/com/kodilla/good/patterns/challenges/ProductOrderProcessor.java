package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.challenges.buy.request.BuyDto;
import com.kodilla.good.patterns.challenges.buy.request.BuyRequest;
import com.kodilla.good.patterns.challenges.information.service.InformationService;
import com.kodilla.good.patterns.challenges.order.repository.ProductOrderRepository;
import com.kodilla.good.patterns.challenges.order.service.OrderService;

public class ProductOrderProcessor {

    private InformationService informationService;
    private OrderService orderService;
    private ProductOrderRepository productOrderRepository;
    public ProductOrderProcessor(final InformationService informationService,
                           final OrderService orderService,
                           final ProductOrderRepository productOrderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.productOrderRepository = productOrderRepository;
    }

    public BuyDto process(final BuyRequest buyRequest) {
        boolean isOrdered = orderService.buy(buyRequest.getUser(), buyRequest.getDateOfPurchase(),
                buyRequest.getPrice());
        if (isOrdered) {
            informationService.inform(buyRequest.getUser());
            productOrderRepository.createOrder(buyRequest.getUser(), buyRequest.getDateOfPurchase(), buyRequest.getPrice());
            return new BuyDto(buyRequest.getUser(), true);
        } else {
            return new BuyDto(buyRequest.getUser(), false);
        }
    }
}
