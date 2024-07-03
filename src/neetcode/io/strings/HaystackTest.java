package neetcode.io.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HaystackTest {
    Solution sol = new Solution();
    @Test
    void testStrStr() {
        String haystack = "sadbutsad";
        String needle = "sad";
        Assertions.assertEquals(0, sol.strStr(haystack, needle));
    }
    @Test
    void testStrStr_test2() {
        String haystack = "leetcode";
        String needle = "leeto";
        Assertions.assertEquals(-1, sol.strStr(haystack, needle));
    }
    @Test
    void testStrStr_test3() {
        String haystack = "aaa";
        String needle = "aaaa";
        Assertions.assertEquals(-1, sol.strStr(haystack, needle));
    }
    @Test
    void testStrStr_test4() {
        String haystack = "mississippi";
        String needle = "issip";
        Assertions.assertEquals(4, sol.strStr(haystack, needle));
    }
    @Test
    void testStrStr_test5() {
        String haystack = "hello";
        String needle = "ll";
        Assertions.assertEquals(2, sol.strStr(haystack, needle));
    }
    @Test
    void testStrStr_test6() {
        String haystack = "mississippi";
        String needle = "issipi";
        Assertions.assertEquals(-1, sol.strStr(haystack, needle));
    }
}
