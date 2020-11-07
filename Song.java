public class Song implements Comparable<Song>{
   public String songTitle;
   public int streamCount;
   public String artistName;
   public int artistAverage;
   public Song start;
   public Song end;
   public Song() {
       this.songTitle = null;
       this.streamCount = 0;
       this.artistName = null;
       this.artistAverage = 0;
       start = null;
       end = null;
   }
   // constructor with arguments
   public Song(String songTitle, String artistName, int streamCount) {
       this.songTitle = songTitle;
       this.streamCount = streamCount;
       this.artistName = artistName;
       this.artistAverage = streamCount;
       start = null;
       end = null;
   }

   // set songTitle method
   public void setSongTitle(String songTitle) {
       this.songTitle = songTitle;
   }

   // get songTitle
   public String getSongTitle() {
       return this.songTitle;
   }

   // set streamCount method
   public void setStreamCount(int streams) {
       this.streamCount = streams;
   }

   // get streamCount
   public int getStreamCount() {
       return this.streamCount;
   }

   // set artistName
   public void setArtistName(String name) {
       this.artistName = name;
   }

   // get artistName
   public String getArtistName() {
       return this.artistName;
   }

   // set number of plays during comparison + 1
   public void setArtistAverage(Song obj) {
       this.artistAverage = (this.streamCount + obj.streamCount) / 2;
   }

   //compare string values of each song object
   public int compareTo(Song obj) {
       return this.songTitle.compareToIgnoreCase(obj.songTitle);
   }

   public String toString() {
       return this.songTitle + " by " + this.artistName + " has streamed " + this.streamCount + " times and streamed on average " + this.artistAverage + " times";
   }
}
