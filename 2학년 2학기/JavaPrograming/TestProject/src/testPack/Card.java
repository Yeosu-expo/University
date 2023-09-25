package testPack;

public class Card {
    String shape;
    int num;

    public Card(){}

    public Card(String shape, int num){
        this.shape = shape;
        this.num = num;
    }
    public void getCard(){
        int shape = (int)(Math.random()*4);
        int num = (int)(Math.random()*12)+1;

        this.shape = strShape(shape);
        this.num = num;
    }
    public boolean isOverlap(Card rival){
        if(this.num==rival.num&&this.shape==rival.shape)
            return true;
        else
            return false;
    }

    public void printCard(int num){
        System.out.println("Player"+num+": "+this.shape+", "+strNum(this.num));
    }
    
    public void compete(Card rival){
        this.printCard(1);
        rival.printCard(2);

        int res = whoisBig(this, rival);
        if(res==0){
            System.out.println("Player1 won!!");
        }
        else {
            System.out.println("Player2 won!!");
        }
    }
    public int whoisBig(Card c1, Card c2){
        if(c1.num > c2.num){
            return 0;
        }
        else if (c1.num == c2.num){
            if(intShape(c1.shape) < intShape(c2.shape)){
                return 0;
            }
            else {
                return 1;
            }
        }
        else {
            return 1;
        }
    }
    public String strShape(int shape){
        switch (shape) {
            case 0 :
                return "스페이드";
            case 1 :
                return "다이아몬드";
            case 2 :
                return "하트";
            case 3 :
                return "클로버";
        }
        return null;
    }
    public int intShape(String shape){
        switch (shape) {
            case "스페이드" :
                return 0;
            case "다이아몬드" :
                return 1;
            case "하트" :
                return 2;
            case "클로버" :
                return 3;
            default :
                return -1;
        }
    }
    public String strNum(int num){
        switch (num) {
            case 1 :
                return "ACE";
            case 11 :
                return "J";
            case 12 :
                return "Q";
            case 13 :
                return "K";
            default :
                return Integer.toString(num);
        }
    }
}
