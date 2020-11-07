public class SongPlaylist {
   public Song root; // root node of BST
   public SongPlaylist() {
       root = null;
   }
   // returns whether BST is empty
   public boolean isEmpty() {
       return root == null;
   }

   //adds objects into BST;
   public void insert(Song obj) {
       if (root == null) {
           root = obj;
       }
       else {
           Song current = root;
           Song parent;
           while (true) {
               parent = current;
               if (obj.songTitle.compareToIgnoreCase(current.songTitle) == 0) {
                   current.setArtistAverage(obj);
                   return;
               }
               else if (obj.songTitle.compareToIgnoreCase(current.songTitle) < 0) {
                   current = current.start;
                   if (current == null) {
                       parent.start = obj;
                       return;
                   }
               }
               else {
                   current = current.end;
                   if (current == null) {
                       parent.end = obj;
                       return;
                   }
               }
           }
       }
   }

   // inorder transversal of BST
   public void inorderTransversal() {
       inorder(root);
   }
   // helper function or can be used to in order transversal for any subtree of BST
   public void inorder(Song root) {
       if (root == null) {
           return;
       }
    // transverses left of root
       inorder(root.start);
       System.out.println(root); // prints root
    // transverses right of root
       inorder(root.end); // transverses right of root
   }

   public void subset(String song1, String song2) {
       subset(root, song1, song2);
   }
   public Song subset(Song root, String song1, String song2) {
       if (root == null) {
           return root;
       }
       Song current = root;
       if (song1.compareTo(current.songTitle) < 0) {
           subset(current.start, song1, song2);
       }
       if ((song1.compareTo(current.songTitle) <= 0) && (song2.compareTo(current.songTitle) >= 0)) {
           System.out.println(current);
       }
       if (song2.compareTo(current.songTitle) > 0) {
           subset(current.end, song1, song2);
       }
       return root;
   }
}
