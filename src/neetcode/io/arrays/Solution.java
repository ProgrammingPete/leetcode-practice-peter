package neetcode.io.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        if(s.length() != t.length()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                if(map.get(s.charAt(i)) == -1) {
                    map.remove(s.charAt(i));
                } else {
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                }
            } else {
                map.put(s.charAt(i), 1);
            }
            if(map.containsKey(t.charAt(i))) {
                if(map.get(t.charAt(i)) == 1) {
                    map.remove(t.charAt(i));
                } else {
                    map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
                }
            } else {
                map.put(t.charAt(i), -1);
            }

        }
        return map.isEmpty();
    }
    public int[] findDiagonalOrder(int[][] mat) {
        // Check for empty matrices
        if (mat == null || mat.length == 0) {
            return new int[0];
        }
        int m = mat.length;
        int n = mat[0].length;

        int row = 0, column = 0;

        int[] result = new int[m*n];
        int r = 0;
        boolean up = true;
        while(row < m && column < n) {
            if (up) {
                while(row >= 0 && column < n) {
                    result[r++] = mat[row][column];
                    row--;
                    column++;
                }
                row++;
                if(column == n) {
                    row++;
                    column--;
                }
                up = false;
            } else {
                while(column >= 0 && row < m) {
                    result[r++] = mat[row][column];
                    row++;
                    column--;
                }
                column++;
                if(row == m) {
                    row--;
                    column++;
                }
                up = true;
            }
        }
        return result;
    }
}
