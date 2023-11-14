package testPack;

class Orange{
    public String toString(){
        return "Orange";
    }
}
class Apple{
    public String toString(){
        return "Apple";
    }
}
class Plastic{
    public String toString(){
        return "Plastic";
    }
}

class PrinterGeneric<T>{
    private T obj;
    public void set(T obj){
        this.obj = obj;
    }
    public String returnType(){
        return obj.toString();
    }
    public void print(){
        System.out.println(obj.toString());
    }

}

class PrintArrClass<T>{
    public static <T> void prinrArray(T[] arr){
        for(int i=1;i<=arr.length;i++){
            System.out.println(i+"번째: "+ arr[i]);
        }
    }
}



public class App {
    public static void main(String[] args) throws Exception {
        PrinterGeneric<Apple> a = new PrinterGeneric<Apple>();
        PrinterGeneric<Orange> o = new PrinterGeneric<Orange>();
        PrinterGeneric<Plastic> p = new PrinterGeneric<Plastic>();

        a.set(new Apple());
        o.set(new Orange());
        p.set(new Plastic());

        a.print();
        o.print();
        p.print();

        Integer[] intArr = new Integer[10];
        for(int i=0;i<10;i++){
            intArr[i] = i+1;
        }
        
        PrintArrClass.prinrArray(intArr);
    }
}