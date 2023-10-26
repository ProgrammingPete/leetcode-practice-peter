package neetcode.io.greedy;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 
 * 53. Maximum Subarray https://leetcode.com/problems/maximum-subarray/
        Medium
        31.5K
        1.3K
        Companies
        Given an integer array nums, find the 
        subarray
        with the largest sum, and return its sum.
 * 
 */
public class MaxSubArrayTest {
    Solution sol = new Solution();

    /*Explanation: The subarray [4,-1,2,1] has the largest sum 6. */
    @Test
    void testMaxSubArrayExample1() {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int expected = 6;
        int actual = sol.maxSubArray(nums);
        assertEquals(expected, actual);
    }

    /*Explanation: The subarray [1] has the largest sum 1. */
    @Test
    void testMaxSubArrayExample2() {
        int[] nums = new int[]{1};
        int expected = 1;
        int actual = sol.maxSubArray(nums);
        assertEquals(expected, actual);
    }
    
    /*Explanation: The subarray [5,4,-1,7,8] has the largest sum 23. */
    @Test
    void testMaxSubArrayExample3() {
        int[] nums = new int[]{5,4,-1,7,8};
        int expected = 23;
        int actual = sol.maxSubArray(nums);
        assertEquals(expected, actual);
    }
}
