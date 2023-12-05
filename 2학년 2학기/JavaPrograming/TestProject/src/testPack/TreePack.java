package testPack;

//import java.util.TreeMap;

//import java.util.Iterator;

// import java.util.Comparator;
// import java.util.Set;

// class Member implements Comparator<Integer>{
//     int id;
//     String name;
//     public Member(int id, String name){
//         this.id = id;
//         this.name = name;
//     }
//     public int getId() { return id; }
//     public String getName() {return name;}
//     public int compare(Integer n1, Integer n2) {
//         return n2.intValue() - n1.intValue();
//     }


// static void push_value(TreeMap<Integer, Member> tm, int id, Member m){
//     Set<Integer> ks = tm.keySet();
//     for(int key : ks){
//         if(key == id)
//             return;
//     }
//     tm.put(id, m);
// }

// static void printAll(TreeMap<Integer, Member> tm){
//     Set<Integer> ks = tm.keySet();
//     //Iterator<Integer> it = ks.iterator();

//     for(Integer n : ks) {
//         System.out.println("Key: "+n+", Value: "+tm.get(n).getName());
//     }
// }

// static boolean searchMember(TreeMap<Integer, Member> tm, int target, boolean sign){
//     Set<Integer> ks = tm.keySet();
//     for(Integer id : ks) {
//         if(id == target){
//             if(sign)
//                 System.out.println(tm.get(id).getName()+" exist.");
//             return true;
//         }
//     }
//     if(sign)
//         System.out.println("it doesn't exist.");
//     return false;
// }

// static void deleteMember(TreeMap<Integer, Member> tm, Integer target) {
//     boolean res = searchMember(tm, target, false);
//     if(res){
//         tm.remove(target);
//         System.out.println("Succes to delete");
//         return;
//     }
//     System.out.println("This id doesn't exist.");
// }

// public class TreePack {
//     public static void main(String[] args) {
//         TreeMap<Integer, Member> tm = new TreeMap<>();
        
//         push_value(tm, 1, new Member(1, "kim"));
//         push_value(tm, 1, new Member(1, "lee"));
//         push_value(tm, 2, new Member(2, "choi"));
//         push_value(tm, 0, new Member(0, "park"));

//         printAll(tm);
//         searchMember(tm, 2, true);

//         deleteMember(tm, 2);
//         printAll(tm);
//     }
// }}
