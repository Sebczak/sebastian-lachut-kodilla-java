package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {

    private final int id;
    private final String username;
    private final char gender;
    private final LocalDate dateOfBirth;
    private final int numberOfPosts;

    public ForumUser(int id, String username, char gender, int yearOfBirth, int monthOfBirth, int dayOfBirth, int numberOfPosts) {
        this.id = id;
        this.username = username;
        this.gender = gender;
        this.dateOfBirth = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        this.numberOfPosts = numberOfPosts;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                ", numberOfPosts=" + numberOfPosts +
                '}';
    }
}
