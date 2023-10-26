package neetcode.io;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	
	public static void main(String[] args){
		Solution sol = new Solution();
		System.out.println(sol.isAnagram("aacc", "ccac"));
	}
	
	public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sLetterCount = new HashMap<>();
        Map<Character, Integer> tLetterCount = new HashMap<>();
		
		if(s.length() != t.length()){
			return false;
		}
		Character currentChar = null;
		for(int i = 0; i < s.length(); i++){
			currentChar = s.charAt(i);
			if(sLetterCount.get(currentChar) == null){
				sLetterCount.put(currentChar, 1);
			} else {
				sLetterCount.put(currentChar, sLetterCount.get(currentChar) + 1);
			}
			currentChar = t.charAt(i);
			if(tLetterCount.get(currentChar) == null){
				tLetterCount.put(currentChar, 1);
			} else {
				tLetterCount.put(currentChar, tLetterCount.get(currentChar) + 1);
			}
		}
		if(tLetterCount.size() != sLetterCount.size())
			return false;
		
		for(Character key : tLetterCount.keySet()){
			if(tLetterCount.get(key) != sLetterCount.get(key)){
				return false;
			}
		}
		for(Character key : sLetterCount.keySet()){
			if(tLetterCount.get(key) != sLetterCount.get(key)){
				return false;
			}
		}
		return true;
    }
	
	/**
	 * 
	 * Two Sum II - https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
	 * 
	 * General Idea: 
	 * 	Use a two pointers approach. Add two pointers to the end of the array, and since the array is sort in ascending order,
	 *  increment the first pointer to increase the sum and decremenet the left pointer to decrease the sum. Continue this
	 *  until the target is met 
	 * 
	 * @param numbers
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] numbers, int target) {
		int[] returnIndices = new int[2];
		
		int j = numbers.length - 1;
		for(int i = 0; i < numbers.length; ){
			if((numbers[0] + numbers[j]) == target)
				return new int[]{numbers[i],numbers[j]};
			if(j<= i)
				break;
		}
		
        return returnIndices;
    }
}
