package mititelu.laura.udemy.thrillio.entities;


import mititelu.laura.udemy.thrillio.constants.MovieGenre;
import mititelu.laura.udemy.thrillio.managers.BookmarkManager;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MovieTest {

    @Test
    public void testIsKidFriendlyEligible(){

        //TEST 1 movie type contains thriller -> should return false

        Movie movie = BookmarkManager.getInstance().createMovie(3000, "SAW", "", 1941, new String[]{"Orson Wells", "Joseph Cotten"}, new String[]{"Orson Welles"}, MovieGenre.THRILLERS, 8.5);

        boolean isKidFriendly = movie.isKidFriendlyEligible();

        assertFalse("Type contains thriller - isKidFriendlyEligible() should return false ", isKidFriendly);

        //TEST 2 movie type contains horror -> should return false

        movie = BookmarkManager.getInstance().createMovie(3000, "JAWS", "", 1941, new String[]{"Orson Wells", "Joseph Cotten"}, new String[]{"Orson Welles"}, MovieGenre.HORROR, 8.5);

        isKidFriendly = movie.isKidFriendlyEligible();

        assertFalse("Type contains horror - isKidFriendlyEligible() should return false ", isKidFriendly);

        //TEST 3 movie type other -> should return true;

        movie  = BookmarkManager.getInstance().createMovie(3001, "The Grapes of Wrath", "", 1940, new String[]{"Henry Fonda", "Jane Darwell"}, new String[]{"John Ford"}, MovieGenre.CLASSICS, 8.2);

        isKidFriendly = movie.isKidFriendlyEligible();

        assertTrue("Type does not contain horror or thriller - isKidFriendlyEligible() should return true ", isKidFriendly);

    }

}
