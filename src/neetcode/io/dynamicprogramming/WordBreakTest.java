package neetcode.io.dynamicprogramming;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 
 * 
 * 
 * 139. Word Break
Medium
Topics
Companies
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 

Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
 * 
 * 
 */
public class WordBreakTest {
    Solution sol = new Solution();
    /*
     * 
     * Example 1:

        Input: s = "leetcode", wordDict = ["leet","code"]
        Output: true
        Explanation: Return true because "leetcode" can be segmented as "leet code".
     */
    @Test
    void testWordBreakEx1() {
        String s = "leetcode";
        List<String> wordDict = List.of("leet","code");
        assertTrue(sol.wordBreak(s, wordDict));
    }
    @Test
    void testWordBreakEx2() {
        String s = "applepenapple";
        List<String> wordDict = List.of("apple","pen");
        assertTrue(sol.wordBreak(s, wordDict));
    }
    @Test
    void testWordBreakEx3() {
        String s = "catsandog";
        List<String> wordDict = List.of("cats","dog","sand","and","cat");
        assertFalse(sol.wordBreak(s, wordDict));
    }
}
