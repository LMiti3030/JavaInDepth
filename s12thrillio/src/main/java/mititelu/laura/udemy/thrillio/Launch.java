package mititelu.laura.udemy.thrillio;

import mititelu.laura.udemy.thrillio.entities.Bookmark;
import mititelu.laura.udemy.thrillio.entities.User;
import mititelu.laura.udemy.thrillio.managers.BookmarkManager;
import mititelu.laura.udemy.thrillio.managers.UserManager;

import java.util.stream.Stream;

public class Launch {


    private static User[] users;
    private static Bookmark[][] bookmarks;

    public static void main(String[] args) {
        loadData();
        //startBookmarking();
        start();
    }

//    private static void startBookmarking() {
//        System.out.println("\n2. Bookmarking...");
//        for(User user : users){
//            View.bookmark(user, bookmarks);
//        }
//    }

    private static void start() {
        for(User user : users){
            View.browse(user, bookmarks);
        }
    }

    //always main method at the bottom?
    private static void loadData(){
    //    System.out.println("1. Loading data...");
        DataStore.loadData();

        users = UserManager.getInstance().getUsers();

        bookmarks = BookmarkManager.getInstance().getBookmarks();

//        System.out.println("Printing data...");
//
//        printUserData();
//
//        printBookmarkData();
    }

    private static void printBookmarkData() {
        System.out.println("Printing bookmarks...");
        Stream.of(bookmarks).forEach( c -> {
            Stream.of(c).forEach(System.out::println);
        });
    }

    private static void printUserData() {
        System.out.println("Printing users...");
        Stream.of(users).forEach(System.out::println);
    }

}
