package testPack;

class Car {
    private int gasolineGauge;
    public Car(int gasoline) {
        gasolineGauge = gasoline;
    }
    public int getGasoline(){
        return gasolineGauge;
    }
    public void showCurrentGauge(){
        System.out.println("잔여 가솔린: " + gasolineGauge);
    }
}

class HybridCar extends Car {  
    private double electricGauge;    
    public HybridCar(int gasoline, double elec) {
        super(gasoline);
        electricGauge = elec;
    }
    public double getElec(){
        return electricGauge;
    }
    public void showCurrentGauge(){
        System.out.println("잔여 가솔린: " + this.getGasoline());
        System.out.println("잔여 전기량: " + electricGauge);
    }
}

class HybridWaterCar extends HybridCar {   
    private int waterGauge;    

    public HybridWaterCar(int gasoline, double elec, int water) {
        super(gasoline, elec);
        waterGauge = water;
    }
    public HybridWaterCar(double elec, int water) {
        super(0, elec);
        waterGauge = water;
    }
    public void showCurrentGauge(){
        System.out.println("잔여 가솔린: " + this.getGasoline());
        System.out.println("잔여 전기량: " + this.getElec());
        System.out.println("잔여 워터량: " + waterGauge);
    }
}

public class Constructor {
    public static void main(String[] args) {
       HybridWaterCar hwCar1 = new HybridWaterCar(4.2, 2);
       hwCar1.showCurrentGauge();

       HybridWaterCar hwCar2 = new HybridWaterCar(9, 5.1, 7);
       hwCar2.showCurrentGauge();

       HybridCar hwCar3 = new HybridCar(5, 5.1);
       hwCar3.showCurrentGauge();

       Car hwCar4 = new Car(10);
       hwCar4.showCurrentGauge();
    }

}

