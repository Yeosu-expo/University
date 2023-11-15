package testPack;

class Box<T>{
    private T ob;

    public void set(T o) {
        ob = o;
    }
    public T get() {
        return ob;
    }
}

public class BoxSwapDemo {
    public static void swapBox1(Box<Integer> obj1, Box<Integer> obj2) {
        Box<Integer> tmp = new Box<>();
        tmp.set(obj1.get());
        obj1.set(obj2.get());
        obj2.set(tmp.get());
    }
    public static <T> void swapBox2(Box<T> obj1, Box<T> obj2) {
        T tmp = obj1.get();
        obj1.set(obj2.get());
        obj2.set(tmp);
    }
    public static void main(String[] args) {
        Box<Integer> box1 = new Box<>();
        box1.set(99);

        Box<Integer> box2 = new Box<>();
        box2.set(55);

        Box<String> box3 = new Box<>();
        box3.set("Hello");

        Box<String> box4 = new Box<>();
        box4.set("World");

        System.out.println(box1.get() + " & " + box2.get());
        swapBox1(box1, box2);
        System.out.println(box1.get() + " & " + box2.get());

        System.out.println(box3.get() + " & " + box4.get());
        swapBox2(box3, box4);
        System.out.println(box3.get() + " & " + box4.get());
    }
}
