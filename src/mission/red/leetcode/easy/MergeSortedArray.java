package mission.red.leetcode.easy;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int ptr1 = m-1;
        int ptr2 = n-1;

        int k = m + n - 1;
        while(ptr1>= 0 && ptr2 >= 0){
            if(nums1[ptr1] > nums2[ptr2]){
                nums1[k] = nums1[ptr1];
                ptr1--;
            }else {
                nums1[k] = nums2[ptr2];
                ptr2--;
            }
            k--;
        }

        if(ptr1 >= 0){
            while(ptr1 >= 0){
                nums1[k] = nums1[ptr1];
                ptr1--;
                k--;
            }
        }

        if(ptr2 >= 0){
            while(ptr2 >= 0){
                nums1[k] = nums2[ptr2];
                ptr2--;
                k--;
            }
        }
    }


    public static void main(String[] args) {
        int[] num1 = {0};
        int[] num2 = {2};
        new MergeSortedArray().merge(num1, 0, num2, 1);
        System.out.println("Hello");
    }
}
