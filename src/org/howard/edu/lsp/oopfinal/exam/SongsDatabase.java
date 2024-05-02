package org.howard.edu.lsp.oopfinal.exam;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SongsDatabase {
    private Map<String, Set<String>> map = new HashMap<String, Set<String>>();

    // adding a song title to a genre 
    public void addSong(String genre, String songTitle) {
        if (!map.containsKey(genre)) {
            map.put(genre, new HashSet<>());
        }
        map.get(genre).add(songTitle);
    }

    // given a song title, return genre
    public String getGenreOfSong(String songTitle) {
        for (String genre : map.keySet()) {
            if (map.get(genre).contains(songTitle)) {
                return genre;
            }
        }
        return null; // song not found
    }

    // return the set that contains all songs for a genre 
    public Set<String> getSongs(String genre) {
        return map.getOrDefault(genre, new HashSet<>());
    }
    
}
