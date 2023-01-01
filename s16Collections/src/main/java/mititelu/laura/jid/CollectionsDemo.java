package mititelu.laura.jid;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {

    public static void main(String[] args) {

        //boolean addAll(Collection<? super T> c, T ... elements);
        //adds the second param - the array elements to the collection (first param)

        List<String> list = new ArrayList<>();
        list.add("Raj");
        list.add("John");
        list.add("John");
        String[] array = {"Anita"};

        Collections.addAll(list, array);
        System.out.println(list);

        //list.addAll() - adds a collection to a collection
        //list.addAll(Arrays.asList(array))

        //static <T extends Comparable<? super T>> void sort(List<T> list)
        //uses natural ordering - elements of the list must implement Comparable interface
        //another version for sort that takes a Comparator and uses it for sorting
        //sort is only for list - it is not for set - for sorted set use TreeSet
        //for hashset -> create a collection

        Collections.sort(list);

        System.out.println("Sorted list:  " + list);



        //<T> int binarySearch(List<? extends Comparable<? super T>> list, T key)
        //needs to be sorted. O(log(n)), better than O(n)
        //if not sorted, results are undefined. Might perform an inefficient linear search
        //For Sets: HashSet ~ O(1), TreeSet~O(log(n)). ie same efficiency as binary search
        // Note: List.contains is O(n)

        System.out.println("Is John there? " + Collections.binarySearch(list, "John"));

        //<T> int binarySearch(List<? extends Comparable<? super T>> list, T key, Comparator <? super T> c)

        //reverses the list
        Collections.reverse(list);
        System.out.println("Reverse list: " + list);

        //swaps 2 elements
        Collections.swap(list, 0,3);
        System.out.println("After swapping: " + list);


        System.out.println("# John's frequency: " + Collections.frequency(list, "John"));

        Collections.shuffle(list);
        System.out.println("Shuffled list: " + list);

        System.out.println("Max: " + Collections.max(list)); //natural ordering
        System.out.println("Min: " + Collections.min(list));

        //Singleton ~ <T> Set<T> singleton(T o)
        //returns an immutable set containing only the specified object
        //Others <T> List<T> singletonList<T o) & <K,V> Map<K,V> singletonMap(K key, V value)
        list.removeAll(Collections.singleton("John"));

        System.out.println("List after removal: " + list);

        //Unmodifiable View - to provide clients with read-only access to internal collection

        Collection<String> unmodifiable = Collections.unmodifiableCollection(list);
        //unmodifiable.add("5"); //throws java.lang.UnsupportedOperationException
        System.out.println("Is Anita there? " + unmodifiable.contains("Anita"));
        //add the element to the original listand it will be visible to view
        //any operation done to the original list is seen also in the view
        list.add("Maria");
        System.out.println("unmodifiable after adding Maria to original list: " + unmodifiable);

    }

}
