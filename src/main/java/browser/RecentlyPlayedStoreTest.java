package browser;

import java.util.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RecentlyPlayedStoreTest {

	 @Test
	    public void testRecentlyPlayedStore() {
	        RecentlyPlayedStore store = new RecentlyPlayedStore(4);

	        // Adding songs for  "User1"
	        store.addSong("user1", "Song 1");
	        store.addSong("user1", "Song 2");
	        store.addSong("user1", "Song 3");
         store.addSong("user1", "Song 4");
         
	        // Adding songs for  "User2"
	        store.addSong("user2", "Song A");
	        store.addSong("user2", "Song B");
	        store.addSong("user2", "Song C");
	        store.addSong("user2", "Song D");
	        store.addSong("user2", "Song E");

	        // Retrieve recently played songs for  "user1"
	        List<String> user1Songs = store.getRecentlyPlayedSongs("user1");
	        List<String> expecteduser1Songs = Arrays.asList("Song 1", "Song 2", "Song 3","Song 4");
	        Assert.assertEquals(user1Songs, expecteduser1Songs);

	        // Retrieve recently played songs for "user2"
	        List<String> user2Songs = store.getRecentlyPlayedSongs("user2");
	        List<String> expecteduser2Songs = Arrays.asList("Song B", "Song C", "Song D","Song E");
	        Assert.assertEquals(user2Songs, expecteduser2Songs);
	    
	}

	
}
