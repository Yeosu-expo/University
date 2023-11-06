package application;
import library.Card;

public class Uno extends Card {
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
    @Override
    public boolean equals(Card card){
        return true;
    }
}
