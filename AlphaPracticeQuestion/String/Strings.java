import java.util.Arrays;

//import java.util.Scanner;

public class Strings {

    public boolean Palindrome(String str){
        //METHOD 1
        // String str1 = str;
        // String str2 = "" ;
        // for(int i=str1.length()-1;i>=0;i--){
        //     str2 += str1.charAt(i);
        // }
        // if(str1 == str2){
        //    return true;
        // }
        // else
        // {
        //     return false;
        // }

        //METHOD2
        int n=str.length()-1;
        for(int i=0;i<n/2;i++){
            if(str.charAt(i)!=str.charAt(n-i)){
                return false;
            }
        }
        return true;
    }

    public String longestPalindrome(String s) {
        String str,res="";
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
            str = s.substring(i, j);
            if(palindrome(str)){
               if(str.length() > res.length()){
                   res = str;
               }
            } 
        }
    }
    return res;
    }

    public static String LongestPrefix(String str[]){
       StringBuilder res = new StringBuilder();

       Arrays.sort(str);
       String first = str[0];
       String last  = str[str.length-1];
       
       for(int i=0;i<first.length();i++){
        if(first.charAt(i) != last.charAt(i)){
            break;
        }
           res.append(first.charAt(i));   
       }
       return res.toString();
    }

    public static String compressBuilder(String str)
    {
      StringBuilder sb = new StringBuilder("");

      for(int i=0;i<str.length();i++)
      {
        Integer count=1;
        while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1))
        {
            count++;
            i++;
        }
        if(count > 1)
        {
           sb.append(str.charAt(i));
           sb.append(count.toString());       
        }
        else
        {
            sb.append(str.charAt(i));
        }  
    }
      return sb.toString();
    }

    public static String compress(String str)
    {
        String newStr = "";
       
        for(int i=0;i<str.length();i++)
        {
           Integer  count=1;
            while(i<str.length()-1  &&  str.charAt(i) == str.charAt(i+1))
            {
              count++;
              i++;
            }
          newStr += str.charAt(i);
          if(count > 1)
          {
            newStr += count.toString();
          }

        }
        return newStr;
    }


    public static String toUppercase(String str)
   {
        StringBuilder sb = new StringBuilder("");

        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for(int i=1;i<str.length();i++)
        {
            if(str.charAt(i) == ' ' && i < str.length())
            {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
            else
            {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

    public static float ShortestPath(String path)
    {
        int x=0,y=0;
        int n = path.length();
        for(int i=0;i<n;i++)
        {
            // rigth
            if(path.charAt(i)=='E')
            {
                 x+=1;
            }

            else if(path.charAt(i)=='W')
            {
                x-=1;
            }

            else if(path.charAt(i)=='N')
            {
                y+=1;
            }

            else
            {
                y-=1;
            }
        }

        int x2,y2;
        x2 = x*x; y2=y*y;
        return (float)Math.sqrt(x2+y2);

    }

    public static boolean palindrome(String str) {

        int n=str.length();
        for(int i=0;i<n/2;i++)
        {
            if(str.charAt(i) != str.charAt(n-1-i))
            {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        
       // Scanner sc = new Scanner(System.in);
        //String  Fname,Lname ;

        /* 
        // Taking Input (Use Line for compelete sentence)
        Fname = sc.nextLine();
        System.out.println(Fname);

        // Length 
        System.out.println(Fname.length());
        
        Lname = sc.nextLine();
        System.out.println(Lname);

        //Concatenate (Joining of two string)
        System.out.println(Fname + " " + Lname);

        */

        //Check Palindrome
        //System.out.println(palindrome("racecar"));

        //System.out.println(ShortestPath("WN"));

       // String str = new String("hi i am khushal");
       // System.out.println(toUppercase(str));



        //Compression using string
       // String str = new String("aaabcccd");
        //System.out.println(compress(str));

         
        //Compression using String builder

        //String str[] = {"flower","flow","flight"};
       // System.out.println(compressBuilder(str));
      // System.out.println(str.substring(0,4));

      //System.out.println(LongestPrefix(str));

       
    }    
}
