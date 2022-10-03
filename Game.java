import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {
    private static ArrayList<Cards> cards = new ArrayList<Cards>(36);

    public static ArrayList<Cards> createDeck () {
        for (int i = 0; i < 4; i++) {
            cards.add(new Cards("Валет", 2));
        }

        for (int i = 0; i < 4; i++) {
            cards.add(new Cards("Дама", 3));
        }

        for (int i = 0; i < 4; i++) {
            cards.add(new Cards("Король", 4));
        }

        for (int i = 0; i < 4; i++) {
            cards.add(new Cards("Туз", 11));
        }

        for (int i = 0; i < 4; i++) {
            cards.add(new Cards("Шестёрка", 6));
        }

        for (int i = 0; i < 4; i++) {
            cards.add(new Cards("Семёрка", 7));
        }

        for (int i = 0; i < 4; i++) {
            cards.add(new Cards("Восьмёрка", 8));
        }

        for (int i = 0; i < 4; i++) {
            cards.add(new Cards("Девятка", 9));
        }

        for (int i = 0; i < 4; i++) {
            cards.add(new Cards("Десятка", 10));
        }

        Collections.shuffle(cards);
        return cards;

    }

    public static void startGame(int numberCard, ArrayList<Cards> deck) {
        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();

        if (action == 1) {
            numberCard ++;
            Points.userPoints += deck.get(numberCard).point;
            System.out.println("Вы добрали ещё одну карту " + deck.get(numberCard).name + ". Теперь у вас " + Points.userPoints + " очков.");

            if (Points.computerPoints <= 16) {
                numberCard ++;
                Points.computerPoints += deck.get(numberCard).point;
                System.out.println("Компьютер решил добрать ещё одну карту " + deck.get(numberCard).name + ". Теперь у него " + Points.computerPoints + " очков.");
            } else {
                System.out.println("Компьютер спасовал.");
            }

            if (Points.userPoints == 21 && Points.computerPoints == 21) {
                System.out.println("Ничья. У игрока и компьютера 21 очко.");
            } else if (Points.userPoints == 21) {
                System.out.println("Вы набрали 21 очко и победили.");
            } else if (Points.computerPoints == 21) {
                System.out.println("Компьютер набрал 21 очко и победил.");
            } else if (Points.userPoints > 21 && Points.computerPoints > 21) {
                System.out.println("Игрок и компьютер набрали более 21 очка. Ничья.");
            } else if (Points.userPoints > 21) {
                System.out.println("Вы набрали больше 21 очка. Поражение.");
            } else if (Points.computerPoints > 21) {
                System.out.println("Компьютер набрал больше 21 очка. Победа.");
            } else {
                startGame(numberCard, deck);
            }
        } else if (action == 0) {
            if (21 - Points.userPoints < 21 - Points.computerPoints) {
                while (Points.computerPoints < 17 || 21 - Points.userPoints < 21 - Points.computerPoints) {
                    numberCard++;
                    Points.computerPoints += deck.get(numberCard).point;
                    System.out.println("Компьютер решил добрать ещё одну карту " + deck.get(numberCard).name + ". Теперь у него " + Points.computerPoints + " очков.");
                }
            }
            if (21 - Points.userPoints > 21 - Points.computerPoints) {
                System.out.println("Вы проиграли.");
            } else if (21 - Points.userPoints == 21 - Points.computerPoints) {
                System.out.println("Игрок и компьютер набрали одинаковое число очков. Ничья.");
            } else {
                System.out.println("Вы победили.");
            }
        } else {
            System.out.println("Вы ввели неправильное значение");
        }
    }

}
