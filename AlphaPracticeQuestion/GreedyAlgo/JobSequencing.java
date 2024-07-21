import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class JobSequencing {

    //My Method
    public static void print(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void jobSequence(int arr[][]){
        
        int jobs[][] = new int[arr.length][3];
        for(int i=0;i<arr.length;i++){
            jobs[i][0] = i; //index
            jobs[i][1] = arr[i][0]; //deadline
            jobs[i][2] = arr[i][1]; //profit 
        }

        //Sortinf in ascending order
        Arrays.sort(jobs, Comparator.comparingDouble(o ->o[2]));
        ArrayList<Integer> seq = new ArrayList<>();

        int maxJobs=0;
        int time=0;
        //Reverse loop (as largest profit is at end)
        for(int i=jobs.length-1;i>=0;i--){
            int deadline=jobs[i][1];
            if(deadline>time){
                seq.add(jobs[i][0]);
                maxJobs++;
                time++;
            }
        }
        System.out.println("Maximum Jobs : "+maxJobs);
        for(int i=0;i<seq.size();i++){
            System.out.print("Job "+seq.get(i)+"\n");
        }
    }


    //Alpha Method
    static class Job{
        int id;
        int deadline;
        int profit;

        public Job(int i, int d, int p){
           id=i;
           deadline=d;
           profit=p;
        }

    }

    public static void JobSeq(){
        int jobInfo[][] = {{4,20},{1,10},{1,40},{1,30}};

        ArrayList<Job> jobs = new ArrayList<>();

        for(int i=0;i<jobInfo.length;i++){
            jobs.add(new Job(i,jobInfo[i][0], jobInfo[i][1]));
        }

        Collections.sort(jobs, (obj1,obj2) -> obj2.profit - obj1.profit);
        //descending order profit

        ArrayList<Integer> seq = new ArrayList<>();
        int time=0;

        for(int i=0;i<jobInfo.length;i++){
            Job curr = jobs.get(i);
            if(curr.deadline > time){
                seq.add(curr.id);
                time++;                
            }
        }

        //print sequence
        System.out.println("Max jobs : "+seq.size());
        for(int i=0;i<seq.size();i++){
            System.out.print(seq.get(i)+" ");
        }
    }
    public static void main(String[] args) {
        int jobInfo[][] = {{4,20},{1,10},{1,40},{1,30}};
        jobSequence(jobInfo);
    }
}
