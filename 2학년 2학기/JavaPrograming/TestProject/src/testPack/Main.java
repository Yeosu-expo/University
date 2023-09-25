package testPack;

import java.util.Scanner;

public class Main{
    
    static void cardRun(){
        var sc = new Scanner(System.in);
            System.out.print("How many player? ");
            int number = sc.nextInt();

            Card players[] = new Card[number];

            int[][] check = new int[4][13];
            int shape, num;
            for(int i=0;i<number;i++){
                while(true){
                    shape = (int)(Math.random()*4);
                    num = (int)(Math.random()*12)+1;
                    if(check[shape][num-1]==0){
                        check[shape][num-1]=1;
                        break;
                    }
                }
                players[i] = new Card(null, 0);
                players[i].shape = players[i].strShape(shape);
                players[i].num = num;
            }

            for(int i=0;i<number;i++){
                System.out.println("Player"+(i+1)+": "+players[i].shape+" "+players[i].num);
            }

            int st=0;
            Card card = new Card(null, 0);
            for(int i=1;i<number;i++){
                int res = card.whoisBig(players[st], players[i]);
                if(res == 1)
                    st = i;
            }
            System.out.println("Player"+(st+1)+" won!!");

            sc.close();
    }
    public static void main(String[] args){
        Card card1 = new Card();
        Card card2 = new Card();
        card1.getCard();
        while(true){
            card2.getCard();
            if(!card1.isOverlap(card2))
                break;
        }

        card1.compete(card2);
    }
}