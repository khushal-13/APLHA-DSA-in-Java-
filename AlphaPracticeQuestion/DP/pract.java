//import java.util.Arrays;

public class pract {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        for(int i=0;i<nums1.length;i++){
            int curr=nums1[i];
            for(int j=0;j<nums2.length;j++){
                if(nums2[j]==curr){
                    if(j==nums2.length-1){
                        nums1[i]=-1;
                        break;
                    }
                    while(j<nums2.length){
                        if(nums2[j] > curr){
                            nums1[i] = nums2[j];
                            break;
                        }
                        j++;
                    }
                    if(j==nums2.length-1) {nums1[i] = -1;}
                }
            }
        }
        return nums1;
    }


    public static void main(String[] args) {
        int nums1[] = {4,1,2};
        int nums2[] = {1,3,4,2};
        nextGreaterElement(nums1, nums2);
        for(int i=0;i<nums1.length;i++){
            System.out.print(nums1[i]+" ");
        }

        //f();

    }
}
