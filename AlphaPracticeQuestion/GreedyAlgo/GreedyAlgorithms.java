import java.util.*;


public class GreedyAlgorithms {  

    public static void Chocola(){
        //int n=4,m=6;
        Integer cosV[] = {2,1,3,1,4};//m-1
        Integer cosH[] = {4,1,2};//n-1

        Arrays.sort(cosV, Collections.reverseOrder());//Descending Order
        Arrays.sort(cosH, Collections.reverseOrder());//"               "

        int h=0,v=0;//Two pointer pointing at the index used for comparison
        int hp=1,vp=1;//Represents number of pieces after every cut
        int cost=0;

        while(h<cosH.length && v<cosV.length){
            //If Horizontal cut is expensive
            if(cosH[h] >= cosV[v]){ //Horizontal cut
                cost += (cosH[h]*vp);
                hp++; //After cut peices will increse 
                h++; //Incrementing pointer at horizontal cost Array
            }            
            else{
                //Vertical cut
                cost += (cosV[v]*hp);
                vp++;
                v++;
            }
        }

        //Remaining Horizontal peices
        while(h<cosH.length){ //Horizontal cut
            cost += (cosH[h]*vp);
            hp++; //After cu peices will increse 
            h++; //Incrementing pointer at horizontal cost Array
        }   

        while(v<cosV.length){ //Vertical cut
        cost += (cosV[v]*hp);
        vp++; //After cut peices will increse 
        v++; //Incrementing pointer at Vertical cost Array
    }   


    System.out.println("Minimum cost is : "+cost);
        
    }

    public static void main(String[] args) {
        //Chocola();        
    }
}


