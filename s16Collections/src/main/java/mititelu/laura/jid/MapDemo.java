package mititelu.laura.jid;

import java.util.*;

public class MapDemo {

    public static void main(String[] args) {
        //hashMapDemo();

        //immutableKeysDemo();

        //lruCacheTest();

        //customLRUCacheTest();

        treeMapDemo();
    }

    private static void hashMapDemo(){
        System.out.println("\n\nInside hashMapDemo...");

        Map<String, Integer> map1  = new HashMap<>();

        map1.put("John", 25);
        map1.put("Raj", 29);
        map1.put("Anita", null);

        System.out.println(map1);

        map1.put("Anita", 23);
        System.out.println(map1);

        System.out.println("Contains John? " + map1.containsKey("John"));

        System.out.println("John's age? " + map1.get("John"));

        //iterate through the map

        System.out.println("Iterating using keySet");
        Set<String> names = map1.keySet();
        for(String name: names){
            System.out.println("Name: " + name + ", age: " + map1.get(name));
        }

        System.out.println("Iterating using the entrySet");
        Set<Map.Entry<String, Integer>> entrySet = map1.entrySet();
        for(Map.Entry<String, Integer> entry : entrySet){
            System.out.println("Name: " + entry.getKey() + ", age: " + entry.getValue());
        }

        names.remove("Anita");
        System.out.println(map1);

        System.out.println("\n More complex map");

        Map<String, Map<String, Object>> userProfile = new HashMap<>();
        Map<String, Object> profile = new HashMap<>();
        profile.put("age", 25);
        profile.put("department", "CS");
        profile.put("city", "New York");
        userProfile.put("John", profile);

        profile = new HashMap<>();
        profile.put("age", 29);
        profile.put("department", "CS");
        profile.put("city", "New York");
        userProfile.put("Raj", profile);
        System.out.println(userProfile);


        Map<String, Object> profile1 = userProfile.get("John");
        int age = (Integer) profile1.get("age");
        System.out.println("Age: " + age);


    }

    private static void immutableKeysDemo(){
        System.out.println("\n\nInside immutableKeysDemo ...");
        List<Integer> list = new ArrayList<>();
        list.add(1);

        Map<List<Integer>, Integer> map = new HashMap<>();
        map.put(list, 1);

        list.add(2);

        System.out.println(map.get(list)); //returns null as the list was modified and the hashcode is different than the initial one
        // for Lists -  hashCode is dependent on the state of the object

        Student s = new Student(1, null);
        Map<Student, Integer> map2 = new HashMap<>();
        map2.put(s, 1);
        s.setName("John");
        System.out.println(map2.get(s)); //returns 1, the Student class did not override hashcode and equals. uses the object identity (memory address)
    }

    private static void lruCacheTest(){
        System.out.println("\n\n Inside lruCacheTest...");
        Map<String, String> lruCache = new LinkedHashMap<>(16,0.75f, true);
        lruCache.put("a", "A");
        lruCache.put("b", "B");
        lruCache.put("c", "C");
        System.out.println(lruCache); // A, B, C

        lruCache.get("a"); //multiple gets to "a" will not make a difference
        lruCache.get("a");
        lruCache.get("a");
        System.out.println(lruCache); //B, C, A
        lruCache.get("b");
        System.out.println(lruCache); //C, A, B

        lruCache.put("d", "D");
        System.out.println(lruCache); //C, A, B, D
        lruCache.put("e", "E");
        System.out.println(lruCache); // C, A, B , D, E

    }

    private static void customLRUCacheTest(){
        System.out.println("\n\n Inside customLRUCacheTest...");
        Map<String, String> lruCache = new LRUCache<>(16,0.75f, true);
        lruCache.put("a", "A");
        lruCache.put("b", "B");
        lruCache.put("c", "C");
        System.out.println(lruCache); // A, B, C

        lruCache.get("a"); //multiple gets to "a" will not make a difference
        lruCache.get("a");
        lruCache.get("a");
        System.out.println(lruCache); //B, C, A
        lruCache.get("b");
        System.out.println(lruCache); //C, A, B

        lruCache.put("d", "D");
        System.out.println(lruCache); //A, B, D -> removed C which was least recently used
        lruCache.put("e", "E");
        System.out.println(lruCache); // B , D, E -> removed A which was least recently used

    }

    private static void treeMapDemo(){
        System.out.println("\n\nInside treeMapDemo...");
        TreeMap<String, Integer> map1 = new TreeMap<>();
        map1.put("John", 25);
        map1.put("Raj",29);
        map1.put("Anita",23);

        System.out.println(map1);

        System.out.println("Iterating using entrySet...");
        Set<Map.Entry<String, Integer>> mappings = map1.entrySet();
        for(Map.Entry<String, Integer> entry : mappings){
            System.out.println("Name: " + entry.getKey() + ",  age: " + entry.getValue());

            if(entry.getKey().equals("John")){
                entry.setValue(26); //the original map will be changed
            }
        }
        System.out.println(map1); //the age for John was modified
       // map1.floorEntry("Raj").setValue(22); //throws UnsupportedOperationException as the value is a snapshot at that instance of time; entry not backed by original map
       // System.out.println(map1);
    }

}

class LRUCache<K,V> extends LinkedHashMap<K,V>{
    //private static final long serialVersionUID
    private static final int MAX_ENTRIES = 3;

    public LRUCache(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity,loadFactor,accessOrder);
    }

    //invoked by put and putAll after inserting a new entry into the map
    @Override
    public boolean removeEldestEntry(Map.Entry eldest){
        return size() > MAX_ENTRIES;
        //return false; // = same as normal linked hash map
    }
}

class Student{
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}