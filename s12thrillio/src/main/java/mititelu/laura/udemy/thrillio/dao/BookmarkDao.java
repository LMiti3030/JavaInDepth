package mititelu.laura.udemy.thrillio.dao;

import mititelu.laura.udemy.thrillio.DataStore;
import mititelu.laura.udemy.thrillio.entities.Bookmark;
import mititelu.laura.udemy.thrillio.entities.UserBookmark;

public class BookmarkDao {

    public Bookmark[][] getBookmarks(){
        return DataStore.getBookmarks();
    }

    public void saveUserBookmark(UserBookmark userBookmark) {
        //sql to insert into db
        DataStore.add(userBookmark);
    }
}
