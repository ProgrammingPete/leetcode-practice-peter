package neetcode.io.dynamicprogramming;

import java.util.List;

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
}
