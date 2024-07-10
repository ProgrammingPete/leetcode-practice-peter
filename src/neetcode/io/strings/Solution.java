package neetcode.io.strings;

public class Solution {
    public String addBinary(String a, String b) {
        char[] a_ = a.toCharArray();
        char[] b_ = b.toCharArray();
        int i = a_.length - 1;
        int j = b_.length - 1;
        char[] result = new char[Math.max(a_.length, b_.length)];
        int r = result.length - 1;
        boolean carry = false;
        while(i >= 0 && j >= 0) {
            if(a_[i] == '1' && b_[j] == '1') {
                if(!carry) { // 1 + 1 + 0 = 0 carry 1 
                    carry = true;
                    result[r] = '0';
                } else {
                    result[r] = '1';    // 1 + 1 + 1 = 1 carry 1
                }

            } else if((a_[i] == '1' && b_[j] == '0') || (a_[i] == '0' && b_[j] == '1')) {
                if(carry) {
                    result[r] = '0'; // 1 + 0 + 1 = 0 carry 1
                } else {
                    result[r] = '1'; // 1 + 0 + 0 = 1 carry 0
                }
            } else if(a_[i] == '0' && b_[j] == '0') {
                if(carry) {
                    result[r] = '1';
                    carry = false;
                } else {
                    result[r] = '0';
                }
            }
            i--;
            j--;
            r--;
        }
        while(i >= 0) {
            if(carry) {
                if(a_[i] == '0') {
                    result[r] = '1';
                    carry = false;
                } else {
                    result[r] = '0';
                }
            } else {
                result[r] = a_[i];
            }
            i--;
            r--;
        }
        while(j >= 0) {
            if(carry) {
                if(b_[j] == '0') {
                    result[r] = '1';
                    carry = false;
                } else {
                    result[r] = '0';
                }
            } else {
                result[r] = b_[j];
            }
            j--;
            r--;
        }
        if(carry) {
            char[] res = new char[result.length + 1];
            res[0] = '1';
            for(int x = 1; x <= result.length; x++){
                res[x] = result[x - 1];
            }
            return String.valueOf(res);
        }
        return String.valueOf(result);
    }

    
    public int strStr(String haystack, String needle) {
        char[] chars1 = haystack.toCharArray();
        char[] chars2 = needle.toCharArray();

        for(int windowLength = 0; windowLength <= chars1.length - chars2.length; windowLength++) { // range checks if there are enough chars left for thte neddle,  if not no need to continue
            for(int i = 0; i < chars2.length; i++) {
                if(chars1[windowLength + i] != chars2[i]) {
                    break;
                }
                if(i == chars2.length - 1) return windowLength;
            }
        }
        return -1;
    }
}
