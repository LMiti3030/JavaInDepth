package mititelu.laura.udemy.thrillio.entities;


import mititelu.laura.udemy.thrillio.DataStore;
import mititelu.laura.udemy.thrillio.managers.BookmarkManager;
import org.junit.Test;

import static org.junit.Assert.*;

public class WebLinkTest {

    @Test
    public void testIsKidFriendlyEligible(){
        //Test 1  porn in url - false
        Weblink weblink= BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2", "https://www.infoworld.com/article/2072759/taming-porn--part-2.html", "https://www.infoworld.com");

        boolean isKidFriendlyEligible = weblink.isKidFriendlyEligible();
        assertFalse("For porn in url - isKidFriendlyEligible() must return false ",isKidFriendlyEligible); //first arg in printed in case of true

        //Test 2 porn in title - false
        weblink= BookmarkManager.getInstance().createWebLink(2000, "Taming Porn, Part 2", "https://www.infoworld.com/article/2072759/taming-tiger--part-2.html", "https://www.infoworld.com");

         isKidFriendlyEligible = weblink.isKidFriendlyEligible();
        assertFalse("For porn in title - isKidFriendlyEligible() must return false ",isKidFriendlyEligible); //first arg in printed in case of true

        //Test 3 adult in host - false

        weblink= BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2", "https://www.infoworld.com/article/2072759/taming-tiger--part-2.html", "https://www.adult.com");

        isKidFriendlyEligible = weblink.isKidFriendlyEligible();
        assertFalse("For adult in host - isKidFriendlyEligible() must return false ",isKidFriendlyEligible); //first arg in printed in case of true

        //Test 4 adult in url, but not in host -> true

        weblink= BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2", "https://www.infoworld.com/article/2072759/taming-tiger--adult-2.html", "https://www.infoworld.com");

        isKidFriendlyEligible = weblink.isKidFriendlyEligible();
        assertTrue("For adult in url, but not in host - isKidFriendlyEligible() must return true ",isKidFriendlyEligible); //first arg in printed in case of true

        //Test 5 adult in title only -> true

        weblink= BookmarkManager.getInstance().createWebLink(2000, "Taming Adult, Part 2", "https://www.infoworld.com/article/2072759/taming-tiger--part-2.html", "https://www.infoworld.com");

        isKidFriendlyEligible = weblink.isKidFriendlyEligible();
        assertTrue("For adult in title only - isKidFriendlyEligible() must return true ",isKidFriendlyEligible); //first arg in printed in case of true

    }

}
