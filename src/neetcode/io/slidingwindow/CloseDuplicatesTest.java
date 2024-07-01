package neetcode.io.slidingwindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CloseDuplicatesTest {
    Solution sol = new Solution();
    @Test
    void testCloseDuplicatesBruteForce() {
        int[] arr= new int[] {1,2,3,2,3,3};
        int k = 2;
        Assertions.assertEquals(true, sol.closeDuplicatesBruteForce(arr, k));
    }
    @Test
    void testCloseDuplicates() {
        int[] arr= new int[] {1,2,3,2,3,3};
        int k = 2;
        Assertions.assertEquals(true, sol.closeDuplicates(arr, k));
    }
}
