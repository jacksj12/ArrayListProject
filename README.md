# Music Collection Project <ArrayList>

In this project you will be complete 3 classes to create a music collection system.

- Artist
- Song
- PlayList

The **Artist** class will store core information about an artist
The **Song** class will store basic information about a music song
The **PlayList** class will manage a list of artists and their ratings

## Song

**Constructor(s):**
-   `public Song( Artist _artist, String _name)`

**Instance Variables**

-   `private Artist artist`

-   `private String name`

**Methods**

-   `public String getName()`

-   `public Artist getArtist()`

-   `public boolean equals(Song other)` //returns `true` if both the song objects have the same artist and name.

-   `public String toString()`

## **Artist**
**Constructor(s):**
-   `public Artist(String name)`

**Instance Variables**

-   `private String artistName`
-   `private ArrayList<Song>  songs` //an array storing the songs of this artist

**Methods**

-   `public void addSong(String song)` //Create a song object (see above) and add it to the arraylist
-   `public String toString()`
-   `public boolean equals(Artist other)` //returns true  if the `artistNames` (only) are the same
-   `public ArrayList<Song> getSongs()`
-   `public String getName()`
## **PlayList**
**Constructor(s):**
-   `public PlayList(String name)` - There should be only 1 constructor that takes a parameter representing the name of the playList

**Static Variables**

-   `public static int MAX_NUMBER_SONGS= 10`   //for easy testing

**Instance Variables**

-   `private String listName`   //This is the "name" of your playList
-   `private ArrayList<Song> songs` //an array storing the songs of this artist
-  `private ArrayList<Integer> stars` //how many stars each song has
    - **Note: songs and stars are parallel ArrayLists**

**Accessor Methods**

-   `public double averageRating()` //returns the average star rating for the  list
-   `public ArrayList<Song> getSongs()` // returns the songs
-   `public double averageRating(Artist artist)` // returns the mean star rating associated with artist
-   `public Song[] getSongs(Artist artist)`  // returns an array populated by the songs of parameter artist
-  `public ArrayList<Artist> getArtist(String songName)` // returns an ArrayList of all Artists associated with the String songName (This could be multiple musicians. Cover songs etc..)
-   `private int indexOf(Song someSong)`
-   `public String toString()`  //returns an appropriate String representation of the PlayList
-   `public ArrayList<Integer> getStars()` //returns the `stars` ArrayList


**Mutator Methods**

-  `public void swap(Song song1 , Song song2, )` // switches positions of these two (maintain parallelism!)
-   `public boolean add(Song _song , int _stars)`  //adds data if number of song is less than `MAX_NUMBER_SONGS`
-   `public void removeSong(Song song)` //removes all occurrences of song by artist(there could be multiple instances of song).
-   `public void removeArtist(Artist artist )` //removes all elements associated with artist
-   `public void removeLowStars(int cutOff)` //removes all elements associated with a star rating less than or equal to `cutOff`

**Challenge Methods**
Only one of the following methods needs to be completed for full credit. Completing both will earn you extra credit
-  `public PlayList sortByRating()` //this returns a new rearranged `PlayList` so that the 5 starred elements are the first group in the list, 4 stars second …1 stars, last. If more than one songs has the same star rating they should appear in the same order as they were in the original list
    -   To do this you should use a sorting algorithm. I suggest one of the algorithm's on the AP Exam.
- `public PlayList shuffle()` //this returns a new `PlayList` in which all of the songs have been reordered randomly
