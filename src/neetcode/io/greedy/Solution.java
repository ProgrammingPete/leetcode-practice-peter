package neetcode.io.greedy;

public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int lastIndex = n - 1;
        int maximumReachableIndex = 0;

        for(int i = 0; i < n; i++) {
            if(i > maximumReachableIndex) {
                return false;
            }
            maximumReachableIndex = Math.max(maximumReachableIndex, i + nums[i]);
            if(maximumReachableIndex >= lastIndex) { 
                return true;
            }
        }

        return maximumReachableIndex >= lastIndex;
    }


    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for(int i = 0; i < nums.length; i++){
            currentSum += nums[i];
            maxSum = Math.max(currentSum, maxSum);
            if(currentSum < 0)
                currentSum = 0;
        }
        return maxSum;
    }
}
