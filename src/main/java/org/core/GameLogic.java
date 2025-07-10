package org.core;

import java.util.Random;

public class GameLogic {
    private final Random random;

    public GameLogic(Random random) {
        this.random = random;
    }

    private Field generateComputerMove() {
        Field[] allMoves = Field.values();
        int computerMoveIndex = random.nextInt(allMoves.length);
        return allMoves[computerMoveIndex];
    }

    private GameResult determineWinner(Field playerMove, Field computerMove) {
        if (playerMove == computerMove) {
            return GameResult.TIE;
        }

        if ((playerMove == Field.ROCK && computerMove == Field.SCISSORS) ||
                (playerMove == Field.PAPER && computerMove == Field.ROCK) ||
                (playerMove == Field.SCISSORS && computerMove == Field.PAPER)) {
            return GameResult.WIN;
        }
        else {
            return GameResult.LOSE;
        }
    }

    public RoundState calculateRound(Field playerMove) {
        Field computerMove = generateComputerMove();
        GameResult gameResult = determineWinner(playerMove, computerMove);
        return new RoundState(playerMove, computerMove, gameResult);
    }
}