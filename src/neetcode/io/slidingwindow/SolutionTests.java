package neetcode.io.slidingwindow;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class SolutionTests {
    Solution sol = new Solution();
    @Test
    void testTotalFruitExample1() {
        int actual = sol.totalFruit(new int[] {1,2,1});
        int expected = 3;
        assertEquals(expected, actual);
    }
    @Test
    void testTotalFruitExample2() {
        int actual = sol.totalFruit(new int[] {0,1,2,2});
        int expected = 3;
        assertEquals(expected, actual);
    }
    @Test
    void testTotalFruitExample3() {
        int actual = sol.totalFruit(new int[] {1,2,3,2,2});
        int expected = 4;
        assertEquals(expected, actual);
    }
}
