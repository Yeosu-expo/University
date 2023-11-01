package cardPack;
import application.OneCard;
import application.Uno;
import library.Card;

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