package library;

public abstract class Card implements Comparable<Card>{
    public String type;
    public int number;
    // public String getType(){
    //     return type;
    // }
    // public int getNum(){
    //     return number;
    // }
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
    abstract public boolean equals(Card card);
}


