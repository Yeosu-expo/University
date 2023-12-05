package testPack;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.IOException;

class Member implements Serializable{
    String name;
    int number;
    public Member(String name, int number){
        this.name = name;
        this.number = number;
    }
    public void printMember(){
        System.out.println("NAME: "+name+", NUMBER: " + number);
    }
}

public class classIO {
    static String root = "C:\\Users\\akqjq\\Desktop\\Github\\University\\2학년 2학기\\JavaPrograming\\TestProject\\src\\testPack\\";

    public static void main(String[] args) {
        ObjectOutputStream obOut;
        try {
            FileOutputStream  outStream = new FileOutputStream(root+"obj.txt");
            obOut = new ObjectOutputStream(outStream);
            obOut.writeObject(new Member("KIM", 123));
            obOut.writeObject(new Member("LEE", 111));
            obOut.writeObject(new Member("PARK", 444));

            outStream.close();
            obOut.close();
        } catch (Exception e) {
            System.out.println("NO NAME!");
            return;
        }

        ObjectInputStream obIn;
        try {
            FileInputStream inStream = new FileInputStream(root + "obj.txt");
            obIn = new ObjectInputStream(inStream);
            
            Member m;
            while(true){
                m = (Member)obIn.readObject();
                if(m == null) break;

                m.printMember();
            }
            inStream.close();
            obIn.close();
        } catch (IOException e) {
            System.out.println("DONE.");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
