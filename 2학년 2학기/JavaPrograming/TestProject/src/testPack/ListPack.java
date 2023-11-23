package testPack;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

class Member{
    public int id;
    public String name;
    public Member(int id, String name){
        this.id = id;
        this.name = name;
    }
    @Override
    public int hashCode(){
        return this.id;
    }
    @Override
    public boolean equals(Object obj){
        Member member;
        if(obj instanceof Member)
            member = (Member)obj;
        else
            return false;
        if(this.id == member.id)
            System.out.println("this "+ this.name +" already exist.");
        return this.id == member.id;
    }
    public static void showAll(HashSet<Member> MList){
        Iterator<Member> it = MList.iterator();
        while(it.hasNext()){
            Member tmp = it.next();
            System.out.println("ID: " + tmp.id + ", NAME: " + tmp.name);
        }
    }
}




public class ListPack {
    static Member searchMember(HashSet<Member> set, int target){
        Member res = new Member(0, null);
        Iterator<Member> it = set.iterator();
        while(it.hasNext()){
            Member tmp = it.next();
            if(target == tmp.id)
                res = tmp;
        }

        return res;
    }
    public static void main(String[] args) {
        HashSet<Member> hashSetList = new HashSet<>();
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
                hashSetList.add(m);
            }
            else if(order == 2){
                System.out.print("멤버ID: ");
                int id = sc.nextInt();
                Member target = searchMember(hashSetList, id);
                hashSetList.remove(target);
            }
            else if(order == 3)
                Member.showAll(hashSetList);
            else
                break;
        }
        sc.close();

    }
}
