import java.util.Arrays;
import java.util.Comparator;

public class MaxLength {
    
    public static int maxLengthChainPairs(int pairs[][]){

        //Sorting based on 2nd number
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        //Adding first pair
        int chainLen=1;
        int chainEnd=pairs[0][1]; // First pair's 2nd No.
       
        for(int i=1;i<pairs.length;i++){
            if(pairs[i][0] >= chainEnd){
                chainLen++;
                chainEnd=pairs[i][1];
            }
        }
        return chainLen;
    }

    public static void main(String[] args) {
        int arr[][] = {{5,24},{39,60},{5,28},{27,40},{50,90}}; //[5][2]
        
        System.out.println(maxLengthChainPairs(arr));
    }

}
