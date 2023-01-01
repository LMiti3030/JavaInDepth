package mititelu.laura.jid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;


public class IteratorDemo implements Iterable<Integer>{

    public static void main(String[] args) {
        iterateArrayList();
        //testIterableImplem();

    }

    private static void testIterableImplem() {

        for(int element: new IteratorDemo()){
            //internally the foreach calls the iterator() method on the object IteratorDemo
            // to get the iterator and uses it to iterate through the elements
        }
    }

    private static void iterateArrayList() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(9);
        list1.add(8);
        list1.add(6);
        list1.add(1);

        System.out.println("list1 before iteration: " + list1);

        Iterator<Integer> iterator = list1.iterator();
        while(iterator.hasNext()){
            int element = iterator.next();
            System.out.println("Element: " + element);
            if(element == 9){
                iterator.remove();
                iterator.remove();
                System.out.println("Using forEachRemaining using a filter");
                iterator.forEachRemaining(Filter::add); //for all remaining elements in the list it only prints the addition and not System.out.println("Element: " + element);
            }
        }

      //  System.out.println("list1 after removal using iterator: " + list1);

    //    System.out.println("Using foreach with a filter on list1");
        //list1.forEach(System.out::println);
   //     list1.forEach(Filter::filter); //works without implementing Consumer, the method is  static void filter(Integer i)
        //merge cu orice metoda statica care primeste un singur argument
        //transforma in Consumer metoda statica
        //list1.forEach(Filter::add); //works without implementing Consumer, the method is   static void add(Integer i)
       // list1.forEach(new Filter()); //requires implementing Consumer


    }

    @Override
    public Iterator<Integer> iterator() {
        return new ArrayList<Integer>().iterator();
    }
}

class Filter {
    static void filter(Integer i){
        if(i == 1){
            System.out.println(i);
        }
    }
    static void add(Integer i){
        System.out.println(i + 7);
    }

    static Integer filter2(Integer i){
        if(i == 1){
            System.out.println(i);
        }
        return 1;
    }

    static Integer filter3(Integer i, Integer j){
        if(i == 1){
            System.out.println(i);
        }
        return 1;
    }
}
