package neetcode.io.strings;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordCountEngineTest {
    Solution sol = new Solution();
    @Test
    void testWordCountEngine() {
        String document = "Practice makes perfect. you'll only get Perfect by practice. just practice!";
        String[][] expected = new String[][] {
            {"practice", "3"},
            {"youll", "1"}, 
            {"perfect", "2"}, 
            {"get", "1"}, 
            {"by", "1"}, 
            {"makes", "1"}, 
            {"only", "1"}, 
            {"just", "1"}
        };
        Assertions.assertTrue(Arrays.deepToString(expected).equals(Arrays.deepToString(sol.wordCountEngine(document))));
    }
}
