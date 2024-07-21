import java.util.Scanner;

//import java.util.*;
class Dec_to_Bin
{
    
    public static void main(String[] args) {
        try (Scanner sc = new Scanner((System.in))) {
         System.out.print("Enter number : ");
         int n = sc.nextInt();
         int number=n;
         int pow=0,sum=0;
         int ld;
         while(n>0)
         {
            int rem=n%2;
            sum=sum + (int)Math.pow(10,pow);
            n=n/2;
            pow++;
         }
         //System.out.println(sum);
         System.out.println("Binary number of "+ number + " is "+sum);
        


            }
            
        }
       

    
        }


