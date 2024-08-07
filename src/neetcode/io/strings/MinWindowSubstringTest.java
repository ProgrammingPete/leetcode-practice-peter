package neetcode.io.strings;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class MinWindowSubstringTest {
    Solution sol = new Solution();
    @Test
    void testMinWindow() {  
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String expected =  "BANC";
        String actual = sol.minWindow(s, t);
        assertEquals(expected, actual);
    }
}
