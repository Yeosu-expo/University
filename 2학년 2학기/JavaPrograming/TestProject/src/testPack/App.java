package testPack;

import java.util.Scanner;

public class App {
    public static double Celcious(double num){
        double result = (num*9/5) + 32; // 섭씨에서 화씨 변환하는 수학공식
        return result;
    }
    public static void main(String[] args) throws Exception {
        final double MILE = 1.60934; // 1마일은 1.60934킬로미터 입니다.
        
        Scanner sc = new Scanner(System.in); // 입력 인스턴스 생성
        for(int i=0;i<5;i++){
            System.out.print("mile? ");
            double mile = sc.nextDouble();
            System.out.println("95마일은 "+MILE*mile+"킬로미터 입니다.");
        }

        System.out.println();

        for(int i=0; i<5;i++){
            System.out.print("Celcious? ");
            double cel = sc.nextDouble();
            System.out.println("섭씨 "+ cel +"도는 화씨 "+ Celcious(cel) + "입니다.");
        }
    }
}
