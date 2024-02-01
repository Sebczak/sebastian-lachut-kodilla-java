package com.kodilla.exception.nullpointer;

import java.util.Optional;

public class NullPointerExceptionRunner {
    public static void main(String[] args) {


        MessageSender message = new MessageSender();
        User user = new User("user");

        Optional<User> optionalUser = Optional.ofNullable(user);

        String username = optionalUser.orElse(new User("")).getName();
        System.out.println(username);

        optionalUser.ifPresent(u -> System.out.println(u.getName()));

        try {
            message.sendMessageTo(user, "Hi");
        } catch (MessageNotSentException e) {
            System.out.println("Exception caught");
        }

        System.out.println("Next method");
    }
}
