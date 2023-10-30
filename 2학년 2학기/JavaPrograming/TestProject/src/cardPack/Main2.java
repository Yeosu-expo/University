package cardPack;

abstract class Card implements Comparable<Card>{
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
    public int intType(){
        switch (this.type) {
            case "SPADE" :
                return 0;
            case "DIAMOND" :
                return 1;
            case "HEART" :
                return 2;
            case "CLOVER" :
                return 3;
        }
        return -1;
    }
    public void showCard(){
        System.out.println("type: " + type + ", number: " + number);
    }
    public static void printRes(Card winner, Card loser){
        System.out.println("Winner:"+ winner.type+", "+ winner.number);
        System.out.println("Loser:"+ loser.type+", "+ loser.number);
    }
    abstract public void draw();
    abstract public int compareTo(Card rival);
}

class OneCard extends Card{
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
    @Override
    public void draw(){
        int shape = (int)(Math.random()*4);
        int num = (int)(Math.random()*12)+1;

        this.type = strShape(shape);
        this.number = num;
    }
    @Override
    public int compareTo(Card rival){
        int myType = this.intType();
        int rivalType = rival.intType();
        if(myType < rivalType){
            return 1;
        }
        else if(myType < rivalType){
            return 2;
        }
        else{
            if(this.number > rival.number){
                return 1;
            }
            else{
                return 2;
            }
        }
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
    @Override
    public void draw(){
        int shape = (int)(Math.random()*4);
        int num = (int)(Math.random()*12)+1;

        this.type = strShape(shape);
        this.number = num;
    }
    @Override
    public int compareTo(Card rival){
        if(this.number > rival.number){
            return 1;
        } 
        else
            return 2;
    }
}

public class Main2{
    public static void main(String[] args){
        Card cardArr[] = new Card[4];
        cardArr[0] = new OneCard();
        cardArr[0].draw();
        cardArr[1] = new OneCard();
        cardArr[1].draw();
        cardArr[2] = new Uno();
        cardArr[2].draw();
        cardArr[3] = new Uno();
        cardArr[3].draw();

        for(int i=0;i<4;i++){
            cardArr[i].showCard();
        }
        int res = cardArr[0].compareTo(cardArr[1]);
        if(res == 1){
            Card.printRes(cardArr[0], cardArr[1]);
        }
        else if(res == 2){
            Card.printRes(cardArr[1], cardArr[0]);
        }
        res = cardArr[2].compareTo(cardArr[3]);
        if(res == 1){
            Card.printRes(cardArr[2], cardArr[3]);
        }
        else if(res == 2){
            Card.printRes(cardArr[3], cardArr[2]);
        }
    }
}