import java.util.PriorityQueue;

public class WeakestSoldier {

    static class Row implements Comparable<Row>{
        int count,idx;
        public Row(int c, int i){
            this.count=c;
            this.idx=i;
        }

        @Override
        public int compareTo(Row r2){
            if(r2.count==this.count){
                return this.idx - r2.idx;
            }
            else{
                return this.count-r2.count;
            }
        }


    }
    

    public static void main(String[] args) {

        int soldier[][] = {{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        int k=2;

        PriorityQueue<Row> pq = new PriorityQueue<>();
        int count=0;
        for(int i=0;i<soldier.length;i++){
            for(int j=0;j<soldier[0].length;j++){
                count += soldier[i][j] == 1 ? 1 : 0;
            }
            pq.add(new Row(count, i));
            count=0;
        }   

        for(int i=0;i<k;i++){
            System.out.println("R -> "+pq.remove().idx);
        }
    }
}
