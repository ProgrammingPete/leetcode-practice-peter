package medium.slidingwindow;

import java.util.HashMap;
import java.util.Map;

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
}