package neetcode.io.backtracking;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 79. Word Search https://leetcode.com/problems/word-search/
 * 
 * Try ot stick to the formula
 * 
 */
public class WordSearchTest {
    Solution sol = new Solution();

    @Test
    void testExistExample1() {
        // [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
        char[][] board = new char[3][];
        board[0] = new char[] {'A','B','C','E'};
        board[1] = new char[] {'S','F','C','S'};
        board[2] = new char[] {'A','D','E','E'};
        String word = "ABCCED";
        boolean actual = sol.exist(board, word);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    void testExistExample2() {
        // [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
        char[][] board = new char[3][];
        board[0] = new char[] {'A','B','C','E'};
        board[1] = new char[] {'S','F','C','S'};
        board[2] = new char[] {'A','D','E','E'};
        String word = "SEE";
        boolean actual = sol.exist(board, word);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    void testExistExample3() {
        // [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
        char[][] board = new char[3][];
        board[0] = new char[] {'A','B','C','E'};
        board[1] = new char[] {'S','F','C','S'};
        board[2] = new char[] {'A','D','E','E'};
        String word = "ABCB";
        boolean actual = sol.exist(board, word);
        boolean expected = false;
        assertEquals(expected, actual);
    }
}
