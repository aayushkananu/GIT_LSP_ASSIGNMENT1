package org.howard.edu.lsp.oopfinal.exam.question1;

import org.howard.edu.lsp.oopfinal.exam.SongsDatabase;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SongsDatabaseTest {
    @Test
    public void testAddSong() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Classical", "Moonlight Sonata");
        assertTrue(db.getSongs("Classical").contains("Moonlight Sonata"));
    }

    @Test
    public void testGetGenreOfSong() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Blues", "Crossroad Blues");
        assertEquals("Blues", db.getGenreOfSong("Crossroad Blues"));
    }

    @Test
    public void testGetSongs() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Blues", "Sweet Home Chicago");
        db.addSong("Blues", "The Thrill is Gone");
        Set<String> songs = db.getSongs("Blues");
        assertTrue(songs.contains("Sweet Home Chicago") && songs.contains("The Thrill is Gone"));
    }
}
