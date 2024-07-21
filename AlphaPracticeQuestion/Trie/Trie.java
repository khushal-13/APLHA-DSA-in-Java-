//import java.util.*;

public class Trie {

    static class Node{
        Node children [] = new Node[26];
        boolean eow = false;
        int frequency;
        public Node(){
            for(int i=0;i<26;i++){
                children[i] = null;
            }
            frequency=1;
        }
    }
    static Node root = new Node();//1st Empty Node

    // TC : O(L) L-Largest word
    public static void Insert(String word){//For particular Word
        Node curr=root;
        for(int level=0;level<word.length();level++){
            int idx=word.charAt(level)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow=true;
    }

    public static boolean search(String key){ // O(L)
        Node curr=root;
        for(int level=0;level<key.length();level++){
           int idx = key.charAt(level)-'a';
           if(curr.children[idx]==null){
            return false;
           }
           curr=curr.children[idx];
        }
        return curr.eow==true;
    }
   
    public static boolean wordBreak(String key){
        if(key.length()==0){
            return true;
        }

        for(int i=1;i<=key.length();i++){
            if(search(key.substring(0, i)) && wordBreak(key.substring(i))){
                return true;
            }
        }
        return false;
    }

    public static void PrefixInsert(String word){
      Node curr = root;
      for(int i=0;i<word.length();i++){
        int idx = word.charAt(i)-'a';
        if(curr.children[idx]==null){
           curr.children[idx] = new Node();
        }
        else
        {
           curr.children[idx].frequency++;
        }
        curr=curr.children[idx];
      }
      curr.eow=true;
    }

    public static void findPrefix(Node root,String ans){
        if(root==null){
            return;
        }

        if(root.frequency==1){
            System.out.println(ans);
            return;
        }

        for(int i=0;i<root.children.length;i++){
            if(root.children[i]!=null){
                  findPrefix(root.children[i], ans+(char)(i+'a'));
            }
        }
    }

    public static boolean startsWith(String prefix){
        Node curr = root;
        for(int i=0;i<prefix.length();i++){
            int idx=prefix.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        /* 
        String words [] = {"the","a","there","their","any","thee"};
        for(int i=0;i<words.length;i++){//Sending One-One Word
            Insert(words[i]);
        }

        System.out.println(search("any"));
        System.out.println(search("an"));
        System.out.println(search("anu"));
        */


        /* 
        //Word Break Problem
        String words [] = {"i","like","sam","samsung","ice","mobile"};
        for(int i=0;i<words.length;i++){//Sending One-One Word
            Insert(words[i]);
        }

       System.out.println( wordBreak("isam"));
     
       */

       /* 
       //Prefix Problem
       String words [] = {"zebra","dog","duck","dove"};
       for(int i=0;i<words.length;i++){//Sending One-One Word
           PrefixInsert(words[i]);
       }
       root.frequency=-1; 
       findPrefix(root,"");
      */

      /* */
      //startsWith
      String words [] = {"apple","app","mango","man","woman"};
      for(int i=0;i<words.length;i++){//Sending One-One Word
          PrefixInsert(words[i]);
      }

      System.out.println(startsWith("apple"));
      System.out.println(startsWith("mo"));

    }
}
