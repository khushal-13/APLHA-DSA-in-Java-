import java.util.*;

public class Pq{

    static class student implements Comparable<student>  {
        int id;String name;
        public student(int i, String n) {
            this.id = i;
            this.name = n;
        }

        @Override
        public int compareTo(student s2){
            return this.id-s2.id;
        }

    }

    static class heaps{

        static ArrayList<Integer> arr = new ArrayList<>();
        public  void add(int data){
            arr.add(data); // Adding node at last

            int x=arr.size()-1; // position of last node
            int par = (x-1)/2;  // position of parent node
            while(arr.get(x) < arr.get(par)){
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
                x=par;
                par=(x-1)/2;
            }
            
        }

        public void print(){
            for(int i=0;i<arr.size();i++){
                System.out.print(arr.get(i)+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
       
        //PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // pq.add(3);
        // pq.add(1);
        // pq.add(7);
        // pq.add(4);
        // while(!pq.isEmpty()){
        //     System.out.print(pq.remove()+" ");
        // }


        // PriorityQueue<student> pq = new PriorityQueue<>();
        // pq.add(new student(2, "Khushal"));
        // pq.add(new student(10, "Mane"));
        // pq.add(new student(3, "Pandey"));
        // pq.add(new student(5, "Yash"));
        // while(!pq.isEmpty()){
        //     System.out.println(pq.remove().name);
        // }


        // heaps h = new heaps();
        // h.add(4);
        // h.add(2);
        // h.add(3);
        // h.add(10);
        // h.add(5);
        // h.print();
        // h.add(1);
        // h.print();
        // h.add(11);
        // h.print();
    }
}