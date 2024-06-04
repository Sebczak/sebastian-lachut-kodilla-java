package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoredProcTestSuite {

    @Test
    public void testUpdateVipLevels() throws SQLException {
        // Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL='not set'";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL='not set'";

        // When
        Statement statement2 = dbManager.getConnection().createStatement();
        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement2.execute(sqlProcedureCall);
        ResultSet rs = statement.executeQuery(sqlCheckTable);

        // Then
        int howMany = -1;
        if (rs.next()) {
            howMany = rs.getInt("HOW_MANY");
        }
        assertEquals(0, howMany);
        rs.close();
        statement.close();
        statement2.close();
    }

    @Test
    void testUpdateBestsellers() throws SQLException {
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE BOOKS SET BESTSELLER=0";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        String sqlCheckTable = "SELECT COUNT(*) AS BESTSELLERS FROM BOOKS WHERE BESTSELLER = 0";

        //When
        Statement statement1 = dbManager.getConnection().createStatement();
        String sqlProcedureCall = "CALL AddBestsellerStatusToBooks()";
        statement1.execute(sqlProcedureCall);
        ResultSet rs = statement.executeQuery(sqlCheckTable);

        //Then
        int bestsellers = -1;
        if (rs.next()) {
            bestsellers += rs.getInt("BESTSELLERS");
        }
        assertEquals(2, bestsellers);
        rs.close();
        statement.close();
        statement1.close();
    }
}
