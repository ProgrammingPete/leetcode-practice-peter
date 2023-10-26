package neetcode.io.greedy;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 
 * 55. Jump Game
Medium
17. 
958
Companies
You are given an integer array nums. You are initially positioned at the array's first index, 
and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 105
 * 
 * 
 */
public class JumpGameTest {
    Solution sol = new Solution();
    /**
     * 
     * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
     */
    @Test
    void testCanJumpExample1() {
        int[] nums = new int[] {2,3,1,1,4};
        boolean expected = true;
        boolean actual = sol.canJump(nums);
        assertEquals(expected,actual);
    }
    /**
     * 
     * You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
     */
    @Test
    void testCanJumpExample2() {
        int[] nums = new int[] {3,2,1,0,4};
        boolean expected = false;
        boolean actual = sol.canJump(nums);
        assertEquals(expected,actual);
    }
}
