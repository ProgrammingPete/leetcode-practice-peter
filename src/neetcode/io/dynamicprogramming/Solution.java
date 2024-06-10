package neetcode.io.dynamicprogramming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            //TODO
        // for each word check that the value of the word is at that index
        System.out.println("s: " + s);
        if(s.length() == 0) return true; // we return true because we know that if the string is empty that we dont need to continue

        for(String word : wordDict) {
            System.out.println("word : " + word);
            if(word.length() > s.length()) // skip the word
                continue;
            String subword = s.substring(0, word.length());
            if(subword.equals(word)) {
                return wordBreak(s.substring(word.length(), s.length()), wordDict);
            }
        }
        return false;
    }
    public int findTargetSumWays(int[] nums, int target) {
        if(nums.length == 1) {
            if(Math.abs(target) == nums[0]) {
                return 1;
            }  else {
                return 0;
            }
        }
        Map<Candidate, Integer> map = new HashMap<>();
        return findTargetSums(nums, 0, target, 0, map);
    }
    private int findTargetSums(int nums[], int i, int target, int sum, Map<Candidate, Integer> map) {
        if(i == nums.length) {
            if(target == sum)
                return 1;
            else
                return 0;
        } else { 
            Candidate candidate = new Candidate(i, sum);
            if(map.containsKey(candidate)) {
                return map.get(candidate);
            } else {
                map.put(candidate, (findTargetSums(nums, i + 1, target, sum + nums[i], map) 
                    + findTargetSums(nums, i + 1, target, sum - nums[i], map)));
                return map.get(candidate);
            }
        }
    }
}
