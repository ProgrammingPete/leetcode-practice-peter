package neetcode.io.graphs;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


import org.junit.jupiter.api.Test;

/**
 * 
 * 
 * 210. Course Schedule II
Medium
Topics
Companies
Hint
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All the pairs [ai, bi] are distinct.
 * 
 * 
 */
public class CourseSchedule2Test {
    Solution sol = new Solution();
    @Test
    void testFindOrder() {
        int[][] prerequisites = new int[][] {
            {1,0}
        };
        int[] expected = new int[] {0,1};
        assertArrayEquals(expected, sol.findOrder(2, prerequisites));
    }
        @Test
    void testFindOrder2() {
        int[][] prerequisites = new int[][] {
            {1,0},{2,0},{3,1},{3,2}
        };
        Arrays.asList(prerequisites).stream().filter(e -> e[0] == 1).toList();
        System.out.println(Arrays.deepToString(prerequisites));
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        Iterator<String> it = list.iterator();
        it.next();
        it.remove();
        System.out.println(list);
        int[] expected = new int[] {0,2,1,3};
        assertArrayEquals(expected, sol.findOrder(4, prerequisites));
    }
        @Test
    void testFindOrder3() {
        int[][] prerequisites = new int[][]{};
        int[] expected = new int[] {0};
        assertArrayEquals(expected, sol.findOrder(1, prerequisites));
    }
}
