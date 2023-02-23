package it.euris;

import it.euris.exceptions.CalculatorException;

public class Calcolatrice {

    public Calcolatrice() {
    }

    public Integer add(Integer a, Integer b) {
        return a + b;
    }

    public Integer sub(Integer a, Integer b) {
        return a - b;
    }

    public Integer mul(Integer a, Integer b) {
        return a * b;
    }

    public Integer div(Integer a, Integer b) throws CalculatorException {

        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("Catturata eccezione: " + e.getMessage());
            throw new CalculatorException("Eccezione calcolatore divisione per 0");
        }

    }

    public Integer pow(Integer a, Integer b) {
        Integer result = null;
        try {
            result = (int) Math.pow(a, b);
        } catch (ArithmeticException e) {
            System.out.println("Catturata eccezione: " + e.getMessage());
        }
        return result;

    }

    public int sqrt(int a) throws CalculatorException {
        if (a < 0)
            throw new CalculatorException("Calcolatore radice quadrata di un numero negativo");
        else {
            return (int) Math.sqrt(a);

        }

    }
}
