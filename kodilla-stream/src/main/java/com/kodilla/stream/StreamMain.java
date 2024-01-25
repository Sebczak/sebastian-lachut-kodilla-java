package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.person.People;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        System.out.println(poemBeautifier.beautify("Witam z rana", b -> b.toUpperCase()));
        System.out.println(poemBeautifier.beautify("Witam z rana", b -> b.toLowerCase()));
        System.out.println(poemBeautifier.beautify("Witam z rana", b -> b + "ABC"));
        System.out.println(poemBeautifier.beautify("Witam z rana", b -> "ABC" + b));
        System.out.println(poemBeautifier.beautify("Witam z rana", b -> b.substring(0, 5)));
        poemBeautifier.beautify("Witam z rana" , b -> {
            StringBuilder sb = new StringBuilder(b);
            System.out.println(sb.reverse());
            return b;
        });


        Forum forum = new Forum();
        Map<Integer, ForumUser> mapOfUsers = forum.getListOfUsers().stream()
                .filter(user -> user.getGender() == 'M')
                .filter(user -> user.getNumberOfPosts() >= 1)
                .filter(user -> user.getDateOfBirth().getYear() <= 2003)
                .collect(Collectors.toMap(ForumUser::getId, user -> user));

        mapOfUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}
