package mititelu.laura.jid;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo {

    public static void main(String[] args) {
        listIteratorDemo();
    }

    public static void listIteratorDemo(){
        List<String> list = new ArrayList<>();
        list.add("a"); //index 0
        list.add("b"); //index 1
        list.add("c"); //index 2

        System.out.println("\nDisplaying current elements...");
        for(ListIterator<String> iterator = list.listIterator(); iterator.hasNext(); ){
            System.out.println("iterator.nextIndex(): " + iterator.nextIndex()+ ", iterator.next(): " + iterator.next());
        }

        System.out.println("\nDemonstrating add, remove and set operations...");
        for(ListIterator<String> iterator = list.listIterator(); iterator.hasNext();){
            System.out.println("iterator.nextIndex(): " + iterator.nextIndex()+ ", iterator.next(): " + iterator.next());
            if(iterator.nextIndex() == 1){
                System.out.println("*** Adding test at index 1");
                iterator.add("test"); //cursor between test and b
                System.out.println("iterator.nextIndex(): " + iterator.nextIndex()+ ", iterator.next(): " + iterator.next());
                //cursor between b and c, index = 2

                System.out.println("Removing test that was added at index 1");
                iterator.previous(); //b
                iterator.previous(); //test
                iterator.remove(); //remove test

                //Uncommenting line below throws an IllegalStateException as set should always be preceded by set/previous/next
                //iterator.set("test");

                //cursor is now at index 1 and the element is b
                System.out.println("iterator.nextIndex(): " + iterator.nextIndex()+ ", iterator.next(): " + iterator.next());

                System.out.println("Setting element at index 1 as test");
                iterator.set("test"); //cursor did not move!!
                System.out.println("Setting element at index 1 as test1 to show that two set operations can be invoked sequentially ");
                iterator.set("test1");
            }
        }

        System.out.println("\nDisplaying current elements");
        for(ListIterator<String> iterator = list.listIterator(); iterator.hasNext(); ){
            System.out.println("iterator.nextIndex(): " + iterator.nextIndex()+ ", iterator.next(): " + iterator.next());
        }

    }

}
