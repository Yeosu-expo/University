package testPack;

import java.util.Scanner;

public class App {
    public static void getInfo(Scanner sc) {
        System.out.println("이름, 응시번호 6자리를 공백으로 구분해서 입력하시오.");
        sc.next();
        int testNum = sc.nextInt();

        if(testNum%2 == 1){
            gaType(sc);
        }
        else {
            naType(sc);
        }
    }

    public static boolean isPass(int score[]) {
        if(score[0]>40 && score[1]>40 && score[2]>40 && score[3]>40){

        }
        else{
            return false;
        }
        double avg = (double)(score[0]+score[1]+score[2]+score[3])/4;
        if(avg >= 80){
            return true;
        }
        return false;
    }

    public static void finalResult(boolean res){
        if(res){
            System.out.println("시험 합격!");
        }
        else{
            System.out.println("시험 불합격!");
        }
    }

    public static void gaType(Scanner sc){
        int score[] = new int[4];
        System.out.print("한국어: ");
        score[0] = sc.nextInt();
        System.out.print("컴퓨터구조: ");
        score[1] = sc.nextInt();
        System.out.print("데이터베이스: ");
        score[2] = sc.nextInt();
        System.out.print("소프트웨어공학: ");
        score[3] = sc.nextInt();

        boolean res = isPass(score);
        finalResult(res);
    }

    public static void naType(Scanner sc){
        int score[] = new int[4];
        System.out.print("한국어: ");
        score[0] = sc.nextInt();
        System.out.print("영어: ");
        score[1] = sc.nextInt();
        System.out.print("세법: ");
        score[2] = sc.nextInt();
        System.out.print("국제법: ");
        score[3] = sc.nextInt();

        boolean res = isPass(score);
        finalResult(res);
    }
    
    public static void main(String[] args) throws Exception {
        var sc = new Scanner(System.in);
        getInfo(sc);
    }
}