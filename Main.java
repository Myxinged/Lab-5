import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

   static SongPlaylist lst = new SongPlaylist();

   public static void main(String[] args) throws IOException {
	   String[] file = { "C:\\JAVA\\Lab-4\\week1.csv", "C:\\JAVA\\Lab-4\\week2.csv",
               "C:\\JAVA\\Lab-4\\week3.csv", "C:\\JAVA\\Lab-4\\week4.csv" };
	 //Array list store the songs
	   ArrayList<String> Song = new ArrayList<>();
     //Store the artist
       ArrayList<String> Artist = new ArrayList<>();
     //Store the stream counts
       ArrayList<Integer> streamCounts = new ArrayList<>();
       for (String x : file) {
    	// initialize inputStream with files variable
           FileInputStream inputStream = new FileInputStream(x);
           Scanner sc = new Scanner(inputStream, StandardCharsets.UTF_8.name()); // initialize scanner to read

           while (sc.hasNextLine()) {
               String line = sc.nextLine();
             //split the commas
               String[] array = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            // checks the value of array greater than 1 if not don't set any value to it
               if (array.length > 1) {

                   for (int i = 0; i < array.length; i++) {
                     //remove the parenthesis in the string
                	   if (array[i].charAt(0) == '"') {
                           array[i] = array[i].substring(1, array[i].length() - 1);
                       }
                   }
                   Song.add(array[1]);
                   Artist.add(array[2]);
                   streamCounts.add(Integer.parseInt(array[3]));
               }
           }
           inputStream.close();
           sc.close();
       }
       makeBST(Song, Artist, streamCounts); // make BST

       lst.inorderTransversal();
   }

   // makes a queue of Song objects from 3 lists
   public static void makeBST(ArrayList<String> songLst, ArrayList<String> artistLst, ArrayList<Integer> streamLst) {
       for (int i = 0; i < songLst.size(); i++) {
           Song artist = new Song(songLst.get(i), artistLst.get(i), streamLst.get(i));
        // insert object into BST
           lst.insert(artist);
       }
   }
}
