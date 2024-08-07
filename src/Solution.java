import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

public class Solution {
 	 public static void main(String[] args) throws Exception {
		// Solution sol = new Solution();
		// // int maxSum = sol.longestConsecutive(new int[]{100,4,200,1,3,2});
		// // System.out.println(maxSum);
		// System.out.println(sol.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
		// System.out.println(sol.findTargetSumWays(new int[]{1000}, -1000));
	// 	    List<String> letters = new ArrayList(Arrays.asList("D","B","A","C","F","G"));
    //    Predicate<String> p1 = s -> s.compareTo("C") > 0;
    //    Predicate<String> p2 = s -> s.equals("B");
    //    letters.removeIf(p1.negate().or(p2));
    //    letters.sort((s1,s2) -> s1.compareTo(s2));
    //    System.out.println(letters);
	   String stringA = "A";
	   String stringB = "B";
	   String stringnull = null;
			 StringBuilder bufferc = new StringBuilder("C");
	   Formatter fmt = new Formatter(bufferc);

	   fmt.format("%s%s", stringA, stringB);
	   System.out.println("Line 1: "+ fmt);

	   fmt.format("%-2s", stringB);
	   System.out.println("Line 2: "+ fmt);

	   fmt.format("%b", stringnull);
	   System.out.println("Line 3: "+ fmt);

	   List<String> list = new ArrayList<String>();
	   list.add("1");
	   list.add("2");
	   list.add(0,"3");
	   list.add(1,"4");
	   list.forEach(System.out::println);
		
	   Runnable r = () -> System.out.println("HI");
	   new Thread(r).start();
	}
	
	class BaseLogger {
		// private static BaseLogger log = new BaseLogger();
		private BaseLogger() {}
		// public synchronized static BaseLogger getInstance() {
		// 	return log;
		// }
		private StringBuilder logMessage = new StringBuilder();
		public void addLog(String logMessage) {
			this.logMessage.append(logMessage + "|");
			//Logic to write log into file.
		}
		public void printLog() {
			System.out.println(logMessage.toString());//To print log.
		}
	}
	
	/**
	 * Largest Sum Contiguous Subarray - 
	 * Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers that has the largest sum. 
	 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
	 * 
	 * Uses Sliding Window
	 * 
	 * https://leetcode.com/problems/maximum-subarray/
	 * 
	 * kadane's algorithm
	 * 
	 * @param a
	 * @return
	 */
	public int maxSubArraySum(int a[]){
        int max_so_far = Integer.MIN_VALUE;
		int max_ending_here = 0;
 
        for (int i = 0; i < a.length; i++)
        {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
	}
	/**
	 * https://leetcode.com/problems/duplicate-zeros/
	 * @param arr
	 */
	public void duplicateZeros(int[] arr) {
		//count number of zeros in the array in a first pass
		// when we are duplicating the zeros we need to make sure we are not copying twice
		
	}
	/*
		use a HastSet from the list of numbers so that we can use contains()
		loop through elements in the hashset and skip elements if the element before the current elemt is in the list. 
			- This indicates that this element is already part of another sequence
		check if the next element contains the next number in this sequence, and if it does add to local count. 
			- break out of loop if the next integer is not in the HasSet
		Then compare the length of this sequence to the length of the max sequence, and return the max length
		
	 * https://leetcode.com/problems/longest-consecutive-sequence/
	 */
	public int longestConsecutive(int[] nums) {
		Set<Integer> numsSet = new HashSet<>();
		int longestSequence = 0;
		for(int num : nums){
			numsSet.add(num);
		}
		for(Integer num : numsSet){
			if(!numsSet.contains(num - 1)){ // only loop if current num is not already part of a sequence
				int seq = 1;
				while(numsSet.contains(num + 1)){
					seq++;
					num++;
				}
				longestSequence = Math.max(longestSequence, seq);
			}
		}
		return longestSequence;
    }

	/**
	 * 
	 * 494. Target Sum
Solved
Medium
Topics
Companies
You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.

 

Example 1:

Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
Example 2:

Input: nums = [1], target = 1
Output: 1
 

Constraints:

1 <= nums.length <= 20
0 <= nums[i] <= 1000
0 <= sum(nums[i]) <= 1000
-1000 <= target <= 1000
	 */
	private int result;
    public int findTargetSumWays(int[] nums, int target) {
        if(nums.length == 1) {
            if(Math.abs(target) == nums[0]) {
                return 1;
            }  else {
                return 0;
            }
        }
        findTargetSums(nums, -1, target);
        return result;
    }
    public void findTargetSums(int nums[], int count, int target) {
        if(count == nums.length - 1) {
            if(target == 0)
                result++;
        } else {
			count++;
            findTargetSums(nums, count, target - nums[count]);
            findTargetSums(nums, count, target + nums[count]);
        }
    }

}

class FormatTest{
    public static void main(String[] args) {
        // String stringA = "A";
        // String stringB = "B";
        // String stringnull = null;
        //       StringBuilder bufferc = new StringBuilder("C");
        // Formatter fmt = new Formatter(bufferc);

        // fmt.format("%s%s", stringA, stringB);
        // System.out.println("Line 1: "+ fmt);

        // fmt.format("%-2s", stringB);
        // System.out.println("Line 2: "+ fmt);

        // fmt.format("%b", stringnull);

        // System.out.println("Line 3: "+ fmt);



		// List<String> letters = new ArrayList(Arrays.asList("D","B","A","C","F","G"));
		// Predicate<String> p1 = s -> s.compareTo("C") > 0;
		// Predicate<String> p2 = s -> s.equals("B");
		// letters.removeIf(p1.negate().or(p2));
		// letters.sort((s1,s2) -> s1.compareTo(s2));
		// System.out.println(letters);


		// 		Long l = new Long(1234);
		// Long l1 = l;
		// if(l==l1)
		// System.out.println("Equal Objects");
		// else
		// System.out.println("Not Equal Objects");
		// l++;
		// if(l==l1)
		// System.out.println("Equal Objects");
		// else
		// System.out.println("Not Equal Objects");

		Predicate<String> lengther = (s) -> s.length() < 2;
        Predicate<String> equalizer = Predicate.isEqual("car");
        Function<Boolean,String> booleaner = i -> Boolean.toString(i);
        Function<String,Boolean> stringer  = s -> Boolean.parseBoolean(s);

		System.out.println(booleaner.compose(stringer).apply("true"));
		System.out.println(stringer.compose(booleaner).apply(true));
    }
}