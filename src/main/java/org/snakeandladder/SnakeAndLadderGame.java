package org.snakeandladder;

import java.util.ArrayList;
import java.util.List;

public class SnakeAndLadderGame {
    private final Board board;
    private final List<Player> players;
    private final Dice dice;
    private int currentPlayerIndex;

    public SnakeAndLadderGame(List<String> playerNames) {
        this.board = new Board();
        this.players = new ArrayList<>();
        for(String player : playerNames) {
            players.add(new Player(player));
        }
        this.currentPlayerIndex = 0;
        this.dice = new Dice();
    }

    public void play() {
        while(!isGameOver()) {
            Player currentPlayer = players.get(currentPlayerIndex);
            int move = dice.roll();
            int newPosition = move + currentPlayer.getPosition();

            if(newPosition <= board.getBoardSize()) {
                int currentPosition = board.MoveAfterSnakeOrLadder(newPosition);
                currentPlayer.setPosition(currentPosition);
                System.out.println(currentPlayer.getName() + " Rolled a" + move + " and moved to " + currentPosition);
            }

            if(currentPlayer.getPosition() == board.getBoardSize()) {
                System.out.println(currentPlayer.getName() + " wins!");
                break;
            }

            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
    }

    public boolean isGameOver() {
        for(Player player : players) {
            if(player.getPosition() == board.getBoardSize()) {
                return true;
            }
        }

        return false;
    }
}
