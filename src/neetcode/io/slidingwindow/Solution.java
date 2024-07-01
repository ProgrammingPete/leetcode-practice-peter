package neetcode.io.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int totalFruit(int[] fruits) {

        int left = 0;
        int right = 0;
        int maxLength = 0;
        Map<Integer, Integer> types = new HashMap<>();
        
        while(right < fruits.length) {
            types.put(fruits[right], types.getOrDefault(fruits[right], 0) + 1);
            if(types.size() > 2) {
                while(types.size() > 2) {
                    types.put(fruits[left], types.get(fruits[left]) - 1);
                    if(types.get(fruits[left]) == 0)
                        types.remove(fruits[left]);
                    left++;
                }
            }
            maxLength = Math.max((right - left) + 1, maxLength);
            right++;
        }
        return maxLength;
    }

    public boolean closeDuplicatesBruteForce(int[] nums, int k) {
        for(int L = 0; L < nums.length; L++) {
            for(int R = 0; R < Math.min(nums.length, L + k); R++) {
                if(nums[L] == nums[R]){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean closeDuplicates(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int L = 0;
        for(int R = 0; R < nums.length; R++) {
            if(R - L + 1 > k) {
                set.remove(nums[L]);
                L++;
            }
            if(set.contains(nums[R])) {
                return true;
            }
            set.add(nums[R]);
            

        }
        return false;
    }

}