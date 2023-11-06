package cardPack;
import application.OneCard;

public class Main2{
    public static void main(String[] args){
        OneCard oneCard = new OneCard();
        oneCard.showCard();

        int count =1;
        while(true){
            OneCard oneCard2 = new OneCard();
            if(oneCard.equals(oneCard2)){
                double probability = (1/(double)count)*100;
                System.out.println("probability: "+probability+"%");
                break;
            }
            count++;
        }
    }
}