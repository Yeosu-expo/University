package testPack;

import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        String[] fruits = {"Strawberry", "Watermelon", "Apple", "Orange", "Banana", "Blueberry"};
        int index = (new Random()).nextInt(fruits.length);
        String solution = fruits[index];
        StringBuffer ans = new StringBuffer(solution.length());
        for(int i=0;i<solution.length();i++){
            ans.append("_");
        }
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("Input a character: ");
            String input = sc.next();
            for(int i=0;i<solution.length();i++){
                if(solution.charAt(i) == input.charAt(0)){
                    ans.replace(i, i+1, input);
                }
            }
            StringTokenizer st = new StringTokenizer(solution);
            int isOK = 0;
            
            String token = st.nextToken();
            if(ans.toString().equals(token)){
                isOK = 1;
            }
            System.out.println(ans);
            if (isOK==1) {
                System.out.println("Your Right");
                break;
            }
        }
        sc.close();
    }
}