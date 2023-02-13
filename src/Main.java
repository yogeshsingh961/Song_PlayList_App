import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Album album1= new Album("Udd gye","Ritviz");
        album1.addSongToAlbum("song1",5.8);
        album1.addSongToAlbum("song2",3.3);
        album1.addSongToAlbum("song3",4.3);


        Album album2= new Album("Moosa","Sidhu Moosewala");
        album2.addSongToAlbum("old school",4.3);
        album2.addSongToAlbum("same beef",5.2);
        album2.addSongToAlbum("so high",5.9);

        List<Song> myplayList= new LinkedList<>();
        System.out.println(album1.addSongToPlaylistFromAlbum("song1",myplayList));
        System.out.println(album1.addSongToPlaylistFromAlbum(2,myplayList));
        System.out.println(album2.addSongToPlaylistFromAlbum("old school",myplayList));
        play(myplayList);

    }
     public static void play(List<Song> playList){
         ListIterator<Song> itr= playList.listIterator();

        if(playList.size()==0){
            System.out.println("myplayList is empty");
            return;
        }
        boolean isNext;
         System.out.println("Currently playing");
         System.out.println(itr.next());
         isNext=true;

        Scanner sc= new Scanner(System.in);
        while(true){
            System.out.println("Enter your choice");
            int choice=sc.nextInt();

            switch(choice){
                case 1:             // play next song
                    if(!isNext){
                        itr.next();
                        isNext=true;
                    }
                    if(itr.hasNext()){
                        System.out.println("Now playing");
                        System.out.println(itr.next());
                        isNext=true;
                    }else
                        System.out.println("You have reached the end of playList");

                    break;
                case 2:         // play previous song
                    if(isNext){
                        itr.previous();
                        isNext=false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println("Now playing");
                        System.out.println(itr.previous());
                        isNext=false;
                    }else
                        System.out.println("You are already on the first song");
                    break;
                case 3:          // play the current song again
                   if(isNext==true){
                       if(itr.hasPrevious()){
                           System.out.println(itr.previous());
                           isNext=false;
                       }
                   }else{
                       if(itr.hasNext()){
                           System.out.println(itr.next());
                           isNext=true;
                       }
                   }
                    break;
                case 4:
                   if(playList.size()>0){  // delete the current song
                      itr.remove();
                    }
                   if(itr.hasNext())
                       System.out.println("Now playing"+itr.next());
                   else if(itr.hasPrevious())
                       System.out.println("Now playing"+itr.previous());

                    break;
                case 5:
                     printAllSongs(playList);// show all songs
                    break;
                case 6:
                    printMenu(); // show menu again
                    break;
                case 7:       //exit.
                    System.out.println("Hope you enjoyed your playList");
                    return;

            }
        }

    }
    static void printMenu(){
        System.out.println("1: Play next song");
        System.out.println("2: Play previous song");
        System.out.println("3: play current song again");
        System.out.println("4: delete current song");
        System.out.println("5: show all songs");
        System.out.println("6: show menu again");
        System.out.println("7: Exit");
    }
    static void printAllSongs(List<Song> playList){
        for(Song s: playList){
            System.out.println(s);
        }
    }
}