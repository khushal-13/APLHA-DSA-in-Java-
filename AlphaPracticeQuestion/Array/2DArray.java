import java.util.Scanner;


public class DArray {

    static Scanner sc = new Scanner(System.in);

    public static boolean staircase(int matrix[][], int key)
    {
        int r,c;
       /*  IT IS FOR RIGHT CORNER ELEMENT
        r=0;
        c=matrix[0].length-1;
        while(r < matrix.length && c >=0)
        {
            if(matrix[r][c] == key)
            {
                System.out.println("Key found at index ("  + (r+1) +"," + (c+1)+")");
                return true;
            }
            else if(matrix[r][c] < key)
            {
                r++;
            }
            else 
            {
               c--;
            }
        }

        System.out.println("Key not found");
        return false;
        */



        // FOR LEFT CORNER ELEMENT
        r = matrix.length-1;
        c = 0;

        while(r >= 0 && c < matrix[0].length)
        {
          if(matrix[r][c] == key)
          {
            System.out.println("Key found at index (" + (r+1) + "," + (c+1)  + ")");
            return false ;
          }
          else if( matrix[r][c] < key )
          {
            c++;
          }
          else 
          {
            r--;
          }

        }

        System.out.println("Key not found ");
        return false;

    }

    public static void DiagonalSum(int matrix[][])
    {
        int sum=0;
      /*
        // 1-Method 
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(i==j)
                {
                     sum = sum + matrix[i][j];
                }

                if(i+j == matrix.length-1 && i != j)
                {
                    sum = sum + matrix[i][j];
                }
            }
        }
        System.out.println("Sum is : "+sum);
        */

        // 2-Method

        for(int i=0;i<matrix.length;i++)
        {
            sum += matrix[i][i];

            if(i != matrix.length-i-1) {
                sum += matrix[i][matrix.length-1-i];
            }
        }

        System.out.println("Sum is : "+sum);
    }


    public static void PrintSpiral(int matrix [][])
    {
        int startrow = 0; 
        int startcol = 0;
        int endrow = matrix.length-1;
        int endcol = matrix[0].length-1;

        while( startrow <= endrow && startcol <= endcol)
        {
            //Top
           for(int j=startcol;j <= endcol;j++)
            {
                System.out.print( matrix[startrow][j] + " ");
            }

            //Right 
            for( int i=startrow+1 ; i<=endrow ; i++)
            {
                System.out.print( matrix[i][endcol] + " ");
            }

            //Bottom
             for(int j=endcol-1;j>=startcol;j--)
            {
                if(startcol==endcol){
                    return;
                }
                System.out.print(matrix[endrow][j]+" ");
            } 

            //Left
            for(int i=endrow-1 ; i >=startrow+1 ; i--)
            {
                System.out.print(matrix[i][startcol]+" ");
            }
          
            startrow++;
            startcol++;
            endrow--;
            endcol--;

        }
           System.out.println();
    }

    public static void MaxMin(int m[][])
    {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<m.length;i++)
        {
            for(int j=0;j<m[0].length;j++)
            {
                if(m[i][j] < min)
                {
                   min = m[i][j];
                }
                if(m[i][j] > max)
                {
                    max = m[i][j];
                }
            }
        }

        System.out.println("Minimun value is " + min);
        System.out.println("Maximum value is " + max);
      
    }

    public static boolean search(int m[][], int key)
    {
        //int max = Integer.MIN_VALUE;
        //int min = Integer.MAX_VALUE;
        for(int i=0;i<m.length;i++)
        {
            for(int j=0;j<m[0].length;j++)
            {
                if(m[i][j] == key)
                {
                   System.out.println("Key found at index : " + i+"," + j);
                   return true;
                }
            }

        }
        System.out.println("Element not found");
        return false;
    }
    public static void main(String[] args) {
           
        // int matrix[][] = new int[3][3];
        int matrix[][] = {{1,2,3},
                           {6,7,8},
                           {11,12,13}};

        // int matrix[][] = {
        //     {1,2,3,4},
        //     {5,6,7,8},
        //     {9,10,11,12} };
                           
        // int n = matrix.length;
        // int m = matrix[0].length;
     
        
        // for(int i=0;i<n;i++)
        // {
        //     for(int j=0;j<m;j++)
        //     {
        //         matrix[i][j] = sc.nextInt();
        //     }
        // }

        // for(int i=0;i<n;i++)
        // {
        //     for(int j=0;j<m;j++)
        //     {
        //         System.out.print(matrix[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        
       
      //  System.out.println("Enter key");
       // int key = sc.nextInt();
         // int key = 2;
         // search(matrix,key);
         // MaxMin(matrix);
          PrintSpiral(matrix);
         // DiagonalSum(matrix);
  // staircase(matrix,key);
        
    
    }
}
