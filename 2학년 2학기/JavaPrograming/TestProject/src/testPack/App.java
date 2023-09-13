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

    public static boolean isPass(int t1, int t2, int t3, int t4) {
        if(t1>40 && t2>40 && t3>40 && t4>40){

        }
        else{
            return false;
        }
        double avg = (double)(t1+t2+t3+t4)/4;
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
        System.out.print("한국어: ");
        int ko = sc.nextInt();
        System.out.print("컴퓨터구조: ");
        int cs = sc.nextInt();
        System.out.print("데이터베이스: ");
        int db = sc.nextInt();
        System.out.print("소프트웨어공학: ");
        int se = sc.nextInt();

        boolean res = isPass(ko, cs, db, se);
        finalResult(res);
    }

    public static void naType(Scanner sc){
        System.out.print("한국어: ");
        int ko = sc.nextInt();
        System.out.print("영어: ");
        int en = sc.nextInt();
        System.out.print("세법: ");
        int tax = sc.nextInt();
        System.out.print("국제법: ");
        int law = sc.nextInt();

        boolean res = isPass(ko, en, tax, law);
        finalResult(res);
    }
    
    public static void main(String[] args) throws Exception {
        var sc = new Scanner(System.in);
        getInfo(sc);
    }
}
