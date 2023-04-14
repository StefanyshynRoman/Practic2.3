package com.shpp.rstefanyshyn;

import static com.shpp.rstefanyshyn.App.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit test for simple App.
 */

class AppTest {
    private static final Logger logger = LoggerFactory.getLogger(AppTest.class);

    @Test
    void testMultiplyLong() {
        multiplyLong(5L, 1L, 2L);
        ArrayList<BigDecimal> resultTable1 = new ArrayList<>();
        resultTable1.add(BigDecimal.valueOf(4));
        resultTable1.add(BigDecimal.valueOf(1));
        resultTable1.add(BigDecimal.valueOf(3));
        resultTable1.add(BigDecimal.valueOf(3));
        resultTable1.add(BigDecimal.valueOf(9));
        assertEquals(resultTable1, resultTableLong,"long failed");
        logger.warn("testMultiplyInt+");

    }

    @Test
    void testMultiplyNotLong() {
        assertNotEquals(3, App.multiplyLong(2, 2, 3));
        logger.warn("testMultiplyNotLong+");

    }

    @Test
    void testMultiplyInt() {
        ArrayList<BigDecimal> resultTable1 = new ArrayList<>();
        for (int i = 1; i < 6; i += 2) {
            for (int j = 1; j < 6; j += 2) {
                resultTable1.add(BigDecimal.valueOf((long) i * j));

            }
        }
        multiplyInteger(6, 1, 2);
        assertEquals(resultTable1, resultTableInt, "failed ");
        logger.warn("testMultiplyInt+");

    }
    @Test
    void testMultiplyIntMul() {
        assertEquals(6, App.multiplyLong(3, 2, 3),"testMultiplyIntMul" );
        logger.warn("testMultiplyNotInt+");


    }
    @Test
    void testMultiplyNotInt() {
        assertNotEquals(10, App.multiplyLong(2, 2, 3));
        logger.warn("testMultiplyNotInt+");

    }

    @Test
    void testMultiplyDouble() {
        ArrayList<BigDecimal> resultTable1 = new ArrayList<>();
        double minimum = 1.5;
        double maximum = 4.5;
        double increment = 1.5;
        for (double i = minimum; i < maximum; i += increment) {
            for (double j = minimum; j < maximum; j += increment) {
                resultTable1.add(BigDecimal.valueOf(i * j));

            }
        }
        multiplyDouble(maximum, minimum, increment);
        assertEquals(resultTable1, resultTableDouble);
        logger.warn("testMultiplyDouble+");

    }

    @Test
    void testMultiplyNotDouble() {
        assertNotEquals(2.24, App.multiplyDouble(1.5, 1.5, 3));
        logger.warn("testMultiplyNotInt+");

    }

    @Test
    void testSysTurn() {
        try {
            sysTurn = System.getProperty("type").toLowerCase();
        } catch (NullPointerException e) {
            sysTurn = "int";
        }
        assertNotEquals("double", sysTurn);
        logger.warn("testSysTurn+");

    }
}


