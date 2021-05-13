package com.example.springboot.exception;

public class NotEnoughAgeException extends Exception {

    public NotEnoughAgeException() {
        super("Not enough age!");
    }
}
