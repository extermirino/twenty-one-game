import java.util.*;

public class TwentyOne {

    public static void main(String[] args) {

        int numberCard = 3;

        ArrayList<Cards> deck = Game.createDeck();

        System.out.println("Правила игры: для того чтобы получить карту, нажмите 1. Для того чтобы прекратить добор карт, нажмите 2.");
        System.out.println("Победит тот, у кого в общей сумме наберется 21 очко, либо тот, чья сумма очков будет ближе всего к 21.");
        System.out.println("Если у вас наберётся более 21 очка, вы проигрываете. \n");

        System.out.println("Ваши карты: " + deck.get(0).name + ", " + deck.get(1).name + ", количество ваших очков: " + Points.startUserPoints(deck) + ". \nКарты компьютера: " + deck.get(2).name + ", " + deck.get(3).name + ". Количество очков у компьютера: " + Points.startComputerPoints(deck));
        if (deck.get(0).name.equals("Туз") && deck.get(1).name.equals("Туз") && deck.get(2).name.equals("Туз") && deck.get(3).name.equals("Туз")) {
                System.out.println("Ничья. Игрок и Компьютер получили по два Туза.");
        } else if (deck.get(0).name.equals("Туз") && deck.get(1).name.equals("Туз")) {
            System.out.println("Игрок получает два Туза и побеждает.");
        } else if (deck.get(2).name.equals("Туз") && deck.get(3).name.equals("Туз")) {
            System.out.println("Компьютер получает два Туза и побеждает.");
        } else {
            Game.startGame(numberCard, deck);
        }

    }
}