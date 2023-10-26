package neetcode.io.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    /*
     * https://leetcode.com/problems/baseball-game/
     */
    public int calPoints(String[] operations) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for(String op : operations){
            if(op.equals("+")) {
                stack.push(stack.get(stack.size() - 1) + stack.get(stack.size() - 2));
            } 
            else if(op.equals("C")) {
                stack.pop();
            }
            else if(op.equals("D")) {
                stack.push(2 * stack.peek());
            }
            else {
                stack.push(Integer.parseInt(op));
            }

        }
        while(!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }


    	/**
	 * Decode String - https://leetcode.com/problems/decode-string/
	 * Given an encoded string, return its decoded string.
	 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. 
	 * Note that k is guaranteed to be a positive integer.
	 * 
	 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
	 *  For example, there will not be input like 3a or 2[4].
	 * 
	 * @param s
	 * @return
	 */
	public String decodeString(String s) {
		List<Character> subLetters = new ArrayList<>();
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) != ']'){
				stack.push(s.charAt(i));
			} else {
				subLetters = new ArrayList<>();
				while(!stack.isEmpty() && stack.peek() != '['){
					Character curr = stack.pop();
					subLetters.add(0, curr);
				}
				// System.out.println("Subletters: " + subLetters);
				stack.pop(); // pop the '['

				//get the k value multipier
				String multiplier = "";
				while(!stack.isEmpty() && Character.isDigit(stack.peek())){
					multiplier = stack.pop() + multiplier;
					// System.out.println("multiplier: "  + multiplier);
				}
				int multiplierInt = Integer.parseInt(multiplier);
				
				//convert list of chars to String
				String subString = "";
				for(Character ch: subLetters){
					subString += ch;
				}
				// System.out.println("SubString: " + subString);
				//do the multiplication
				String newSubString = "";
				for(int j = 0; j < multiplierInt; j++){
					newSubString += subString;
				}
				// System.out.println("SubString: " + subString);
                //push the multiplied string chars to the stack
				for(Character ch : newSubString.toCharArray())
					stack.push(ch);

			}
		}

		String decodedStr = "";
		while(!stack.isEmpty())
			decodedStr = stack.pop() + decodedStr;
		
        return decodedStr;
	}
}
