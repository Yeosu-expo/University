package quizonepack;

class Tire {
    public int left;
    public Tire(int left){
        this.left = left;
    }
    public void roll(){
        left = left - 1;
        System.out.println("Tire 수명: "+left+"회");
    }
}

class HankookTire extends Tire {
    public HankookTire(){
        super(5);
    }
}

class KenmHoTire extends Tire {
    public KenmHoTire(){
        super(10);
    }
}

class Car {
    Tire[] tires;
    public Car(Tire lf, Tire rf, Tire lb, Tire rb){
        tires = new Tire[4];

        tires[0] = lf;
        tires[1] = rf;
        tires[2] = lb;
        tires[3] = rb;
    }
    private void repairTire(Tire tire, int index){
        String where="";
        if(index == 0)
            where = "앞왼쪽";
        else if(index == 1)
            where = "앞오른쪽";
        else if(index == 2)
            where = "뒤왼쪽";
        else if(index == 3)
            where = "뒤오른쪽";

        if(tire instanceof HankookTire){
            System.out.println(where+" HankookTire로 교체");
        }
        else if(tire instanceof KenmHoTire){
            System.out.println(where+" KenmHoTire로 교체");
        }
        tires[index] = tire;
    }
    public void run(){
        System.out.println("-------------------------");
        System.out.println("[자동차가 달립니다.]");
        int isBoom = -1;
        if(tires[0].left == 1){
            isBoom = 0;
            System.out.println("***앞왼쪽 Tire 펑크***");
            System.out.println("[자동차가 멈춥니다.]");
        } else if(isBoom == -1&&tires[0].left != 1){
            System.out.print("앞왼쪽 ");
            tires[0].roll();
        }
        if(isBoom == -1&&tires[1].left == 1){
            isBoom = 1;
            System.out.println("***앞오른쪽 Tire 펑크***");
            System.out.println("[자동차가 멈춥니다.]");
        } else if(isBoom == -1&&tires[1].left != 1){
            System.out.print("앞오른쪽 ");
            tires[1].roll();
        }
        if(isBoom == -1&&tires[2].left == 1){
            isBoom = 2;
            System.out.println("***뒤왼쪽 Tire 펑크***");
            System.out.println("[자동차가 멈춥니다.]");
        } else if(isBoom == -1&&tires[2].left != 1){
            System.out.print("뒤왼쪽 ");
            tires[2].roll();
        }
        if(tires[3].left == 1){
            isBoom = 3;
            System.out.println("***뒤오른쪽 Tire 펑크***");
            System.out.println("[자동차가 멈춥니다.]");
        } else if(isBoom == -1&&tires[3].left != 1){
            System.out.print("뒤오른쪽 ");
            tires[3].roll();
        }

        if(isBoom!=-1){
            if(tires[isBoom] instanceof HankookTire)
                repairTire(new KenmHoTire(), isBoom);
            else if(tires[isBoom] instanceof KenmHoTire)
                repairTire(new KenmHoTire(), isBoom);
            else
                repairTire(new HankookTire(), isBoom);
        }
    }
    public void display(){
        System.out.println("------------------");
        System.out.println("앞왼쪽 Tire 남은 수명: "+tires[0].left+"회");
        System.out.println("앞오른쪽 Tire 남은 수명: "+tires[1].left+"회");
        System.out.println("뒤왼쪽 Tire 남은 수명: "+tires[2].left+"회");
        System.out.println("뒤오른쪽 Tire 남은 수명: "+tires[3].left+"회");
    }
}

public class Main {
    public static void main(String[] args){
        Car car = new Car(new Tire(6), new Tire(2), new Tire(3), new Tire(4));

        car.run();
        car.run();
        car.run();
        car.run();
        car.run();
        car.run();
        car.run();
        car.run();
        car.run();
        car.display();
    }
}
