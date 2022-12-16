package mititelu.laura.udemy.thrillio.controllers;

import mititelu.laura.udemy.thrillio.entities.Bookmark;
import mititelu.laura.udemy.thrillio.entities.User;
import mititelu.laura.udemy.thrillio.managers.BookmarkManager;

public class BookmarkController {

    private static BookmarkController instance;

    private BookmarkController(){

    }

    public static BookmarkController getInstance(){
        if(instance == null){
            instance = new BookmarkController();
        }
        return instance;
    }


    public void saveUserBookmark(User user, Bookmark bookmark) {

        BookmarkManager.getInstance().saveUserBookmark(user,bookmark);

    }

    public void setKidFriendlyStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
        //we should not have any business logic here
        BookmarkManager.getInstance().setKidFriendlyStatus(user,kidFriendlyStatus, bookmark);
    }

    public void share(User user, Bookmark bookmark) {
        BookmarkManager.getInstance().share(user, bookmark);
    }
}
