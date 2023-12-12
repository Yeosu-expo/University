import java.util.HashSet;

import java.util.Iterator;

class Card {
    public String type;
    public int number;

    public void randomCard() {
        int shape = (int) (Math.random() * 4);
        int num = (int) (Math.random() * 12) + 1;

        this.type = strShape(shape);
        this.number = num;
    }

    public int hashCode() {
        return this.type.hashCode() + this.type.hashCode();
    }

    public boolean equals(Object obj) {
        Card tmp;
        if (obj instanceof Card)
            tmp = (Card) obj;
        else
            return false;

        if (this.type == tmp.type && this.number == tmp.number)
            return true;
        return false;
    }

    public String strShape(int shape) {
        switch (shape) {
            case 0:
                return "a";
            case 1:
                return "b";
            case 2:
                return "c";
            case 3:
                return "b";
        }
        return null;
    }

    public String strNum(int num) {
        switch (num) {
            case 1:
                return "ACE";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            default:
                return Integer.toString(num);
        }
    }

    public int intType() {
        switch (this.type) {
            case "SPADE":
                return 0;
            case "DIAMOND":
                return 1;
            case "HEART":
                return 2;
            case "CLOVER":
                return 3;
        }
        return -1;
    }
}

class Player {
    private String name;
    private HashSet<Card> cards;

    public Player(String name) {
        this.name = name;

        int cnt = 0;
        while (cnt != 7) {
            Card newCard = new Card();
            newCard.randomCard();

            Iterator<Card> it = cards.iterator();
            boolean sign = false;
            while (it.hasNext()) {
                if (it.next().equals(newCard)) {
                    sign = true;
                    break;
                }
            }
            if (!sign) {
                if (cardCheck[newCard.intType()][newCard.number] == false) {
                    cnt++;
                    cards.add(newCard);
                    cardCheck[newCard.intType()][newCard.number] = true;
                }
            }
        }
    }

    public Card selectCard() {
        if (cards.size() == 0) {
            if (!drawCard()) {
                return null;
            }
        }
        Iterator<Card> it = cards.iterator();
        return it.next();
    }

    public boolean drawCard() {
        while (true) {
            if (!checkerCheck())
                return false;
            Card newCard = new Card();
            newCard.randomCard();
            if (cardCheck[newCard.intType()][newCard.number] == false) {
                cards.add(newCard);
                cardCheck[newCard.intType()][newCard.number] = true;
                break;
            }
        }
        return true;
    }

    public boolean showCard(Card card) {
        Iterator<Card> it = cards.iterator();
        while (it.hasNext()) {
            Card hasCard = it.next();
            if (hasCard.type == card.type || hasCard.number == card.number) {
                cards.remove(hasCard);
                break;
            }
        }
        if (!drawCard()) {
            // System.out.println(name + ": LOSE");
            return false;
        }
        return true;
    }

    static boolean[][] cardCheck = new boolean[4][14];

    static void initChecker() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 14; j++)
                cardCheck[i][j] = false;
        }

        for (int i = 0; i < 4; i++)
            cardCheck[i][0] = true;
    }

    static boolean checkerCheck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; i < 14; j++)
                if (cardCheck[i][j] == false)
                    return true;
        }
        return false;
    }

    static void run(Player p1, Player p2) {
        boolean endSign = false;
        boolean p1Turn = true;
        boolean p1LoseSign = false;
        boolean p2LoseSign = false;
        while (!endSign) {
            if (p1Turn) {
                Card tmp = p2.selectCard();
                if (tmp == null) {
                    p1LoseSign = true;
                    break;
                }
                p1.showCard(tmp);
                p1Turn = false;
            } else {
                Card tmp = p1.selectCard();
                if (tmp == null) {
                    p2LoseSign = true;
                    break;
                }
                p2.showCard(tmp);
                p1Turn = true;
            }

            if (p1LoseSign) {
                System.out.println(p1.name + " LOSE.");
                break;
            }
            if (p2LoseSign) {
                System.out.println(p2.name + " LOSE.");
                break;
            }
        }
    }

    public class App {
        public static void main(String[] args) throws Exception {
            initChecker();

            Player player1 = new Player("KIM");
            Player player2 = new Player("LEE");

            run(player1, player2);
        }
    }
}
