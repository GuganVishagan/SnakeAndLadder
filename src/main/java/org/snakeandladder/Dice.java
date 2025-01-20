package org.snakeandladder;

public class Dice {
    private static final int INT_MIN = 1;
    private static final int INT_MAX = 6;

    public int roll() {
        return (int) (Math.random() * (INT_MAX - INT_MIN + 1) + INT_MIN);
    }
}
