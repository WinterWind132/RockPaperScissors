package org.core;

import java.util.Optional;
import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            GameLogic gameLogic = new GameLogic(); //Стоит задуматься мб через DI передавать в конструктор new Random!!!
            while(true){
                System.out.print("Введите ваш ход (Камень, ножницы, бумага) : ");
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
                gameLogic.calculateRound(playerInValue);

                System.out.println("Ваш ход: " + gameLogic.getPlayerMove().getName());
                System.out.println("Ход компьютера: " + gameLogic.getComputerMove().getName());

                switch (gameLogic.getGameResult()) {
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