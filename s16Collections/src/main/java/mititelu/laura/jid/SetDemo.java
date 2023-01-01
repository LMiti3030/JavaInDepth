package mititelu.laura.jid;



import java.util.*;

public class SetDemo {

    public static void main(String[] args) {
        //hashSetDemo();
       // linkedHashSetDemo();
       // treeSetDemo();
        treeSetDemo2();
    }

    private static void hashSetDemo(){
        Set<String> set1 = new HashSet<>();
        set1.add("A");
        set1.add("B");
        set1.add("A");

        System.out.println("set1: " + set1);

        Book book1 = new Book("Walden", "Henry Thoreau", 1854);
        Book book2 = new Book("Walden", "Henry Thoreau", 1854);
        Set<Book> set2 = new HashSet<>();
        set2.add(book1);
        set2.add(book2);
        System.out.println("set2:  " + set2);
    }

    private static void linkedHashSetDemo(){
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Raj");
        hashSet.add("John");
        hashSet.add("Anita");
        System.out.println("Hashset: " + hashSet);

        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Raj");
        linkedHashSet.add("John");
        linkedHashSet.add("Anita");
        System.out.println("LinkedHashSet(preserves order): " + linkedHashSet);

    }

    private static void treeSetDemo(){

        Book book1 = new Book("Harry Potter","J.K. Rowling", 1997);
        Book book2 = new Book("Harry Potter","J.K. Rowling", 1997);
        Book book3 = new Book("Walden","Henry David Thoreau", 1854);
        Book book4 = new Book("Effective Java","Joshua Bloch", 2008);

        Set<Book> books = new TreeSet<>(new TitleComparator());
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);

        for(Book book : books){
            System.out.println(book);
        }

    }

    private static void treeSetDemo2(){
        NavigableSet<Integer> set = new TreeSet<>();
        set.add(5);
        set.add(23);
        set.add(74);
        set.add(89);
        System.out.println("lower: " + set.lower(74)); //23
        System.out.println("floor: " + set.floor(74)); //74
        System.out.println("ceiling: " + set.ceiling(74)); //74
        System.out.println("higher: " + set.higher(74)); //89


        System.out.println("first: " + set.first());
        System.out.println("last: " + set.last());

        System.out.println("Set: " + set);

        System.out.println("Descending set: " + set.descendingSet());

        NavigableSet<Integer> headSet = set.headSet(74,false);
        System.out.println("HeadSet exclusive 74 " + headSet);

        NavigableSet<Integer> headSet2 = set.headSet(74,true);
        System.out.println("HeadSet inclusive 74 " + headSet2);

        headSet.add(6);
        System.out.println("After adding, HeadSet exclusive 74 " + headSet);
        System.out.println("After adding to headset, set is : " + set);

        headSet.add(4); //elements start at 5 , but with headset anything below 74 is ok, so no exception added
        System.out.println("After adding, HeadSet exclusive 74 " + headSet);
        System.out.println("After adding to headset, set is : " + set);

        //headSet.add(76);//throws IllegalArgumentException: key out of range

        SortedSet<Integer> subSet = set.subSet(5,74);
        //subSet.add(2); //throws java.lang.IllegalArgumentException: key out of range because 2 is not within range 5-74

        set.add(25);
        System.out.println("Subset " + subSet);

    }


}

//cannot be added to a TreeSet unless using a Comparator
record Book(String title, String author, int year){
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (year != book.year) return false;
        if (!Objects.equals(title, book.title)) return false;
        return Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + year;
        return result;
    }
}

//class Book /*implements Comparable<Book>*/{
//    private String title;
//    private String author;
//    private int year;
//
//    public Book(String title, String author, int year) {
//        this.title = title;
//        this.author = author;
//        this.year = year;
//    }
//
//    @Override
//    public String toString() {
//        return "Book{" +
//                "title='" + title + '\'' +
//                ", author='" + author + '\'' +
//                ", year=" + year +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Book book = (Book) o;
//
//        if (year != book.year) return false;
//        if (!Objects.equals(title, book.title)) return false;
//        return Objects.equals(author, book.author);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = title != null ? title.hashCode() : 0;
//        result = 31 * result + (author != null ? author.hashCode() : 0);
//        result = 31 * result + year;
//        return result;
//    }
//
//    //    @Override
////    public int hashCode(){
////        return title.hashCode();
////    }
////
////    @Override
////    public boolean equals(Object o){
////        return (year == ((Book) o).getYear()) &&
////                (author.equals(((Book)o).getAuthor())) &&
////                        (title.equals(((Book)o).getTitle()));
////    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public int getYear() {
//        return year;
//    }
//
//    public void setYear(int year) {
//        this.year = year;
//    }
//
////    @Override
////    public int compareTo(Book o) {
////        return getTitle().compareTo(o.getTitle());
////    }
//}

class TitleComparator implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
       // return ((Book) o1).getTitle().compareTo(((Book) o2).getTitle());
        return ((Book) o1).title().compareTo(((Book) o2).title());
    }
}
