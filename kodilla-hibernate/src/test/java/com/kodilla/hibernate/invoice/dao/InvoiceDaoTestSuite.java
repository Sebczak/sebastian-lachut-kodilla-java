package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;


    @Test
    void testInvoiceDaoSave() {
        //Given
        Product apple = new Product("Apple");
        Product banana = new Product("Banana");
        Product juice = new Product("Juice");
        Item appleItems = new Item(new BigDecimal(5), 100, new BigDecimal(1));
        Item bananaItems = new Item(new BigDecimal(8), 50, new BigDecimal(2));
        Item juiceItems = new Item(new BigDecimal(10), 35, new BigDecimal(5));
        appleItems.setProduct(apple);
        bananaItems.setProduct(banana);
        juiceItems.setProduct(juice);

        Invoice invoice = new Invoice("Invoice no. 152");
        invoice.getItems().add(appleItems);
        invoice.getItems().add(bananaItems);
        invoice.getItems().add(juiceItems);

        appleItems.setInvoice(invoice);
        bananaItems.setInvoice(invoice);
        juiceItems.setInvoice(invoice);

        //When
        invoiceDao.save(invoice);
        int id = invoice.getId();

        //Then
        assertNotEquals(0, id);

        //Cleanup
        invoiceDao.deleteById(id);
    }
}
