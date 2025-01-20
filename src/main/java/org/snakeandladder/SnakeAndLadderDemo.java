package org.snakeandladder;

import java.util.Arrays;
import java.util.List;

public class SnakeAndLadderDemo {
    public static void run () {
        GameManager gameManager = GameManager.getInstance();

        List<String> playersA = Arrays.asList("Player 1", "Player 2", "Player 3");
        gameManager.startNewGame(playersA);
    }
}
