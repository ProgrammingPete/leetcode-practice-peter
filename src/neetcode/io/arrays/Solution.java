package neetcode.io.arrays;

import java.util.Arrays;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // sort the array using quicksort in asc order
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        // return the kth largest element
        return nums[k -1];
    }
    
    private int[] quickSort(int[] arr, int s, int e) {
        //base case. is length of arr is 1. We get the length of the subarry by comparing the start and end pointers
        if (e - s + 1 <= 1) {
            return arr;
        }

        int pivot = arr[e]; // choose the last element as the pivot
        int left = s; // pointer for the left side

        for(int i = s; i < e; i++) { // i pointer
            if(arr[i] > pivot) {
                // swap the left and the ith numbers
                int temp = arr[left];
                arr[left] = arr[i];
                arr[i] = temp;
                left++; // increment left since we know that everything to the left should be somaller than the pivot
            }
        }
        
        //move pivot between the left and right sides
        arr[e] = arr[left];
        arr[left] = pivot;

        // Quick sort left side
        quickSort(arr, s, left - 1);

        // Quick sort right side
        quickSort(arr, left + 1, e);

        return arr;
    }
}
