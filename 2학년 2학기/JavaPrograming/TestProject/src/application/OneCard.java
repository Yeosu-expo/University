package application;
import library.Card;

public class OneCard extends Card{
    public OneCard(){
        this.draw();
    }
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
    @Override
    public boolean equals(Card card) {
        if(this.type == card.type && this.number == card.number)
            return true;
        else
            return false;
    }
}

