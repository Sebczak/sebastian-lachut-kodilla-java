package com.kodilla.good.patterns.challenges.food.online.distribution.request;

import com.kodilla.good.patterns.challenges.food.online.distribution.user.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OrderRequestRetriever {

     public OrderRequest retrieveData() {

         User user = new User("Sebastian", "Lachut", 795);

         LocalDate localDate = LocalDate.from(LocalDateTime.of(2017, 8, 1, 12, 0));

         double price = 120;

         String food = "Turkey";

         String companyName = "GlutenFreeShop";

         return new OrderRequest(user, localDate.atStartOfDay(), price, food, companyName);
     }
}
