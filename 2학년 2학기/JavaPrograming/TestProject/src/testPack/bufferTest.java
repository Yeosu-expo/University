package testPack;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class bufferTest {
    static String root = "C:\\Users\\akqjq\\Desktop\\Github\\University\\2학년 2학기\\JavaPrograming\\TestProject\\src\\testPack\\";
    static String fileName = "real.pdf";
    static String copyFile = "copy.pdf";
    static String copyFile2 = "copy2.pdf";
    public static void main(String[] args) {
        long before;
        long after;
        FileInputStream bt;
        FileOutputStream btOut;
        Vector<Integer> input = new Vector<>();
        before = System.currentTimeMillis();
        try {
            bt = new FileInputStream(root + fileName);
            int c;
            int index = 0;
            while((c = bt.read()) != -1){
                input.add(c);
                index++;
            }
            bt.close();
            
            btOut = new FileOutputStream(root + copyFile);
            for(int i=0;i<index;i++){
                btOut.write(input.get(i));
            }
            btOut.close();
        } catch (IOException e) {
            System.out.println("Wrong File Name.");
            return;
        }

        after = System.currentTimeMillis();
        System.out.println("Byte Time: "+(after-before)/1000);
        BufferedReader bfIn;
        BufferedWriter bfOut;
        Vector<Integer> input2 = new Vector<>();
        before = System.currentTimeMillis();
        try {
            bfIn = new BufferedReader(new FileReader(fileName));
            int c;
            int index = 0;
            while((c = bfIn.read()) != -1){
                input2.add(c);
                index++;
            }
            bfIn.close();
            
            bfOut = new BufferedWriter(new FileWriter(root + copyFile2));
            for(int i=0;i<index;i++){
                bfOut.write(input2.get(i));
            }
            bfOut.close();
        } catch (IOException e) {
            System.out.println("Wrong File Name.");
            return;
        }
        after = System.currentTimeMillis();
        System.out.println("Buffer Time: "+(after-before)/1000);
    }
}