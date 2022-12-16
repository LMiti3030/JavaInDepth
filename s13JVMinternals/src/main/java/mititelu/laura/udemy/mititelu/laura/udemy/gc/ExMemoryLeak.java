package mititelu.laura.udemy.mititelu.laura.udemy.gc;

import java.util.EmptyStackException;

public class ExMemoryLeak {

    public static int size;
    public static Object[] elements = new Object[10000];

    public void push(Object o){
        //ensureCapacity();
        elements[size++] = o;
    }

    public Object pop() {
        if(size == 0){
            throw new EmptyStackException();
        }
        //        return elements[--size];
        // There will be a memory leak because the element will still be referenced by the array at the index
        // and GC will not collect the object as it considers it to be alive!
        // memory leak = unused object that are never freed!

        //SOLUTION: null all obsolete references
        //nulling all references - unclean code
        //let objects go out of scope and become dead
        Object  result = elements[--size];
        elements[size]=null;
        return result;
    }

}
