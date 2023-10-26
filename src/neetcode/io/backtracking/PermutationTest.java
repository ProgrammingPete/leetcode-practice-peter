package neetcode.io.backtracking;

import java.util.List;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class PermutationTest {
    Solution sol = new Solution();

    @Test
    void testPermuteExample1() {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(1,2,3));
        expected.add(List.of(1,3,2));
        expected.add(List.of(2,1,3));
        expected.add(List.of(2,3,1));
        expected.add(List.of(3,1,2));
        expected.add(List.of(3,2,1));
        List<List<Integer>> actual = sol.permute(nums);
        assertEquals(expected,actual);
    }
    @Test
    void testPermuteExample2() {
        int[] nums = new int[]{0,1};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(0,1));
        expected.add(List.of(1,0));
        List<List<Integer>> actual = sol.permute(nums);
        assertEquals(expected,actual);
    }
    @Test
    void testPermuteExample3() {
        int[] nums = new int[]{1};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(1));
        List<List<Integer>> actual = sol.permute(nums);
        assertEquals(expected,actual);
    }
}
