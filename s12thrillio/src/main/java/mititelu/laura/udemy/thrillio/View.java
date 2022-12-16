package mititelu.laura.udemy.thrillio;

import mititelu.laura.udemy.thrillio.constants.KidFriendlyStatus;
import mititelu.laura.udemy.thrillio.constants.UserType;
import mititelu.laura.udemy.thrillio.controllers.BookmarkController;
import mititelu.laura.udemy.thrillio.entities.Bookmark;
import mititelu.laura.udemy.thrillio.entities.User;
import mititelu.laura.udemy.thrillio.partner.Shareable;

//in real-life it would be the user interface
//contains actions made by a single users
public class View {

    public static void bookmark(User user, Bookmark[][] bookmarks){
        System.out.println("\n" + user.getEmail() + " is bookmarking");
        for(int i = 0; i < DataStore.USER_BOOKMARK_LIMIT; i++){
            int typeOffSet = (int) (Math.random() * DataStore.BOOKMARK_TYPES_COUNT);
            int bookmarkOffSet = (int) (Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);
            Bookmark bookmark = bookmarks[typeOffSet][bookmarkOffSet];
            //save bookmarks
            //send it to the controller
            BookmarkController.getInstance().saveUserBookmark(user,bookmark);

            System.out.println(bookmark);
        }
    }


    //new method called browse
    //can perform 3 actions look at it, and if the user is editor or chief editor, the user can mark the bookmark as kid friendly or not
    //or share the user
    //or skip the item
    public static void browse(User user, Bookmark[][] bookmarks){
        System.out.println("\n" + user.getEmail() + " is browsing items...");
        int bookmarkCount = 0;
        for(Bookmark[] bookmarkList : bookmarks ){
            for(Bookmark bookmark : bookmarkList){
                if(bookmarkCount < DataStore.USER_BOOKMARK_LIMIT){
                    boolean isBookmarked = getBookmarkDecision(bookmark);
                    if(isBookmarked){
                        bookmarkCount++;
                        BookmarkController.getInstance().saveUserBookmark(user,bookmark);

                        System.out.println("New Item bookmarked -- " + bookmark);
                    }
                }


                if(user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR) ){

                    //mark as kid-friendly
                    if(bookmark.isKidFriendlyEligible() && bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)){
                        String kidFriendlyStatus =  getKidFriendlyStatusDecision(bookmark);
                        if(!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)){
                            BookmarkController.getInstance().setKidFriendlyStatus(user,kidFriendlyStatus, bookmark);
                        }
                    }

                    //sharing
                    if(bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED) && (bookmark instanceof Shareable)){
                        //randomize the sharing
                        boolean isShared = getShareDecision();
                        if(isShared){
                            BookmarkController.getInstance().share(user, bookmark);
                        }
                    }
                }
            }
        }



    }

    private static boolean getShareDecision() {
        return Math.random() < 0.5 ? true : false;
    }

    private static String getKidFriendlyStatusDecision(Bookmark bookmark) {
        double randomVal = Math.random() ;
        return randomVal < 0.4 ? KidFriendlyStatus.APPROVED :
                (randomVal >= 0.5 && randomVal <0.8 ) ? KidFriendlyStatus.REJECTED : KidFriendlyStatus.UNKNOWN;
    }

    private static boolean getBookmarkDecision(Bookmark bookmark) {

        return Math.random() < 0.5 ? true : false;

    }

    //mark bookmars as kid friendly

}
