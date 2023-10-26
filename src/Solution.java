import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws Exception {
		Solution sol = new Solution();
		int maxSum = sol.longestConsecutive(new int[]{100,4,200,1,3,2});
		System.out.println(maxSum);
	}
	

	
	/**
	 * Largest Sum Contiguous Subarray - 
	 * Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers that has the largest sum. 
	 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
	 * 
	 * Uses Sliding Window
	 * 
	 * https://leetcode.com/problems/maximum-subarray/
	 * 
	 * kadane's algorithm
	 * 
	 * @param a
	 * @return
	 */
	public int maxSubArraySum(int a[]){
        int max_so_far = Integer.MIN_VALUE;
		int max_ending_here = 0;
 
        for (int i = 0; i < a.length; i++)
        {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
	}
	/**
	 * https://leetcode.com/problems/duplicate-zeros/
	 * @param arr
	 */
	public void duplicateZeros(int[] arr) {
		//count number of zeros in the array in a first pass
		// when we are duplicating the zeros we need to make sure we are not copying twice
		
	}
	/*
		use a HastSet from the list of numbers so that we can use contains()
		loop through elements in the hashset and skip elements if the element before the current elemt is in the list. 
			- This indicates that this element is already part of another sequence
		check if the next element contains the next number in this sequence, and if it does add to local count. 
			- break out of loop if the next integer is not in the HasSet
		Then compare the length of this sequence to the length of the max sequence, and return the max length
		
	 * https://leetcode.com/problems/longest-consecutive-sequence/
	 */
	public int longestConsecutive(int[] nums) {
		Set<Integer> numsSet = new HashSet<>();
		int longestSequence = 0;
		for(int num : nums){
			numsSet.add(num);
		}
		for(Integer num : numsSet){
			if(!numsSet.contains(num - 1)){ // only loop if current num is not already part of a sequence
				int seq = 1;
				while(numsSet.contains(num + 1)){
					seq++;
					num++;
				}
				longestSequence = Math.max(longestSequence, seq);
			}
		}
		return longestSequence;
    }

}
