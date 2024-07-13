package neetcode.io.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class findDifferenceOfTwoArraysTest {
    Solution sol = new Solution();

    @Test
    void testFindDifference_test1() {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1,3));
        result.add(Arrays.asList(4,6));
        Assertions.assertEquals(result, sol.findDifference(new int[] {1,2,3}, new int[] {2,4,6}));
    }
    @Test
    void testFindDifference_test2() {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(3));
        result.add(Arrays.asList(new Integer[0]));
        Assertions.assertEquals(result, sol.findDifference(new int[] {1,2,3,3}, new int[] {1,1,2,2}));
    }
    @Test
    void testFindDifference_test3() {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(-5,4));
        result.add(Arrays.asList(3));
        Assertions.assertEquals(result, sol.findDifference(new int[] {-3,6,-5,4,5,5}, new int[] {6,6,-3,-3,3,5}));
    }
}
