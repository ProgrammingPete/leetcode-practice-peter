package neetcode.io.graphs;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

/*
 * 
 * 1091. Shortest Path in Binary Matrix https://leetcode.com/problems/shortest-path-in-binary-matrix/description/
Medium
Topics
Companies
Hint
Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.
 

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] is 0 or 1
 */
public class shortestPathBinaryMaxtrixTest {
    Solution sol = new Solution();

    @Test
    void testShortestPathBinaryMatrixEx1() {
        int[][] grid = new int[][] {
            {0,1},
            {1,0}
        };
        int expected = 2;
        assertEquals(expected, sol.shortestPathBinaryMatrix(grid));
    }
    
    @Test
    void testShortestPathBinaryMatrixEx2() {
        int[][] grid = new int[][] {
            {0,0,0},
            {1,1,0},
            {1,1,0}
        };
        int expected = 4; // we can go diagnol
        assertEquals(expected, sol.shortestPathBinaryMatrix(grid));
    }

    @Test
    void testShortestPathBinaryMatrixEx3() {
        int[][] grid = new int[][] {
            {1,0,0},
            {1,1,0},
            {1,1,0}
        };
        int expected = -1; // first node is marked as 1, so there is no path 
        assertEquals(expected, sol.shortestPathBinaryMatrix(grid));
    }

    @Test
    void testShortestPathBinaryMatrixEx4() {
        int[][] grid = new int[][] {
            {0}
        };
        int expected = 1; 
        assertEquals(expected, sol.shortestPathBinaryMatrix(grid));
    }

    @Test
    void testShortestPathBinaryMatrixEx5() {
        int[][] grid = new int[][] {
            {1,0,0},
            {1,1,0},
            {1,1,1}
        };
        int expected = -1; 
        assertEquals(expected, sol.shortestPathBinaryMatrix(grid));
    }
}
