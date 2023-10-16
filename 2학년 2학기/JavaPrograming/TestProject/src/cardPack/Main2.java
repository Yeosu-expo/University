package cardPack;

class Card {
    String type;
    int number;
    public void randomCard() {
        int shape = (int)(Math.random()*4);
        int num = (int)(Math.random()*12)+1;

        this.type = strShape(shape);
        this.number = num;
    }
    public String strShape(int shape) {
        switch (shape) {
            case 0 :
                return "a";
            case 1 :
                return "b";
            case 2 :
                return "c";
            case 3 :
                return "b";
        }
        return null;
    }
    public String strNum(int num){
        switch (num) {
            case 1 :
                return "ACE";
            case 11 :
                return "Jack";
            case 12 :
                return "Queen";
            case 13 :
                return "King";
            default :
                return Integer.toString(num);
        }
    }
    public void showCard(){
        System.out.println("type: " + type + ", number: " + number);
    }
}

class OneCard extends Card {
    public String strShape(int shape) {
        switch (shape) {
            case 0 :
                return "SPADE";
            case 1 :
                return "DIAMOND";
            case 2 :
                return "HEART";
            case 3 :
                return "CLOVER";
        }
        return null;
    }
    public void showCard(){
        System.out.println("type: "+type+", number: "+strNum(number));
    }
}

class Uno extends Card {
    public String strShape(int shape) {
        switch (shape) {
            case 0 :
                return "Red";
            case 1 :
                return "Yellow";
            case 2 :
                return "Green";
            case 3 :
                return "Blue";
        }
        return null;
    }
    public String strNum(int num){
        switch (num) {
            case 11 :
                return "Skip";
            case 12 :
                return "Reverse";
            case 13 :
                return "Draw";
            default :
                return Integer.toString(num);
        }
    }
    public void showCard() {
        System.out.println("type: "+type+", number: "+strNum(number));
    }
}

public class Main2{
    public static void main(String[] args){
        Card cardArr[] = new Card[3];
        cardArr[0] = new Card();
        cardArr[0].randomCard();
        cardArr[1] = new OneCard();
        cardArr[1].randomCard();
        cardArr[2] = new Uno();
        cardArr[2].randomCard();

        for(int i=0;i<3;i++){
            cardArr[i].showCard();
        }
    }
}