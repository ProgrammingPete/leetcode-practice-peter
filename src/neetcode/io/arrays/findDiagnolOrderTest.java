package neetcode.io.arrays;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class findDiagnolOrderTest {
    Solution sol = new Solution();

    @Test
    void testFindDiagonalOrder() {
        int[][] arr = new int[][] {
            {1,2,3},{4,5,6},{7,8,9}
        };
        Assertions.assertEquals(Arrays.toString(new int[] {1,2,4,7,5,3,6,8,9}), Arrays.toString(sol.findDiagonalOrder(arr)));
    }
    @Test
    void testFindDiagonalOrder_test2() {
        int[][] arr = new int[][] {
            {1,2},{3,4}
        };
        Assertions.assertEquals(Arrays.toString(new int[] {1,2,3,4}), Arrays.toString(sol.findDiagonalOrder(arr)));
    }
}
