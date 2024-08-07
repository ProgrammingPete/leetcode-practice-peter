package neetcode.io.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class SortKMessedArrayTest {
    Solution sol = new Solution();
    @Test
    void testSortKMessedArray() {
        int k = 2;
        int[] arr = new int[] {
            1, 4, 5, 2, 3, 7, 8, 6, 10, 9
        };
        int[] actual = sol.sortKMessedArray(arr, k);
        System.out.println(Arrays.toString(actual));
        assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, actual);
    }
}
