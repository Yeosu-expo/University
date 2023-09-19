package testPack;

import java.util.Scanner;

public class enumTest {
    public enum Week{월, 화, 수 , 목, 금, 토, 일};
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
            System.out.print("요일을 입력하세요: ");
            int today = scanner.nextInt();

        for (Week day: Week.values()){
            if(today == day.ordinal()){
                if(day.ordinal()==0)
                    System.out.println("오늘은 "+day+"요일입니다. 주중이고, 자바를 공부합니다");
                if(day.ordinal()==1)
                    System.out.println("오늘은 "+day+"요일입니다. 주중이고, 자료구조를 공부합니다");
                if(day.ordinal()==2)
                    System.out.println("오늘은 "+day+"요일입니다. 주중이고, C++을 공부합니다");
                if(day.ordinal()==3)
                    System.out.println("오늘은 "+day+"요일입니다. 주중이고, 컴퓨터구조를 공부합니다");
                if(day.ordinal()==4)
                    System.out.println("오늘은 "+day+"요일입니다. 주중이고, 휴식을 취합니다");
                if(day.ordinal()==5)
                    System.out.println("오늘은 "+day+"요일입니다. 주말이고, 개인공부를 합니다");
                if(day.ordinal()==6)
                    System.out.println("오늘은 "+day+"요일입니다. 주말이고, 게임을 합니다");
            }
        }
        scanner.close();
    }``````
}