package browser;

import java.util.*;
public class RecentlyPlayedStore {

	    private final int capacity;
	    private final Map<String, Deque<String>> userSongsMap;

	    public RecentlyPlayedStore(int capacity) {
	        this.capacity = capacity;
	        this.userSongsMap = new HashMap<>();
	    }

	     // Adding new song to the user recently played list and removing oldest song if the deque exceeds the capacity
	    public void addSong(String user, String song) {
	        Deque<String> userSongs = userSongsMap.computeIfAbsent(user, k -> new LinkedList<>());
	        userSongs.add(song);

	        if (userSongs.size() > capacity) {
	            userSongs.removeFirst();
	        }
	    }

	    // To retrieve the recently played songs list for the user 
	    public List<String> getRecentlyPlayedSongs(String user) {
	        return userSongsMap.get(user).stream()
	                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
	    }
	}

	
	

