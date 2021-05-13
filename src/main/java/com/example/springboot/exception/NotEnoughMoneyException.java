package com.example.springboot.exception;

public class NotEnoughMoneyException extends Exception {

    public NotEnoughMoneyException() {
        super("Not enough money!");
    }
}
