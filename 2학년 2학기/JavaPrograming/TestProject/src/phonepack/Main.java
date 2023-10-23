package phonepack;

import java.util.Scanner;

class Phone {
    String name;
    String phoneNumber;
    public Phone(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public void printInfo(){
        System.out.print("이름: "+name+", 전화번호: "+phoneNumber);
    }
}

class PhoneComp extends Phone {
    String companyName;
    public PhoneComp(String name, String phoneNumber, String companyName){
        super(name, phoneNumber);
        this.companyName = companyName;
    }
    public void printInfo(){
        super.printInfo();
        System.out.print(", 회사명: "+companyName);
    }
}

class PhoneUniv extends Phone {
    String major;
    String grade;
    public PhoneUniv(String name, String phoneNumber, String major, String grade){
        super(name, phoneNumber);
        this.major = major;
        this.grade = grade;
    }
    public void printInfo(){
        super.printInfo();
        System.out.print(", 전공: "+major+", 학년: "+grade);
    }
}

class PhoneManager {
    Phone phoneList[];
    int index;
    int size;
    Scanner sc;
    public PhoneManager(int size){
        sc = new Scanner(System.in);
        this.size = size;
        phoneList = new Phone[size];
        index = 0;
    }
    public void addPhone(Phone phone){
        phoneList[index] = phone;
        index++;
    }
    public void deletePhone(int where){
        if(where > index){
            System.out.println("해당 번호의 정보가 없습니다.");
        }
        for(int i=where-1;i<index-1;i++){
            phoneList[i] = phoneList[i+1];
        }
        index --;
    }
    public int printMenu(){
        System.out.println("1. 데이터 입력");
        System.out.println("2. 데이터 검색");
        System.out.println("3. 데이터 삭제");
        System.out.println("4. 전체 데이터 출력");
        System.out.println("5. 프로그램 종료");

        int order = sc.nextInt();

        return order;
    }
    public void getData(){
        System.out.println("1. 일반(Phone) - 이름, 전화번호");
        System.out.println("2. 대학(PhoneUniv) - 이름, 전화번호, 전공, 학년");
        System.out.println("3. 회사(PhoneComp) - 이름, 전화번호, 회사명");
        int choice = sc.nextInt();
        
        System.out.print("이름: ");
        String name = sc.next();
        System.out.print("전화번호: ");
        String phoneNumber = sc.next();

        if(choice == 1){
            Phone phone = new Phone(name, phoneNumber);
            this.addPhone(phone);
        } 
        else if(choice == 2){
            System.out.print("전공: ");
            String major = sc.next();
            System.out.print("학년: ");
            String grade = sc.next();

            PhoneUniv phone = new PhoneUniv(name, phoneNumber, major, grade);
            this.addPhone(phone);
        }
        else if(choice == 3){
            System.out.print("회사명: ");
            String companyName = sc.next();

            PhoneComp phone = new PhoneComp(name, phoneNumber, companyName);
            this.addPhone(phone);
        }
        else
            System.out.println("잘못된 입력입니다.");
        
        System.out.println("입력이 완료되었습니다.\n");
    }
    public void searchData(){
        if(index == 0){
            System.out.println("조회가능한 정보가 없습니다.");
            return;
        }
        System.out.print("몇 번째 정보를 검색하시겠습니까?(정보 수: "+index+")? ");
        int choice = sc.nextInt();

        if(choice > index){
            System.out.println("해당 정보를 조회할 수 없습니다.");
            return;
        }
        phoneList[choice-1].printInfo();
        System.out.println();
    }
    public void deleteData(){
        if(index==0){
            System.out.println("삭제가능한 정보가 없습니다.");
            return;
        }
        System.out.print("몇 번째 정보를 삭제하시겠습니까? ");
        int choice = sc.nextInt();

        this.deletePhone(choice);
        System.out.println(choice+"번째 정보가 삭제되었습니다.");
    }
    public void printAllData(){
        for(int i=0;i<index;i++){
            System.out.print((i+1)+"번째 정보. ");
            phoneList[i].printInfo();
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args){
        PhoneManager pm = new PhoneManager(10);
        boolean isTure = true;
        while(isTure){
            System.out.println("--------------------------------");
            int order = pm.printMenu();
            switch(order){
                case 1:
                pm.getData();
                break;
                case 2:
                pm.searchData();
                break;
                case 3:
                pm.deleteData();
                break;
                case 4:
                pm.printAllData();
                break;
                case 5:
                isTure = false;
                break;
                default:
                System.out.println("잘못된 입력입니다.");
                break;
            }
        }
    }
}
