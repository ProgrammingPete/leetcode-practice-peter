package neetcode.io.backtracking;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
    /**
     * 
     * 39. Combination Sum https://leetcode.com/problems/combination-sum/
                Medium
                17.1K
                344
                Companies
                Given an array of distinct integers candidates and a target integer target, 
                return a list of all unique combinations of candidates where the chosen numbers sum to target. 
                You may return the combinations in any order.

                The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
                frequency
                of at least one of the chosen numbers is different.

                The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

                

                Example 1:

                Input: candidates = [2,3,6,7], target = 7
                Output: [[2,2,3],[7]]
                Explanation:
                2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
                7 is a candidate, and 7 = 7.
                These are the only two combinations.
                Example 2:

                Input: candidates = [2,3,5], target = 8
                Output: [[2,2,2,2],[2,3,3],[3,5]]
                Example 3:

                Input: candidates = [2], target = 1
                Output: []
                

                Constraints:

                1 <= candidates.length <= 30
                2 <= candidates[i] <= 40
                All elements of candidates are distinct.
                1 <= target <= 40

     * 
     * 
     * 
     * 
     * @param candidates
     * @param target
     * @return
     */
public class CombinationSumTest {
    Solution solution = new Solution();

    @Test
    void testCombinationSumExample1() {
        int[] candidates = new int[] {2,3,6,7};
        int target = 7;
        List<List<Integer>> actual = solution.combinationSum(candidates, target);
        List<List<Integer>> expected = new ArrayList<List<Integer>>();
        expected.add(new ArrayList<>());
        expected.get(0).add(2);
        expected.get(0).add(2);
        expected.get(0).add(3);
        expected.add(new ArrayList<>());
        expected.get(1).add(7);
        assertEquals(expected, actual);
    }

    @Test
    void testCombinationSumExample2() {
        int[] candidates = new int[] {2,3,5};
        int target = 8;
        List<List<Integer>> actual = solution.combinationSum(candidates, target);
        List<List<Integer>> expected = new ArrayList<List<Integer>>();
        expected.add(new ArrayList<>());
        expected.get(0).add(2);
        expected.get(0).add(2);
        expected.get(0).add(2);
        expected.get(0).add(2);
        expected.add(new ArrayList<>());
        expected.get(1).add(2);
        expected.get(1).add(3);
        expected.get(1).add(3);
        expected.add(new ArrayList<>());
        expected.get(2).add(3);
        expected.get(2).add(5);
        assertEquals(expected, actual);
    }

    @Test
    void testCombinationSumExample3() {
        int[] candidates = new int[] {2};
        int target = 1;
        List<List<Integer>> actual = solution.combinationSum(candidates, target);
        List<List<Integer>> expected = new ArrayList<List<Integer>>();

        assertEquals(expected, actual);
    }


/* START OF Combination Sum 2  https://leetcode.com/problems/combination-sum-ii/*/
/**
 * Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.
Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:
Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
Constraints:
1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30
 * 
 */
    @Test
    void testCombinationSum2Example1() {
        int[] candidates = new int[] {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> actual = solution.combinationSum2(candidates, target);
        List<List<Integer>> expected = new ArrayList<List<Integer>>();
        expected.add(List.of(1,2,5));
        expected.add(List.of(1,7));
        expected.add(List.of(1,1,6));
        expected.add(List.of(2,6));
        assertEquals(expected, actual);
    }
    @Test
    void testCombinationSum2Example2() {
        int[] candidates = new int[] {2,5,2,1,2};
        int target = 5;
        List<List<Integer>> actual = solution.combinationSum2(candidates, target);
        List<List<Integer>> expected = new ArrayList<List<Integer>>();
        expected.add(List.of(1,2,2));
        expected.add(List.of(5));
        assertEquals(expected, actual);
    }
    @Test
    void testCombinationSum2Example3() {
        int[] candidates = new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int target = 27;
        List<List<Integer>> actual = solution.combinationSum2(candidates, target);
        List<List<Integer>> expected = new ArrayList<List<Integer>>();
        // int sum = expected.get(0).stream().mapToInt(Integer::intValue).sum();
        // expected.add(List.of(5));
        assertEquals(expected, actual);
    }
    @Test
    void testCombinationSum2Example4() {
        int[] candidates = new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}; // 100 ones .. this test should be able to use 30 of them
        int target = 30;
        List<List<Integer>> actual = solution.combinationSum2(candidates, target);
        List<List<Integer>> expected = new ArrayList<List<Integer>>();
        expected.add(List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        int sum = 0;
        // sum = expected.get(0).stream().mapToInt(Integer::intValue).sum();
        // sum = Arrays.stream(candidates).sum();
        // System.out.println(sum);
        assertEquals(expected, actual);
    }
}
