package org.core;

import java.util.Optional;
import java.util.Scanner;
import java.util.Random;

public class GameRunner {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            GameLogic gameLogic = new GameLogic(new Random());
            while(true){
                System.out.print("Введите ваш ход (Камень, ножницы, бумага) \n" +
                "Для выхода введите `выход` :");
                String playerInput = sc.nextLine();

                if (playerInput.trim().equalsIgnoreCase("выход")) {
                    System.out.println("Спасибо за игру! До свидания.");
                    break;
                }
                Optional<Field> playerMove = Field.fromString(playerInput);
                if(playerMove.isEmpty()){
                    System.out.println("Некорректный ввод. Попробуйте еще.");
                    continue;
                }

                Field playerInValue = playerMove.get();
                RoundState currentRoundState = gameLogic.calculateRound(playerInValue);

                System.out.println("Ваш ход: " + currentRoundState.getPlayerMove().getName());
                System.out.println("Ход компьютера: " + currentRoundState.getComputerMove().getName());

                switch (currentRoundState.getResult()) {
                    case WIN:
                        System.out.println("Вы выиграли!");
                        break;
                    case LOSE:
                        System.out.println("Вы проиграли.");
                        break;
                    case TIE:
                        System.out.println("Ничья.");
                        break;
                }
           }
        }
    }
}