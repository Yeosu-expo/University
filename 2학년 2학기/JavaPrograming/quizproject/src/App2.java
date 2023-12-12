import java.io.*;
import java.util.*;

public class App2 {
    static String root = "C:\\Users\\akqjq\\Desktop\\Github\\University\\2학년 2학기\\JavaPrograming\\quizproject\\src\\";
    static String encodedFile = "ciphertext.txt";

    public static void main(String[] args) {
        FileReader fr;
        FileWriter fi;
        Vector<Character> decodedInput = new Vector<Character>();
        String decodedFile = "";
        try {
            fr = new FileReader(root + encodedFile);
            Vector<Integer> input = new Vector<>();

            int c;
            while ((c = fr.read()) != -1) {
                input.add(c);
            }

            int interval = 0;
            while (true) {
                Iterator<Integer> it = input.iterator();

                while (it.hasNext()) {
                    decodedInput.add((char) (it.next() + interval));
                }

                for (Character cc : decodedInput) {
                    decodedFile += cc;
                }

                if (interval == 11) {
                    break;
                }
                decodedFile = decodedFile.toLowerCase();
                boolean res = decodedFile.contains("password");
                if (res) {
                    System.out.println("KEY: " + interval + ", Found.");
                    break;
                }

                System.out.println("Key:" + interval + ", Failed.");
                interval++;
                decodedInput.clear();
                decodedFile = "";
            }

            fr.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("NO NAME!");
            return;
        }

        try {
            fi = new FileWriter(root + "decodedFile.txt");

            Iterator<Character> it = decodedInput.iterator();
            while (it.hasNext()) {
                fi.write(it.next());
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("NO NAME.");
        }
        System.out.println("DONE");
    }
}
