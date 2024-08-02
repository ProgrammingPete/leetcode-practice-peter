package neetcode.io.strings;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class GroupAnagramsTest {
    Solution sol = new Solution();
    @Test
    void testGroupAnagrams_test1() {
        String[] input = new String[] {
            "eat","tea","tan","ate","nat","bat"
        };
        List<List<String>> expected = new ArrayList<>();
        // ORDER MATTERS
        expected.add(Arrays.asList("tan", "nat"));
        expected.add(Arrays.asList("eat","tea","ate"));
        expected.add(Arrays.asList("bat"));
        assertEquals(expected, sol.groupAnagrams(input)); 
        List<List<String>> result = sol.groupAnagrams(input);
        System.out.println(result);
        System.out.println(expected);
    }
}
