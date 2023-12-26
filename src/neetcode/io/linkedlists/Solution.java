package neetcode.io.linkedlists;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.test();
    }
    void test(){
        for(int i = 1, j = i - 1; i < 100; i++, j++){ // j is only set once at the beginning of hte list, and then it is incremented
            // this is valid synta
            System.out.println("i: " + i);
            System.out.println("j: " + j);
        }
    }
}
