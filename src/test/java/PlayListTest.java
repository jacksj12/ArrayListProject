import static org.testng.Assert.*;
import org.testng.annotations.*;

import java.util.*;

import java.util.ArrayList;
import java.util.Arrays;

public class PlayListTest {
    PlayList popList = new PlayList("pop");
    // artists
    Artist maroon = new Artist("Maroon 5");
    Artist biebs = new Artist("Justin Bieber");
    Artist coverArtist1 = new Artist("Maroon 4");
    Artist tones = new Artist("Tones and I");
    Artist rebeccaBlack = new Artist("Rebecca Black");
    Song holy = new Song(biebs, "Holy");
    Song peaches = new Song(biebs, "Peaches");
    Song girlLikeYou = new Song(maroon, "Girl Like You");
    Song girlLikeYou_cover = new Song(coverArtist1, girlLikeYou.getName());
    Song memories = new Song(maroon, "Memories");
    Song fridayRB = new Song(rebeccaBlack, "Friday");
    Song danceMonkey = new Song(tones, "Dance Monkey");


    @BeforeMethod
    public void setup() {
        popList = new PlayList("pop");
        popList.add(girlLikeYou, 4);
        popList.add(fridayRB, 1);
        popList.add(holy, 4);
        popList.add(peaches, 2);
        popList.add(girlLikeYou_cover, 1);
        popList.add(memories, 4);
        popList.add(danceMonkey, 3);
    }

    @Test
    public void testGetStars() {
        ArrayList<Integer> allStars = popList.getStars();
        Integer[] arrAllStars = {4, 1, 4, 2, 1, 4, 3};
        List<Integer> allStarsAns = Arrays.asList(arrAllStars);
        assertEquals(allStars, allStarsAns);
    }


    @Test
    public void testAverageRating() {
        assertTrue((Math.abs(popList.averageRating() - 2.714285714)) < .0001);
    }

    @Test
    public void testTestAverageRating() {
        assertTrue((Math.abs(popList.averageRating(biebs) - 3)) < .0001);
    }

    @Test
    public void testGetSongs() {
        ArrayList<Song> allSongs = popList.getSongs();
        Song[] arrAllSongs = {girlLikeYou, fridayRB, holy, peaches, girlLikeYou_cover, memories, danceMonkey};
        List<Song> allSongsAns = Arrays.asList(arrAllSongs);
        assertEquals(allSongs, allSongsAns);
    }

    @Test
    public void testGetSongsArtist() {
        Song[] biebsSongs = popList.getSongs(biebs);
        Song[] biebsSongsAns = {holy, peaches};
        assertEquals(biebsSongs, biebsSongsAns);
    }

    @Test
    public void testGetArtist() {
        ArrayList<Artist> allArtists = popList.getArtist("Girl Like You");
        Artist[] arrAllArtists = {maroon, coverArtist1};
        List<Artist> allArtistsAns = Arrays.asList(arrAllArtists);

        assertEquals(allArtists, allArtistsAns);
    }

    @Test
    public void testSwap1() {
        popList.swap(girlLikeYou, fridayRB);
        ArrayList<Song> allSongs = popList.getSongs();
        Song[] arrAllSongs = {fridayRB, girlLikeYou, holy, peaches, girlLikeYou_cover, memories, danceMonkey};
        List<Song> allSongsAns = Arrays.asList(arrAllSongs);
        assertEquals(allSongs, allSongsAns);
    }

    @Test
    public void testSwap2() {
        popList.swap(peaches, danceMonkey);
        ArrayList<Song> allSongs = popList.getSongs();
        Song[] arrAllSongs = {girlLikeYou, fridayRB, holy, danceMonkey, girlLikeYou_cover, memories, peaches};
        List<Song> allSongsAns = Arrays.asList(arrAllSongs);
        assertEquals(allSongs, allSongsAns);
    }

    @Test
    public void testSwapParallelism1() {
        popList.swap(girlLikeYou, fridayRB);
        assertEquals(popList.getSongs().size(), popList.getStars().size());
    }

    @Test
    public void testSwapParallelism2() {
        popList.swap(girlLikeYou, fridayRB);
        ArrayList<Integer> allStars = popList.getStars();
        Integer[] arrAllStars = {1, 4, 4, 2, 1, 4, 3};
        List<Integer> allStarsAns = Arrays.asList(arrAllStars);
        assertEquals(allStars, allStarsAns);
    }

    @Test
    public void testRemoveSong() {
        popList.removeSong(girlLikeYou_cover);
        ArrayList<Song> allSongs = popList.getSongs();
        Song[] arrAllSongs = {girlLikeYou, fridayRB, holy, peaches, memories, danceMonkey};
        List<Song> allSongsAns = Arrays.asList(arrAllSongs);
        assertEquals(allSongs, allSongsAns);
    }

    @Test
    public void testRemoveArtist() {
        popList.removeArtist(biebs);
        ArrayList<Song> allSongs = popList.getSongs();
        Song[] arrAllSongs = {girlLikeYou, fridayRB, girlLikeYou_cover, memories, danceMonkey};
        List<Song> allSongsAns = Arrays.asList(arrAllSongs);
        assertEquals(allSongs, allSongsAns);
    }
    
        @Test
    public void testSortByRating() {
        PlayList ansList = popList.sortByRating();
        ArrayList<Song> allSongs = ansList.getSongs();
        Song[] arrAllSongs = {memories,holy, girlLikeYou, danceMonkey, peaches, fridayRB, girlLikeYou_cover};
        List<Song> allSongsAns = Arrays.asList(arrAllSongs);
        assertEquals(allSongs, allSongsAns);
    }

    @Test
    public void testShuffle() {
        PlayList ansList = popList.shuffle();
        ArrayList<Song> allSongs = ansList.getSongs();
        Song[] arrAllSongs = {girlLikeYou, fridayRB, holy, peaches, girlLikeYou_cover, memories, danceMonkey};
        List<Song> allSongsAns = Arrays.asList(arrAllSongs);
        assertTrue(allSongs.size() == allSongsAns.size() && !(allSongsAns.equals(allSongs)));
    }
}
