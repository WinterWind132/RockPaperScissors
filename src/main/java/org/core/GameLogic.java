package org.core;

import java.util.Random;

public class GameLogic {
    private final Random random;
    private Field _playerMove;
    private Field _computerMove;
    private GameResult _gameResult;

    public GameLogic() {
        this.random = new Random();
        _computerMove = generateComputerMove();
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

    public void calculateRound(Field playerMove) {
        _playerMove = playerMove;
        _computerMove = generateComputerMove();
        _gameResult = determineWinner(_playerMove, _computerMove);
    }

    public Field getPlayerMove() {
        return _playerMove;
    }

    public Field getComputerMove() {
        return _computerMove;
    }

    public GameResult getGameResult() {
        return _gameResult;
    }
}
