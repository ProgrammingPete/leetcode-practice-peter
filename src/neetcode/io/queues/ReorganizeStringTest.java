package neetcode.io.queues;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

/*
 * 
 * 

767. Reorganize String
Medium
Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

Return any possible rearrangement of s or return "" if not possible.

https://leetcode.com/problems/reorganize-string/description/
 * 
 */
public class ReorganizeStringTest {
    Solution sol = new Solution();
    @Test
    void testReorganizeString_test1() {
        assertEquals("aba", sol.reorganizeString("aab"));
    }
    @Test
    void testReorganizeString_test2() {
        assertEquals("", sol.reorganizeString("aaab"));
    }
}
