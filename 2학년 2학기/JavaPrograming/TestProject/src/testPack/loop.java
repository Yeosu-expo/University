package testPack;

import java.util.Scanner;

public class loop{
    static String strShape(int shape){
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
    static int intShape(String shape){
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

    static String strNum(int num){
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
    
    static class Player {
        String shape;
        int num;

        Player(String shape, int num){
            this.shape = shape;
            this.num = num;
        }
    }

    static int whoisBig(Player p1, Player p2){
        if(p1.num > p2.num){
            return 0;
        }
        else if (p1.num == p2.num){
            if(intShape(p1.shape) < intShape(p2.shape)){
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

    public static void main(String[] args){
        var sc = new Scanner(System.in);
        System.out.print("How many player? ");
        int number = sc.nextInt();

        Player players[] = new Player[number];
        
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
            players[i] = new Player(null, 0);
            players[i].shape = strShape(shape);
            players[i].num = num;
        }

        for(int i=0;i<number;i++){
            System.out.println("Player"+(i+1)+": "+players[i].shape+" "+players[i].num);
        }
        
        int st=0;
        for(int i=1;i<number;i++){
            int res = whoisBig(players[st], players[i]);
            if(res == 1)
                st = i;
        }
        System.out.println("Player"+st+" won!!");

        sc.close();
    }
}