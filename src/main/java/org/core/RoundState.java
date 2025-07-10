package org.core;

public class RoundState {
    private final Field playerMove;
    private final Field computerMove;
    private final GameResult result;

    public RoundState(Field playerMove, Field computerMove, GameResult result) {
        this.playerMove = playerMove;
        this.computerMove = computerMove;
        this.result = result;
    }

    public Field getPlayerMove() {
        return playerMove;
    }

    public Field getComputerMove() {
        return computerMove;
    }

    public GameResult getResult() {
        return result;
    }
}