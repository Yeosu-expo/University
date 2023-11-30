package testPack;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Cipher {
    static int encodingInterval = 3;
    static String root = "C:\\Users\\akqjq\\Desktop\\Github\\University\\2학년 2학기\\JavaPrograming\\TestProject\\src\\testPack\\";
    static String inputFile = "input.txt";
    static String encodingFile = "enc.txt";
    static String recoverdFile = "recover.txt";
    public static void main(String[] args) {
        FileReader fp;
        int input[] = new int[1000];
        int cnt = 0;

        // read File
        try{
            fp = new FileReader(root + inputFile);
            int c;
            while ((c = fp.read()) != -1) {
                input[cnt++] = c;
            }

            fp.close();
        }
        catch(IOException e){
            System.out.println("Input Error");
            return;
        }
        System.out.println("Succes to read " + inputFile);

        // Encode File
        FileWriter fout;
        try{
            fout = new FileWriter(root + encodingFile);
            for(int i=0;i<cnt;i++){
                fout.write((char)(input[i]+encodingInterval));
            }

            fout.close();
        }
        catch(IOException e){
            System.out.println("Encode Error");
            return;
        }
        System.out.println("Success to encode");
        
        int encFile[] = new int[1000];
        cnt = 0;
        // Decode File
        try{
            fp = new FileReader(root + encodingFile);
            fout = new FileWriter(root + recoverdFile);

            int c;
            while((c = fp.read()) != -1){
                encFile[cnt++] = c;
            }

            for(int i=0;i<cnt;i++){
                fout.write((char)(encFile[i] - encodingInterval));
            }

            fp.close();
            fout.close();
        }
        catch(IOException e){
            System.out.println("Decode Error");
            return;
        }
        System.out.println("Succes to decode");

        // compare file
        try{
            fp = new FileReader(root + recoverdFile);
            int recoverd[] = new int[1000];
            int c; cnt = 0;
            while ((c = fp.read()) != -1) {
                recoverd[cnt++] = c;
            }

            fp.close();
            for(int i=0;i<cnt;i++){
                if(input[i] != recoverd[i]){
                    System.out.println("Different");
                    return;
                }
            }
        }
        catch(IOException e){
            System.out.println("Compare Error");
        }

        System.out.println("Same");

        return;
    }
}
