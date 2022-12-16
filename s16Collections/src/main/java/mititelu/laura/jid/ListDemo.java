package mititelu.laura.jid;

import java.util.ArrayList;
import java.util.Collection;

public class ListDemo {

    public static void main(String[] args) {

    }

    private static void arrayListDemo(){

        Collection<Integer> list1 = new ArrayList<>();


        Collection<Integer> list2 = new ArrayList<>();
        list2.add(9);
        list2.add(3);

        list1.removeAll(list2);
        System.out.println("list1: " + list1);

        list2.add(1);

        list1.retainAll(list2);
        System.out.println("list1: " + list1);

        list1.addAll(list2);
        System.out.println("list1: " + list1);

    }

}
