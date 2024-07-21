import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class IndianCoins {
    
    public static void IndianCoin(Integer coins[]){

        //Sorting in Descending order ( therefore Integer type is used)
        Arrays.sort(coins, Comparator.reverseOrder());
        int count=0;
        int amount=1059;
        ArrayList<Integer> cc = new ArrayList<>();

        for(int i=0;i<coins.length;i++){
            if(coins[i] <= amount){
                while(coins[i]<=amount){
                    amount -= coins[i];
                    count++;
                    cc.add(coins[i]);
                }
            }
        }
        System.out.println(count);
        for(int i=0;i<cc.size();i++){
            System.out.print(cc.get(i)+" ");
        }
    }

    public static void main(String[] args) {
        Integer coins[] = {1,2,5,10,20,50,100,500,2000};
        IndianCoin(coins);
    }
}
