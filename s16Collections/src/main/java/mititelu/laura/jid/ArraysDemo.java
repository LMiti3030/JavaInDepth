package mititelu.laura.jid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

public class ArraysDemo {

    public static void main(String[] args) {
        //sequential();

        parallel();
    }

    private static void sequential(){
        //asList() - most commonly used
        //List<T> asList(T...)

        String[] strArray = new String[]{"Raj", "Anita"};
        List<String> strings = Arrays.asList(strArray); //fixed size, cannot add or remove
        System.out.println("strings: " + strings);

        //strings.remove(0); //throws java.lang.UnsupportedOperationException
        //strings.add("a"); //throws java.lang.UnsupportedOperationException
        strings.set(0,"john"); //can modify an element
        System.out.println("Updated Array: " + Arrays.toString(strArray));
        //Arrays.toString(strArray) concatenate elements using , + [] enclosing

        //creating modifiable ArrayList from Array
        strings = new ArrayList<>(Arrays.asList(strArray));
        strings.remove(0);
        strings.add("a");
        System.out.println(strings);

        //showing varargs
        strings = Arrays.asList("Raj", "Anita");

        List<String> fixedList = Arrays.asList(new String[3]); //arraylist with fixed size =3
        //recall from autoboxing that arrays are not auto-boxeable
        //List<Integer> fixedList2 = Arrays.asList(new int[2]);//compilation error
        List<int[]> fixedList2 = Arrays.asList(new int[2]); //ok
        System.out.println("fixedList2.size: " + fixedList2.size()); //1

        //Sorting: void sort(Object[]) - uses merge-sort with natural ordering
        //should have implemented COmparable interface
        //partially sorted array - far fewer than nlog(n) comparisons
        //almost sorted array - aprox n comparisons, where n is array size
        //Well-suited for merging 2 or more sorted arrays
        //Concatenate the arrays and sort the resulting array

        System.out.println("strArray: " + Arrays.toString(strArray));
        Arrays.sort(strArray);
        System.out.println("sorted strArray: " + Arrays.toString(strArray));


        //sorting: void(int[]) - uses quick sort
        int[] iArray = {23,4,59};
        Arrays.sort(iArray);
        System.out.println("sorted iArray: " + Arrays.toString(iArray));

        //void sort[T[] a, Comparator<? super T> c)
        //uses the comparator to sort the elements

        //Binary Search: int binarySearch(int[], int)
        //returns index if element found
        //otherwise returns -(insertion point) - 1
        //input array must be sorted. otherwise, behaviour is undefined
        System.out.println("Index returned by binary search: " + Arrays.binarySearch(new int[]{4,23,59}, 5)); //returns -2

        int[] newArray = Arrays.copyOf(iArray,6); //remaining slots are default values
        System.out.println("newArray: " + Arrays.toString(newArray));

        int[] newArray1 = new int[6];
        System.arraycopy(iArray, 0, newArray1, 0, iArray.length);
        System.out.println("newArray1: " + Arrays.toString(newArray1));

        Arrays.fill(newArray,13);
        System.out.println("newArray filled with 13: " + Arrays.toString(newArray)); //fills ALL positions with 13, replaces if necessary

        System.out.println("Equals? " + Arrays.equals(iArray,newArray));

        //Arrays.deepEquals(Object[], Object[])
        //Returns true if arrays are deeply equal to each other
        //Appropriate for nested arrays
        int[][][] deepArray1 = {{{1,2,3},{4,5,61}}};
        int[][][] deepArray2 = {{{1,2,3},{4,5,6}}};
        int[][] deepArray3 = {{1,2,3}};
        int[][] deepArray4 = {{1,2,3}};
        int[] deepArray5 = {1,2,3}; //Covariance: does not work as int[] is not a subtype of Object[], int[] is an object and not an array of objects
        //Object[] is supertype of Integer[] as Object is super of Integer
        int[] deepArray6 = {1,2,3};
        System.out.println("Deep Array Equals? deepArray1 & deepArray2 " + Arrays.deepEquals(deepArray1, deepArray2)); //false
        System.out.println("Deep Array Equals? deepArray3 & deepArray4 " + Arrays.deepEquals(deepArray3, deepArray4));
        //System.out.println("Deep Array Equals? deepArray5 & deepArray6 " + Arrays.deepEquals(deepArray5, deepArray6));//compilation erro, does not work

        Object[] objArray = new int[][][]{{{1,2,3}}};
        int[][] ia =(int[][])objArray[0];
        System.out.println(ia[0][2]); //3
    }


    private static void parallel(){
        //for large arrays on multi-core. Min size at least 1 >>13 = 8192

        //parralelSort - sorts the array received at
        //less than 8192 uses sequential sort
        int[] iArray = {23,4,59};
        Arrays.parallelSort(iArray);
        System.out.println("iArray parallel sort: "+ Arrays.toString(iArray));

        //parallelPrefix = cumulates, in paralel, each element of the given array in place, using the supplied function
        //exmpl 2,1,0,3 + functie adunare => 2,3,3,6
        //IntBinaryOperatorImpl intBinaryOperatorImpl = new IntBinaryOperatorImpl();
        //Arrays.parallelPrefix(iArray, intBinaryOperatorImpl);
        Arrays.parallelPrefix(iArray, (a,b)-> a+b );
        System.out.println("Parallel prefix: " + Arrays.toString(iArray));

        //parallelSetAll = sets the elements in the array to the result of the function passed as second param
        //passes the index of the array element to the function
        IntUnaryOperatorImpl intUnaryOperatorImpl = new IntUnaryOperatorImpl();
        intUnaryOperatorImpl.setArray(iArray);
        Arrays.parallelSetAll(iArray, intUnaryOperatorImpl);
        System.out.println("Parallel setAll: " + Arrays.toString(iArray));

    }

}

class IntUnaryOperatorImpl implements IntUnaryOperator{

    int[] iArray;

    @Override
    public int applyAsInt(int i) {
        if(iArray != null){
            return iArray[i] + 5;
        } else {
            return i;
        }
    }

    public void setArray(int[] array) {
        this.iArray = array;
    }
}

class IntBinaryOperatorImpl implements IntBinaryOperator{

    @Override
    public int applyAsInt(int left, int right) {
        return left + right;
    }
}