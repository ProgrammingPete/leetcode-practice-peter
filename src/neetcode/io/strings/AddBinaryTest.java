package neetcode.io.strings;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddBinaryTest {
    Solution sol = new Solution();
    @Test
    void testAddBinary() {
        String a = "11";
        String b = "1";
        Assertions.assertEquals("100", sol.addBinary(a, b) );
    }

    @Test
    void testAddBinary_test2() {
        String a = "1010";
        String b = "1011";
        Assertions.assertEquals("10101", sol.addBinary(a, b) );
    }
}
