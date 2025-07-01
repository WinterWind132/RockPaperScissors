package org.core;

import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            GameLogic gameLogic = new GameLogic();
            Field playerMove = null;

            //while(true){
            System.out.print("Введите ваш ход (Камень, ножницы, бумага) : ");
            String playerIn = sc.nextLine();
            try {
                playerMove = Field.valueOf(playerIn.toUpperCase());
            }
            catch (IllegalArgumentException e) {
                System.out.println("Некорректный ввод. Попробуйте еще.");
                //continue;
            }
            gameLogic.calculateRound(playerMove);

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
            //}
        }
    }
}