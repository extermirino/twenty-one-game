import java.util.ArrayList;

public class Points {
    static int userPoints = 0;
    static int computerPoints = 0;


    public static int startUserPoints (ArrayList<Cards> cards) {
        return userPoints = cards.get(0).point + cards.get(1).point;
    }

    public static int startComputerPoints (ArrayList<Cards> cards) {
        return computerPoints = cards.get(2).point + cards.get(3).point;
    }

}
