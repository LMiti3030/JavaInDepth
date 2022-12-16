package mititelu.laura.udemy.thrillio.managers;

import mititelu.laura.udemy.thrillio.dao.BookmarkDao;
import mititelu.laura.udemy.thrillio.entities.*;
import mititelu.laura.udemy.thrillio.util.HttpConnect;
import mititelu.laura.udemy.thrillio.util.IOUtil;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class BookmarkManager {

    private static BookmarkManager instance;

    private static BookmarkDao dao;

    private BookmarkManager(){
        dao = new BookmarkDao();
    }

    public static BookmarkManager getInstance(){
        if (instance == null){
            instance = new BookmarkManager();
        }
        return instance;
    }

    public Movie createMovie(long id, String title, String profileUrl, int releaseYear, String[]cast, String[] directors, String genre, double imdbRating){
        Movie movie = new Movie();
        movie.setId(id);
        movie.setTitle(title);
        movie.setProfile(profileUrl);
        movie.setReleaseYear(releaseYear);
        movie.setCast(cast);
        movie.setDirectors(directors);
        movie.setGenre(genre);
        movie.setImdbRating(imdbRating);
        return movie;
    }

    public Book createBook(long id, String title, String profileUrl, int publicationYear, String publisher, String[] authors, String genre, double amazonRating ){
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setProfile(profileUrl);
        book.setPublicationYear(publicationYear);
        book.setPublisher(publisher);
        book.setAuthors(authors);
        book.setGenre(genre);
        book.setAmazonRating(amazonRating);
        return book;
    }

    public Weblink createWebLink(long id, String title, String url, String host){
        Weblink weblink = new Weblink();
        weblink.setId(id);
        weblink.setTitle(title);
        weblink.setUrl(url);
        weblink.setHost(host);
        return weblink;
    }

    public Bookmark[][] getBookmarks(){
        if(dao == null){
            dao = new BookmarkDao();
        }
        return dao.getBookmarks();
    }


    public void saveUserBookmark(User user, Bookmark bookmark) {
        UserBookmark userBookmark = new UserBookmark();
        userBookmark.setUser(user);
        userBookmark.setBookmark(bookmark);

        if(bookmark instanceof  Weblink weblink){
            try{
                String url = weblink.getUrl();
                if(!url.endsWith(".pdf")){
                    String webpage = HttpConnect.download(weblink.getUrl());
                    if(webpage != null){
                        IOUtil.write(webpage, bookmark.getId());
                    }
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }

        dao.saveUserBookmark(userBookmark);


    }

    public void setKidFriendlyStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
        bookmark.setKidFriendlyStatus(kidFriendlyStatus);
        bookmark.setKidFriendlyMarkedBy(user);
        System.out.println("Kid-friendly status : " + kidFriendlyStatus + " , Marked by "+ user.getEmail()+ " , " + bookmark);

        //invoke the dao and save the info to the DB
    }

    public void share(User user, Bookmark bookmark) {
        bookmark.setSharedBy(user);
        System.out.println("Data to be shared: ");
//        if(bookmark instanceof Book){
//            System.out.println(((Book) bookmark).getItemData());
//        } else if (bookmark instanceof Weblink){
//            System.out.println(((Weblink) bookmark).getItemData());
//        }

        switch (bookmark){
            case Book b -> System.out.println(b.getItemData());
            case Weblink w -> System.out.println(w.getItemData());
            default -> {return;}
        }
    }
}
