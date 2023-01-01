package mititelu.laura.jid;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class QueueDemo {

    public static void main(String[] args) {
        dequeTest();
    }

    private static void dequeTest(){
        System.out.println("\nInside dequeTest...");

        System.out.println("\nUsing the Deque as a Queue -  FIFO");
        Deque<String> deque = new ArrayDeque<>();
        deque.add("Walden");
        deque.add("Harry Potter");
        deque.add("Head First Java");

        System.out.println("Printing queue: " );
        System.out.println(deque.remove()); //from the head or removeFirst
        System.out.println(deque.remove());
        System.out.println(deque.remove());

        //deque is empty
        System.out.println("\nUsing the Deque as a Stack -  LIFO");
        deque.push("Walden");
        deque.push("Harry Potter");
        deque.push("Head First Java");
        System.out.println("Printing stack: ");
        System.out.println(deque.pop()); //from tail or removeLast
        System.out.println(deque.pop());
        System.out.println(deque.pop());

        //LinkedList also implements Deque BUT NOT RECOMMENDED

        System.out.println("\nUsing the LinkedList as a Queue -  FIFO");
        Deque<String> linkedList = new LinkedList<>();
        linkedList.add("Walden");
        linkedList.add("Harry Potter");
        linkedList.add("Head First Java");

        System.out.println("Printing queue: " );
        System.out.println(linkedList.remove()); //from the head or removeFirst
        System.out.println(linkedList.remove());
        System.out.println(linkedList.remove());

        //deque is empty
        System.out.println("\nUsing the Deque as a Stack -  LIFO");
        linkedList.push("Walden");
        linkedList.push("Harry Potter");
        linkedList.push("Head First Java");
        System.out.println("Printing stack: ");
        System.out.println(linkedList.pop()); //from tail or removeLast
        System.out.println(linkedList.pop());
        System.out.println(linkedList.pop());

    }

}
