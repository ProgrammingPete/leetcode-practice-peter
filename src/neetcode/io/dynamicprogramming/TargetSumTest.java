package neetcode.io.dynamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TargetSumTest {
    Solution sol = new Solution();
    @Test
    void testFindTargetSumWays() {
        Assertions.assertEquals(5, sol.findTargetSumWays(new int[] {1,1,1,1,1}, 3));  ;
    }
    @Test
    void testFindTargetSumWays_Test2() {
        Assertions.assertEquals(1, sol.findTargetSumWays(new int[] {1}, 1));  ;
    }
    @Test
    void testFindTargetSumWays_Test3() {
        Assertions.assertEquals(40, sol.findTargetSumWays(new int[] {9,7,0,3,9,8,6,5,7,6}, 2));  ;
    }
}
