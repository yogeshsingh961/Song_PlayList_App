import java.util.ArrayList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private List<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songs=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
     boolean findSong(String title){
        for(Song song: songs){
            if(song.getTitle().equals(title))
                return true;
        }
        return false;
     }
     String addSongToAlbum(String title,double duration){
        if(findSong(title)==false){
            Song s= new Song(title,duration);
            songs.add(s);
            return "Song is added to Album";
        }
        return "This song already exists";
     }

     String addSongToPlaylistFromAlbum(String title, List<Song> playlist){
         if(findSong(title)==true){
             for(Song s: this.songs){
                 if(s.getTitle().equals(title)){
                     playlist.add(s);
                     return "Song is added to your playlist";
                 }
             }
         }
         return "Song is not present in Album";
     }
    // Method Overloading of above method
    String addSongToPlaylistFromAlbum(int trackNo, List<Song> playlist){
        int index=trackNo-1;
        if(index>=0 && index<this.songs.size()) {
           // if (!this.songs.contains(this.songs.get(index))) { // add only those songs from album which is not in playlist but not working
                playlist.add(this.songs.get(index));
                return "Song corresponding to index in songs is added to your playlist";
            //}
        }
        return "Not a valid index";
    }

}
