package neetcode.io.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class isAnagramTest {
    Solution sol = new Solution();
    @Test
    void testIsAnagram() {
        Assertions.assertEquals(true, sol.isAnagram("racecar", "carrace"));
    }
    @Test
    void testIsAnagra_test2() {
        Assertions.assertEquals(false, sol.isAnagram("jar", "jam"));
    }
    @Test
    void testIsAnagra_test3() {
        Assertions.assertEquals(false, sol.isAnagram("xx", "x"));
    }
    @Test
    void testIsAnagra_test4() {
        Assertions.assertEquals(true, sol.isAnagram("anagram", "nagaram"));
    }
}
