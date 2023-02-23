package it.euris;

import it.euris.exceptions.CalculatorException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CalcolatriceTest {
    @Test
    @DisplayName("1 + 1 = 2")
    void addTwoNumbers() {
        Calcolatrice calcolatrice = new Calcolatrice();
        assertEquals(2, calcolatrice.add(1, 1), "1 +1 should be 2");
    }

    @Test
    @DisplayName("4 + 5 = 9")
    void addTwoNumbers_2() {
        Calcolatrice calcolatrice = new Calcolatrice();
        assertNotEquals(10, calcolatrice.add(4, 5), "4 +5 should be 9");
    }

    @Test
    @DisplayName("1 - 1 = 0")
    void subTwoNumbers() {
        Calcolatrice calcolatrice = new Calcolatrice();
        assertEquals(0, calcolatrice.sub(1, 1), "1 - 1 should be 0");
    }

    @Test
    @DisplayName("4 - 5 = -1")
    void subTwoNumbers_2() {
        Calcolatrice calcolatrice = new Calcolatrice();
        assertNotEquals(0, calcolatrice.sub(4, 5), "4 - 5 should not be 0");
    }

    @Test
    @DisplayName("1 * 1 = 1")
    void mulTwoNumbers() {
        Calcolatrice calcolatrice = new Calcolatrice();
        assertEquals(1, calcolatrice.mul(1, 1), "1 * 1 should be 1");
    }

    @Test
    @DisplayName("4 * 5 = 20")
    void mulTwoNumbers_2() {
        Calcolatrice calcolatrice = new Calcolatrice();
        assertNotEquals(0, calcolatrice.mul(4, 5), "4 * 5 should not be 0");
    }

    @Test
    @DisplayName("1 / 1 = 1")
    void divTwoNumbers() {
        Calcolatrice calcolatrice = new Calcolatrice();
        assertEquals(1, calcolatrice.div(1, 1), "1 / 1 should be 1");
    }

    @Test
    @DisplayName("4 / 5 = 0")
    void divTwoNumbers_2() {
        Calcolatrice calcolatrice = new Calcolatrice();
        assertEquals(1, calcolatrice.div(4, 5), "4 / 5 should be 0");
    }

    @Test
    @DisplayName("12 / 8 = 0")
    void divTwoNumbers_3() {
        Calcolatrice calcolatrice = new Calcolatrice();
        assertNotEquals(0, calcolatrice.div(12, 8), "12 / 8 should not be 0");
    }

    @Test
    @DisplayName("12 / 0  = 0")
    void divTwoNumbers_4() {
        Calcolatrice calcolatrice = new Calcolatrice();
        assertThrows(CalculatorException.class, () -> calcolatrice.div(12,0));
        //assertNotEquals(0, calcolatrice.div(12, 0), "12 / 0 should not be 0");
    }

    @Test
    @DisplayName("2 ^ 5  = 32")
    void powTwoNumbers() {
        Calcolatrice calcolatrice = new Calcolatrice();
        assertEquals(32, calcolatrice.pow(2, 5), "2 ^ 5 should not be 32");
    }

    @Test
    @DisplayName("3 ^ 3  = 27")
    void powTwoNumbers_2() {
        Calcolatrice calcolatrice = new Calcolatrice();
        assertNotEquals(28, calcolatrice.pow(3, 3), "3 ^ 3 should not be 28");
    }

    @Test
    @DisplayName("0 ^ 0  = ?")
    void powTwoNumbers_3() {
        Calcolatrice calcolatrice = new Calcolatrice();
        assertEquals(1, calcolatrice.pow(0, 0), "0 ^ 0 =1");
    }

    @Test
    @DisplayName("radice di 4  = 2")
    void sqrtOneNumber() {
        Calcolatrice calcolatrice = new Calcolatrice();
        assertEquals(2, calcolatrice.sqrt(4), " radice di 4  = 2");
    }

    @Test
    @DisplayName("radice di 0  = 0")
    void sqrtOneNumber_2() {
        Calcolatrice calcolatrice = new Calcolatrice();
        assertEquals(0, calcolatrice.sqrt(0), "radice di 0  = 0");
    }


    @Test
    @DisplayName("radice di -4  != 0")
    void sqrtOneNumber_3() {
        Calcolatrice calcolatrice = new Calcolatrice();
        assertEquals(0, calcolatrice.sqrt(-4), "radice di -4  != 0");
    }

}