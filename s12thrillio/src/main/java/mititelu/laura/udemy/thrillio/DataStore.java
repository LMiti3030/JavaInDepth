package mititelu.laura.udemy.thrillio;

import mititelu.laura.udemy.thrillio.constants.BookGenre;
import mititelu.laura.udemy.thrillio.constants.Gender;
import mititelu.laura.udemy.thrillio.constants.MovieGenre;
import mititelu.laura.udemy.thrillio.constants.UserType;
import mititelu.laura.udemy.thrillio.entities.Bookmark;
import mititelu.laura.udemy.thrillio.entities.User;
import mititelu.laura.udemy.thrillio.entities.UserBookmark;
import mititelu.laura.udemy.thrillio.managers.BookmarkManager;
import mititelu.laura.udemy.thrillio.managers.UserManager;
import mititelu.laura.udemy.thrillio.util.IOUtil;


//in real word - this would  be a datastore
public class DataStore {


    public static final int TOTAL_USER_COUNT = 5;
    public static final int BOOKMARK_TYPES_COUNT = 3;
    public static final int BOOKMARK_COUNT_PER_TYPE = 5;
    public static final int USER_BOOKMARK_LIMIT = 5;

    private static final User[] users = new User[TOTAL_USER_COUNT]; //we have 5 users

    private static final Bookmark[][] bookmarks = new Bookmark[BOOKMARK_TYPES_COUNT][BOOKMARK_COUNT_PER_TYPE]; //3 user types, each type can have 5 bookmarks
    //first dim only weblinks
    //second dim only movies
    //third dim only books

    private static final UserBookmark[] userBookmarks = new UserBookmark[TOTAL_USER_COUNT * USER_BOOKMARK_LIMIT]; //5 users each with 5 bookmarks

    private static int bookmarkIndex;


    public static void loadData() {
        loadUsers();
        loadWebLinks();
        loadMovies();
        loadBooks();
    }

    private static void loadUsersWithoutFiles() {
        users[0] = UserManager.getInstance().createUSer(1000, "user0@mititelulaura.com", "test", "John", "M", Gender.MALE, UserType.USER);
        users[1] = UserManager.getInstance().createUSer(1001, "user1@mititelulaura.com", "test", "Sam", "M", Gender.MALE, UserType.USER);
        users[2] = UserManager.getInstance().createUSer(1002, "user2@mititelulaura.com", "test", "Anita", "M", Gender.FEMALE, UserType.EDITOR);
        users[3] = UserManager.getInstance().createUSer(1003, "user3@mititelulaura.com", "test", "Sara", "M", Gender.FEMALE, UserType.EDITOR);
        users[4] = UserManager.getInstance().createUSer(1004, "user4@mititelulaura.com", "test", "Laura", "M", Gender.FEMALE, UserType.CHIEF_EDITOR);
    }

    //using files

    private static void loadUsers() {
      String[] data = new String[TOTAL_USER_COUNT];
        IOUtil.read(data, "src/User.txt");
        int rowNum = 0;
        for(String row : data){
            String[] values = row.split(";");

            int gender = switch (values[5]){
                case "f" -> Gender.FEMALE;
                case "t" -> Gender.TRANSGENDER;
                default -> Gender.MALE;
            };
//            int gender = Gender.MALE;
//            if(values[5].equals("f")){
//                gender = Gender.FEMALE;
//            } else if(values[5].equals("t")){
//                gender = Gender.TRANSGENDER;
//            }
            users[rowNum++] = UserManager.getInstance().createUSer(Long.parseLong(values[0]), values[1], values[2], values[3], values[4], gender, values[6] );
        }
    }
    private static void loadWebLinksWithoutFiles() {
        bookmarks[0][0] = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2", "https://www.infoworld.com/article/2072759/taming-tiger--part-2.html", "https://www.infoworld.com");
        bookmarks[0][1] = BookmarkManager.getInstance().createWebLink(2001, "How do I import a pre-existing Java Project into Eclipse and get up and running?", "https://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running", "https://stackoverflow.com");
        bookmarks[0][2] = BookmarkManager.getInstance().createWebLink(2002, "Interface vs Abstract Class", "https://www.mindprod.com/jgloss/interfacevsabstract.html", "https://www.mindprod.com");
        bookmarks[0][3] = BookmarkManager.getInstance().createWebLink(2003, "NIO Tutorial by Greg Travis", "https://cs.brown.edu/courses/cs161/papers/j-nio-ltr.pdf", "https://cs.brown.edu");
        bookmarks[0][4] = BookmarkManager.getInstance().createWebLink(2004, "Virtual Hosting and Tomcat", "https://tomcat.apache.org/tomcat-9.0-doc/virtual-hosting-howto.html", "https://tomcat.apache.org/");
    }

