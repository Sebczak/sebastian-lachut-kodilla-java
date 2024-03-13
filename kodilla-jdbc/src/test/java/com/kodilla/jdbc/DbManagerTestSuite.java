package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DbManagerTestSuite {

    @Test
    void testConnection() {
        //Given
        //When
        DbManager dbManager = DbManager.getInstance();

        //Then
        assertNotNull(dbManager.getConnection());
    }

    @Test
    void testSelectUsers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT * FROM users";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getInt("id") + ", " +
                    rs.getString("firstname") + ", " +
                    rs.getString("lastname"));
            counter++;
        }
        rs.close();
        statement.close();
        assertEquals(5, counter);
    }

    @Test
    void testSelectUsersAndTasks() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT U.firstname, U.lastname, I.summary\n" +
                "  FROM users U\n" +
                "  JOIN issues I ON U.id = I.user_id_assignedto";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getString("firstname") + ", " +
                    rs.getString("lastname") + ", " +
                    rs.getString("summary"));
            counter++;
        }
        rs.close();
        statement.close();
        assertEquals(15, counter);
    }

    @Test
    void testSelectUsersAndPosts() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = """
                SELECT users.firstname, users.lastname, COUNT(*) FROM users
                JOIN posts ON users.id = posts.user_id
                GROUP BY posts.user_id
                HAVING COUNT(*) >= 2;
                """;
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getString("firstname") + ", " +
                    rs.getString("lastname") + ", " +
                    rs.getString("COUNT(*)"));
            counter++;
        }
        rs.close();
        statement.close();
        assertEquals(1, counter);
    }
}

