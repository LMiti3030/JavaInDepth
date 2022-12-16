package mititelu.laura.udemy.thrillio.entities;

import mititelu.laura.udemy.thrillio.constants.BookGenre;
import mititelu.laura.udemy.thrillio.managers.BookmarkManager;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookTest {

    @Test
    public void testIsKidFriendlyEligible(){
        //TEST 1 book genre contains philosophy -> return false

        Book book = BookmarkManager.getInstance().createBook(4000, "Walden", "", 1854, "Wilder Publications", new String[]{"Henry David Thoreau"}, BookGenre.PHILOSOPHY, 4.3);

        boolean isKidFriendly = book.isKidFriendlyEligible();

        assertFalse("book genre contains philosophy - isKidFriendlyEligible() must return false", isKidFriendly);

        //TEST 2 book genre contains self-help -> return false

        book = BookmarkManager.getInstance().createBook(4001, "Self-Reliance and Other Essays", "", 1993, "Dover Publications", new String[]{"Ralph Waldo Emerson"}, BookGenre.SELF_HELP, 4.5);

        isKidFriendly = book.isKidFriendlyEligible();

        assertFalse("book genre contains self-help - isKidFriendlyEligible() must return false", isKidFriendly);

        //TEST 3 book genre does not contain philosophy or self-help -> return true

        book = BookmarkManager.getInstance().createBook(4003, "Head First Design Patterns", "", 2004, "O'Reilly Media", new String[]{"Eric Freeman", "Bert Bates", "Kathy Sierra", "Elisabeth Robson"}, BookGenre.TECHNICAL, 4.5);

        isKidFriendly = book.isKidFriendlyEligible();

        assertTrue("book genre does not contain self-help or philosophy - isKidFriendlyEligible() must return true", isKidFriendly);
    }

}
