import java.util.Arrays;

public class MinAbsolute {

    public static int minAbs(int a[] , int b[]){

        //To find min-Absolute we will first sort the array
        Arrays.sort(a);
        Arrays.sort(b);  

        int minAbs=0;
        //we have a built in MATH FUNCTION for finding absolute
        for(int i=0;i<a.length;i++){
            minAbs += Math.abs(a[i]-b[i]);
        }
        return minAbs;  
    }

    public static void main(String[] args) {
        int a[] = {4,1,8,7};
        int b[] = {2,3,6,5};
        System.out.println(minAbs(a, b));
    }
}
