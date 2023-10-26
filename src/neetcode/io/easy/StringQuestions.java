package neetcode.io.easy;

public class StringQuestions {
    public static void main(String[] args) {
        StringQuestions reverseString = new StringQuestions();
        // System.out.println(reverseString.reverseString("This is a test"));
        System.out.println(reverseString.validPalindrome("level"));
        System.out.println(reverseString.validPalindrome("algorithm"));
        System.out.println(reverseString.validPalindrome("A man, a plan, a canal: Panama."));
        
    }

    /**
     * Write a function that reverses a string. The input string is given as an array of characters s.

        You must do this by modifying the input array in-place with O(1) extra memory.
     * @param string
     * @return
     */
    public String reverseString(String string) {
        int low = 0;
        int high = string.length() - 1;
        char[] chars = string.toCharArray();
        char temp = chars[0];
        
        while(low < high) {
            temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }

        return new String(chars);

    }

    public boolean validPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;
        char[] chars = s.toCharArray();

        while(low < high) {

            if(!Character.isLetter(chars[low])) {
                low++;
                continue;
            }

            if(!Character.isLetter(chars[high])) {
                high--;
                continue;
            }

            if(Character.toLowerCase(chars[high]) == Character.toLowerCase(chars[low])) {
                low++;
                high--;
                continue;
            } else {
                return false;
            }

        }

        return true;
    }
}
