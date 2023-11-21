package testPack;

import java.util.Scanner;
import java.util.ArrayList;

class Member {
    public int id;
    public String name;
    public Member(int id, String name){
        this.id = id;
        this.name = name;
    }
    public static void addMember(ArrayList<Member> MList, Member m){
        for(int i=0;i<MList.size();i++){
            Member tmp = MList.get(i);
            if(tmp.id == m.id){
                System.out.println("this id already exist");
                return;
            }
        }

        MList.add(m);
    }
    public static void removeMember(ArrayList<Member> MList, int id){
        int i;
        for(i=0;i<MList.size();i++){
            Member tmp = MList.get(i);
            if(tmp.id == id){
                System.out.println(id+" removed.");
                break;
            }
        }

        MList.remove(i);
    }
    public static void showAll(ArrayList<Member> MList){
        for(int i=0;i<MList.size();i++){
            Member tmp = MList.get(i);
            System.out.println("ID: " + tmp.id + ", NAME: " + tmp.name);
        }
    }
}


public class ListPack {
    public static void main(String[] args) {
        ArrayList<Member> MList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.println("-----------------");
            System.out.println("1. 멤버 추가");
            System.out.println("2. 멤버 삭제");
            System.out.println("3. 멤버 출력");
            System.out.print("입력: ");
            int order = sc.nextInt();

            if(order == 1){
                System.out.print("멤버ID: ");
                int id = sc.nextInt();
                System.out.print("멤버이름: ");
                String name = sc.next();
                Member m = new Member(id, name);
                Member.addMember(MList, m);
            }
            else if(order == 2){
                System.out.print("멤버ID: ");
                int id = sc.nextInt();
                Member.removeMember(MList, id);
            }
            else if(order == 3)
                Member.showAll(MList);
            else
                break;
        }
        sc.close();
    }
}
