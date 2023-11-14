package testPack;

class Orange{

}
class Apple{

}
class Plastic{

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
        if(obj instanceof Apple)
            System.out.println("Apple");
        else if(obj instanceof Orange)
            System.out.println("Orange");
        else if(obj instanceof Plastic)
            System.out.println("Plastic");
    }

}

class PrintArrClass<T>{
    public static <T> void prinrArray(T[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(i+"번째: "+ arr[i]);
        }
    }
}



public class App {
    public static void main(String[] args) throws Exception {
        PrinterGeneric<Apple> a = new PrinterGeneric<Apple>();
        PrinterGeneric<Orange> o = new PrinterGeneric<Orange>();
        PrinterGeneric<Plastic> p = new PrinterGeneric<Plastic>();

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