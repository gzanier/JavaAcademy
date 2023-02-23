package it.euris.exceptions;


public class CalculatorException extends Exception {
    private String description;

    public CalculatorException(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}

