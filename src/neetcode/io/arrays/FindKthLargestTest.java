package neetcode.io.arrays;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

/*
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 * 215. Kth Largest Element in an Array
Medium
Topics
Companies
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting? NOT YET

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 

Constraints:
1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104

 */
public class FindKthLargestTest {
    Solution sol = new Solution();
    @Test
    void testFindKthLargest1() {
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2;
        assertEquals(5, sol.findKthLargest(nums, k));
    }
    @Test
    void testFindKthLargest2() {
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        int k = 4;
        assertEquals(4, sol.findKthLargest(nums, k));   
    }
    @Test
    void testFindKthLargest3_largeinput() throws IOException { 
        int[] nums = getNums("FINDKTHLARGEST_INPUT.txt");
        System.out.println(Arrays.toString(nums));
        int k = 50000;
        assertEquals(1, sol.findKthLargest(nums, k));   // stack overflow error
    }


    private String getTestInput(String name) throws IOException {
        String OS = System.getProperty("os.name").toLowerCase();
        String userDir = System.getProperty("user.home");
        String rel = "/git_projects/leetcode-practice-peter/src/resources/"; //DONT CHANGE PATH OF RELATIVE FILE
        if(OS.indexOf("win") >= 0) {
            rel = rel.replace("/", "\\");
            rel = rel.replace("onedrive", "OneDrive Personal");
        }
        Path file = Paths.get(userDir + rel + name);
        InputStream stream = Files.newInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String s = reader.readLine();
        stream.close();
        return s;
    }
    
    private int[] getNums(String name) throws IOException {
        String s = getTestInput(name);
        s = s.replace("[", "");
        s = s.replace("]", ""); 
        String[] vals = s.split (",");
        int[] nums = new int[vals.length];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(vals[i]);
        }
        return nums;
    } 
}
