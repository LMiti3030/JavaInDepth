package mititelu.laura.jid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {

    public static void main(String[] args) {
        List<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(3);
        list1.add(null);
        System.out.println("list1: " + list1);

        list1.remove(3);
        System.out.println("list1: " + list1);

        list1.remove(3);
        System.out.println("list1: " + list1);

        list1.add(0,10);
        System.out.println("list1: " + list1);

        list1.set(0,9);
        System.out.println("list1: " + list1);
    }
}
