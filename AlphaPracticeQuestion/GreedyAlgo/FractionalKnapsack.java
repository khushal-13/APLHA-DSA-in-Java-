import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    public static int FractKnapsack(int val[], int wt[], int w){
        //2D  matrix storing index and ratio
        double ratio[][] = new double[val.length][2];
        for(int i=0;i<ratio.length;i++){
            ratio[i][0] = i;
            ratio[i][1] = val[i]/wt[i];
        }
        //Lambda function for sorting on basis of ratio (Ascending)
        Arrays.sort(ratio, Comparator.comparingDouble(o ->o[1]));

        int capacity=w;
        int finalVal=0;
        for(int i=ratio.length-1;i>=0;i--){ // Since,Highest ratio is at bottom 
            //the ratio is used to access that index for getting weight
            int idx=(int) ratio[i][0];
            if(capacity>=wt[idx]){
                //Including full weight
                capacity -= wt[idx];
                finalVal += val[idx];
            }
            else{
                //include fractional item
                finalVal += ratio[i][1]*capacity;
                capacity=0;
                break;
            }
        }
        return finalVal; 
    }
    public static void main(String[] args) {
        int val[]={60,100,120};
        int  wt[]={10,20,30};
        int w=50;
        System.out.println(FractKnapsack(val, wt, w));
        
    }
    
}
