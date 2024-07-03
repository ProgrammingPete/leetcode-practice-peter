package neetcode.io.arrays;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
 * 118. Pascal's Triangle https://leetcode.com/problems/pascals-triangle/description/
Solved
Easy
Topics
Companies
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 

Constraints:

1 <= numRows <= 30
 * 
 * 
 */
public class PascalsTriangleTest {
    Solution sol  = new Solution();
    @Test
    void testGenerate() {
        List<List<Integer>> expected = new ArrayList<>();
        // [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
        expected.add(List.of(1));
        expected.add(List.of(1,1));
        expected.add(List.of(1,2,1));
        expected.add(List.of(1,3,3,1));
        expected.add(List.of(1,4,6,4,1));
        Assertions.assertEquals(expected, sol.generate(5));
    }
    @Test
    void testGenerate2() {
        List<List<Integer>> expected = new ArrayList<>();
        // [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
        expected.add(List.of(1));
        Assertions.assertEquals(expected, sol.generate(1));
    }
}
