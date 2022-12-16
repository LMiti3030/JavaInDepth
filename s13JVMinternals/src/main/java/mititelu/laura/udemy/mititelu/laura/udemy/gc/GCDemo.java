package mititelu.laura.udemy.mititelu.laura.udemy.gc;

public class GCDemo {

    //vm args -Xms13m -Xmx13m -XX:+PrintGCDetails -XX:+UseSerialGC
    //-Xms13m - minimum amount of memory allocated to the heap = 13m
    //-Xms13m - maximum amount of memory allocated to the heap = 13m
    //m - mega, g-giga, k - kilo BYTES
    //-XX:+PrintGCDetails - show details
//    -XX:+PrintGCDetails is deprecated. Will use -Xlog:gc* instead.
    //-XX:+UseSerialGC - use serial GC
    //-XX:MaxNewSize=1m - force JVM to restrict young generation size to be around 1m and the rest of it should be allocated to old generation

    public static int[] array = new int[2*1024*1024]; //8.4MB approx (2M entries *4b)
    public static void main(String[] args) {

    }
}
