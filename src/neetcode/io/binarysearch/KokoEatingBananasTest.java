package neetcode.io.binarysearch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * 
 * 875. Koko Eating Bananas https://leetcode.com/problems/koko-eating-bananas/
        Medium
        Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
        Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
        Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
        Return the minimum integer k such that she can eat all the bananas within h hours.

        This solution will use binary search. 


        Constraints:
            1 <= piles.length <= 104
            piles.length <= h <= 109
            1 <= piles[i] <= 109
 * 
 */
public class KokoEatingBananasTest {

    Solution sol = new Solution();

    /**
     * 
     * Example 1:

        Input: piles = [3,6,7,11], h = 8
        Output: 4
     */
    @Test
    void testMinEatingSpeedExample1() {
        int[] piles = new int[]{3,6,7,11};
        int h = 8;
        int actual = sol.minEatingSpeed(piles, h);
        int expected = 4;
        assertEquals(expected, actual);
    }

    /**
     * 
     * Example 2:

        Input: piles = [30,11,23,4,20], h = 5
        Output: 30
     */
    @Test
    void testMinEatingSpeedExample2() {
        int[] piles = new int[]{30,11,23,4,20};
        int h = 5;
        int actual = sol.minEatingSpeed(piles, h);
        int expected = 30;
        assertEquals(expected, actual);
    }

    /**
     * 
     * Example 3:

        Input: piles = [30,11,23,4,20], h = 6
        Output: 23
     * 
     */
    @Test
    void testMinEatingSpeedExample3() {
        int[] piles = new int[]{30,11,23,4,20};
        int h = 6;
        int actual = sol.minEatingSpeed(piles, h);
        int expected = 23;
        assertEquals(expected, actual);
    }
    /**
     * 
     * Example 4:

        Input: piles = [312884470], h = 312884469
        Output: 2
     * 
     */
    @Test
    void testMinEatingSpeedExample4() {
        int[] piles = new int[]{312884470};
        int h = 312884469;
        int actual = sol.minEatingSpeed(piles, h);
        int expected = 2;
        assertEquals(expected, actual);
    }

    /**
     * 
     * Example 5:
        Input: piles = [332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184], 
        h = 312884469
        Output: 35 and runs in less that 5000 milliseconds
     * 
     */
    @Test
    void testMinEatingSpeedExample5() {
        int[] piles = new int[]{332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184};
        int h = 312884469;
        long start = System.currentTimeMillis();
        int actual = sol.minEatingSpeed(piles, h);
        long end = System.currentTimeMillis();
        long runtime = (end - start);
        System.out.println(runtime + " milliseconds runtime");
        int expected = 35;
        assertEquals(expected, actual);
        assertTrue(runtime < (long)5000);
    }

}
