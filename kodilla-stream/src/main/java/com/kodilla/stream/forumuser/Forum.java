package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public class Forum {

    public final List<ForumUser> listOfUsers = new ArrayList<>();

    public Forum() {
        listOfUsers.add(new ForumUser(1, "Sebczak", 'M', 1998, 8, 22, 5));
        listOfUsers.add(new ForumUser(2, "Kk", 'F', 2002, 10, 10, 1));
        listOfUsers.add(new ForumUser(3, "Ben", 'M', 2010, 2, 15, 0));
        listOfUsers.add(new ForumUser(4, "Bob", 'M', 2001, 4, 17, 2));
        listOfUsers.add(new ForumUser(5, "Bert", 'M', 1897, 5, 1, 3));
        listOfUsers.add(new ForumUser(6, "Dana", 'F', 1960, 6, 30, 555));
    }

    public List<ForumUser> getListOfUsers() {
        return listOfUsers;
    }
}
