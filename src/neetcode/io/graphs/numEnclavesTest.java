package neetcode.io.graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class numEnclavesTest {
    Solution sol = new Solution();
    @Test
    void testNumEnclaves_test1() {
        int[][] grid = new int[][] {
            {0,0,0,0},
            {1,0,1,0},
            {0,1,1,0},
            {0,0,0,0}
        };
        Assertions.assertEquals(3, sol.numEnclaves(grid));
    }
    @Test
    void testNumEnclaves_test2() {
        int[][] grid = new int[][] {
            {0,1,1,0},
            {0,0,1,0},
            {0,0,1,0},
            {0,0,0,0}
        };
        Assertions.assertEquals(0, sol.numEnclaves(grid));
    }
}
