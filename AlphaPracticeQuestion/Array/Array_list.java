import java.util.ArrayList;
import java.util.Collections;

public class Array_list {

    public static boolean pairsum2()
    {
        int target = 20;
        ArrayList <Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
 
        int n=list.size();
        int bp=-1;//BreakingPoint
        for(int i=0;i<list.size()-1;i++)
        {
            if(list.get(i) > list.get(i+1))
            {
                bp=i;
                break;
            }
        }
        int lp=bp+1; //Smallest
        int rp=bp;   //Largest
        while(lp!=rp)
        {
           if(list.get(lp) + list.get(rp)==target)
           {
            return true;
           }
           else if (list.get(lp) + list.get(rp)<target)
           {
              lp = (lp+1)%n;
           }
           else
           {
               rp = (n+rp-1)%n;
           }
        }
        
        return false;
        
    }

    public static boolean PairSum1Optimized(ArrayList<Integer> list, int target)
    {
        int lp=0,rp=list.size()-1;
        while(lp<rp)
        {
            if(list.get(lp) + list.get(rp)==target)
            {
                return true;
            }

            if(list.get(lp) + list.get(rp)<target)
            {
               lp++;
            }

           else 
            {
                rp--;
            }
        }
        return false;

    }

    public static boolean PairSum1(ArrayList<Integer> list, int target)
    {
        for(int i=0;i<list.size();i++)
        {
            for(int j=0;j<list.size();j++)
            {
             if(list.get(i) + list.get(j)==target)
             {
                return true;
             }

            }
        }
        return false;
    }

    public static int StoredWater2Pointer()
    {
        ArrayList<Integer> h = new ArrayList<>();
       //1 8 6 2 5 4 8 3 7
       h.add(1);
       h.add(8);
       h.add(6);
       h.add(2);
       h.add(5);
       h.add(4);
       h.add(8);
       h.add(3);
       h.add(7);

       int lp = 0,rp = h.size()-1;
       int maxWater = 0;

       while(lp<rp)
       {
        //Calculate Water
          int height = Math.min(h.get(lp),h.get(rp));
          int width  = rp-lp;
          int water = height*width;
          maxWater = Math.max(water,maxWater); 

          //Update ptr
          if(lp<rp)
          {
           lp++;
          }
           else{
           rp--;
          }


     }

       return maxWater;

    }

    public static int StoredWater()
    {
       ArrayList<Integer> h = new ArrayList<>();
       //1 8 6 2 5 4 8 3 7
       h.add(1);
       h.add(8);
       h.add(6);
       h.add(2);
       h.add(5);
       h.add(4);
       h.add(8);
       h.add(3);
       h.add(7);

       System.out.println(h);

       int maxWater = 0;

       //BruteForce
       for(int i=0;i<h.size();i++)
       {
        for(int j=i+1;j<h.size();j++)
        {
            int width = j-i;
            int height = Math.min(h.get(i),h.get(j));
            int water = width*height;
            maxWater = Math.max(water,maxWater);
        }
       }
     
       return maxWater;
    }

    public static void MultidimensionalArrayList()
    {
        ArrayList<ArrayList<Integer>> main = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        for(int i=1;i<=5;i++)
        {
            list1.add(i);
            list2.add(i*2);
            list3.add(i*3);
        }

        main.add(list1);
        main.add(list2);
        main.add(list3);

        System.out.println(main);
       for(int i=0;i<main.size();i++)
       {
        ArrayList<Integer> curr = main.get(i);
        for(int j=0;j<curr.size();j++)
        {
            System.out.print(curr.get(j)+" ");
        }
        System.out.println();
       }

    }

    public static void Sort()
    {
        ArrayList<Integer> jk=new ArrayList<>();
        jk.add(4);
        jk.add(16);
        jk.add(2);
        jk.add(80);
        jk.add(10); 

        System.out.println(jk);

        Collections.sort(jk);
        System.out.println(jk);

        Collections.sort(jk,Collections.reverseOrder());
        System.out.println(jk);
        

        
        

    }

    public static void swap(ArrayList<Integer> list,int i1,int i2)
    {
        int temp = list.get(i1);
        list.set(i1,list.get(i2));
        list.set(i2,temp);

        System.out.println(list+" ");
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        //Add
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        //System.out.print(list+" ");

        /*
        //Get
        System.out.println(list.get(3));

        //Remove
        list.remove(2);
        System.out.println(list);

        //Set
        list.set(2,10);
        System.out.println(list);

        list.add(2,3);
        System.out.println(list);

        //Contains
        System.out.println(list.contains(10)); 
        System.out.println(list.contains(0)); 

        */

        /*
        //Size
        System.out.println(list.size());
        for(int i=list.size()-1;i>=0;i--)
        {
            System.out.print(list.get(i)+" ");
        }
        */

        /* 
        int max = Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++)
        {
            max = Math.max(max,list.get(i));
        }
        System.out.println(max);
        */

       // int indx1=1,indx2=3;
       // swap(list,indx1,indx2);

       //Sort();

      // MultidimensionalArrayList();



      //System.out.println(StoredWater());
     
      //System.out.println(StoredWater2Pointer());

     //System.out.println( PairSum1(list , 30));

     //System.out.println(PairSum1Optimized(list,50));

     //System.out.println(pairsum2());
    }
}