    private static void loadWebLinks() {
        String[] data = new String[BOOKMARK_COUNT_PER_TYPE];
        IOUtil.read(data, "src/WebLink.txt");
        int rowNum = 0;
        for(String row : data){
            String[] values = row.split(";");
            bookmarks[0][rowNum++] = BookmarkManager.getInstance().createWebLink(Long.parseLong(values[0]), values[1], values[2], values[3]);
        }
    }


    private static void loadMoviesWithoutFile() {
        bookmarks[1][0] = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941, new String[]{"Orson Wells", "Joseph Cotten"}, new String[]{"Orson Welles"}, MovieGenre.CLASSICS, 8.5);
        bookmarks[1][1] = BookmarkManager.getInstance().createMovie(3001, "The Grapes of Wrath", "", 1940, new String[]{"Henry Fonda", "Jane Darwell"}, new String[]{"John Ford"}, MovieGenre.CLASSICS, 8.2);
        bookmarks[1][2] = BookmarkManager.getInstance().createMovie(3002, "A Touch of Greatness", "", 2004, new String[]{"Albert Cullum"}, new String[]{"Leslie Sullivan"}, MovieGenre.DOCUMENTARIES, 7.3);
        bookmarks[1][3] = BookmarkManager.getInstance().createMovie(3003, "The Big Bang Theory", "", 2007, new String[]{"Kaley Cuoco", "Jim Parsons"}, new String[]{"Chuck Lorre", "Bill Prady"}, MovieGenre.TV_SHOWS, 8.7);
        bookmarks[1][4] = BookmarkManager.getInstance().createMovie(3004, "Ikiru", "", 1952, new String[]{"Takashi Shimura", "Minoru Chiaki"}, new String[]{"Akira Kurosawa"}, MovieGenre.FOREIGN_MOVIES, 8.4);
    }

    private static void loadMovies() {

        String[] data = new String[BOOKMARK_COUNT_PER_TYPE];
        IOUtil.read(data, "src/Movie.txt");
        int rowNum = 0;
        for(String row : data){
            String[] values = row.split(";");
            String[] cast = values[3].split(",");
            String[] directors = values[4].split(",");
            bookmarks[1][rowNum++] = BookmarkManager.getInstance().createMovie(Long.parseLong(values[0]), values[1], "", Integer.parseInt(values[2]),
                    cast, directors, values[5], Double.parseDouble(values[6]));
        }

    }




    private static void loadBooksWithoutFiles() {
        bookmarks[2][0] = BookmarkManager.getInstance().createBook(4000, "Walden", "", 1854, "Wilder Publications", new String[]{"Henry David Thoreau"}, BookGenre.PHILOSOPHY, 4.3);
        bookmarks[2][1] = BookmarkManager.getInstance().createBook(4001, "Self-Reliance and Other Essays", "", 1993, "Dover Publications", new String[]{"Ralph Waldo Emerson"}, BookGenre.PHILOSOPHY, 4.5);
        bookmarks[2][2] = BookmarkManager.getInstance().createBook(4002, "Light From Many Lamps", "", 1988, "Touchstone", new String[]{"Lillian Eichler Watson"}, BookGenre.PHILOSOPHY, 5.0);
        bookmarks[2][3] = BookmarkManager.getInstance().createBook(4003, "Head First Design Patterns", "", 2004, "O'Reilly Media", new String[]{"Eric Freeman", "Bert Bates", "Kathy Sierra", "Elisabeth Robson"}, BookGenre.TECHNICAL, 4.5);
        bookmarks[2][4] = BookmarkManager.getInstance().createBook(4004, "Effective Java Programming Language Guide", "", 2007, "Prentice Hall", new String[]{"Joshua Bloch"}, BookGenre.TECHNICAL, 4.9);
    }

    private static void loadBooks() {
        String[] data = new String[BOOKMARK_COUNT_PER_TYPE];
        IOUtil.read(data, "src/Book.txt");
        int rowNum = 0;
        for(String row : data){
            String[] values = row.split(";");
            String[] authors = values[4].split(",");
            bookmarks[2][rowNum++] = BookmarkManager.getInstance().createBook(Long.parseLong(values[0]), values[1], "", Integer.parseInt(values[2]),
                    values[3],  authors, values[5], Double.parseDouble(values[6]));
        }
    }

    public static User[] getUsers(){
        return users;
    }

    public static Bookmark[][] getBookmarks(){
        return bookmarks;
    }

    public static void add(UserBookmark userBookmark) {
        //add to the database - in this case put it in userBookmarks;

        userBookmarks[bookmarkIndex] = userBookmark;
        bookmarkIndex++;

    }
}
