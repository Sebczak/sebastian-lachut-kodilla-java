package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

    private static Logger logger;

    @BeforeAll
    public static void startLogs() {
        logger = Logger.INSTANCE;
        logger.log("def");
    }

    @Test
    void testGetLastLog() {
        //Given
        //When
        String result = logger.getLastLog();

        //Then
        assertEquals("def", result);
    }
}
