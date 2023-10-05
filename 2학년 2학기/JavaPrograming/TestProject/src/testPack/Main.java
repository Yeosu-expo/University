package testPack;

public class Main{
    public static void main(String[] args){
        Card cardArr[] = new Card[10];

        cardArr[0] = new Card();
        for(int i=1;i<10;i++){
            cardArr[i] = new Card();
            boolean res = cardArr[i].isOverlapInArr(cardArr, cardArr[i], i);

            if(res)
                i--;
        }

        Card sortedArr[];
        sortedArr = cardArr[0].sorting(cardArr);

        System.out.println("정렬 전");
        for(int i=0;i<10;i++) {
            cardArr[i].printCard(i+1);
        }

        System.out.println("\n정렬 후");
        for(int i=0;i<10;i++) {
            sortedArr[i].printCard(i+1);
        }

    }
}