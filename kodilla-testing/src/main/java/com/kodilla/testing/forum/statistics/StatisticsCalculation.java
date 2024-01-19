package com.kodilla.testing.forum.statistics;

public class StatisticsCalculation {
    private Statistics statistics;
    private int usersCount;
    private int postsCount;
    private int commentsCount;
    private double avgPostsPerUser;
    private double avgCommentsPerUser;
    private double avgCommentsPerPost;

    public StatisticsCalculation(Statistics statistics) {
        this.statistics = statistics;
    }
    public void calculateAdvStatistics(Statistics statistics) {

        usersCount = statistics.usersNames().size();
        postsCount = statistics.postsCount();
        commentsCount = statistics.commentsCount();

        avgPostsPerUser = (double) postsCount / usersCount;
        avgCommentsPerUser = (double) commentsCount / usersCount;

        if (postsCount != 0) {
            avgCommentsPerPost = (double) commentsCount / postsCount;
        }
    }

    public int getUsersCount() {
        return usersCount;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }
}
