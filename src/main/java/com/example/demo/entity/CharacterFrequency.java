package com.example.demo.entity;

public class CharacterFrequency {
    private char symbol;
    private int count;

    public CharacterFrequency(char symbol, int count) {
        this.symbol = symbol;
        this.count = count;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}