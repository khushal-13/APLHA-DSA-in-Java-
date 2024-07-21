import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySearch{

    public static void ActSearch(int start[], int end[]){
        int endTime,maxAct=0;

        //Sort on the basis of End-Time
        // As we know it is already sorted

        ArrayList<Integer> jk = new ArrayList<>();

        //Add First Activity (As we know it is the smallest task)
        maxAct=1;
        jk.add(0);
        endTime=end[0];
        //Loop from 1st activity 
        for(int i=1;i<start.length;i++){
            if(start[i]>=endTime){
                maxAct++;
                jk.add(i);
                endTime=end[i];
            }
        }

        System.out.println(maxAct);
        for(int i=0;i<jk.size();i++){
            System.out.print("A"+jk.get(i)+" ");
        }
    }

    public static void ActSearchSorting(int start[], int end[]){
        int activity[][] = new int[start.length][3];

        //Making a 2-D array with 3 columns
        // 0-Index 1-startTime 2-endTime
        for(int i=0;i<activity.length;i++){
            activity[i][0]=i;
            activity[i][1]=start[i];
            activity[i][2]=end[i];
        }
        //Lamda Function for sorting using comparators
        Arrays.sort(activity,Comparator.comparingDouble(o ->o[2]));

        int maxAct=0,endTime;
        ArrayList<Integer> jk = new ArrayList<>();

        //Choose 1st Task 
        maxAct=1;
        jk.add(activity[0][0]);
        endTime=activity[0][2];

        for(int i=0;i<activity.length;i++){
            if(activity[i][1] >= endTime){
                maxAct++;
                jk.add(activity[i][0]);
                endTime=activity[i][2];
            }
        }

        System.out.println(maxAct);
        for(int i=0;i<jk.size();i++){
            System.out.print("A"+jk.get(i)+" ");
        }

    }

    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};
        ActSearchSorting(start, end);

    }
}