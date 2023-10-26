package neetcode.io.binarysearch;

public class Solution extends GuessGame {
    public Solution() {
        this(-1);
    }
    public Solution(int pick) {
        super(pick);
    }

    public int minEatingSpeed(int[] piles, int h) {
        // number of piles is always less than h so we dont need to check if it is possible
        // if number of piles was greater than h it would not be possible
        int max = piles[0];
        for(int pile : piles) {
            max = Math.max(pile, max);
        }
        if(h == piles.length) {
            return max;
        }
        // i will try to implement the brute force solution at first.. this is the brute
        for(int k = 1; k <= max; k++) {
            if(isPossible(piles, h, k)) return k;
        }
        return max;
    }

    private boolean isPossible(int[] piles, int h, int k) {
        int remaininghours = h;
        for(int i = 0; i < piles.length; i++) {
            int currentPile = piles[i];
            while(currentPile > 0) {
                currentPile -= k;
                remaininghours--;
                if(remaininghours == 0) break;
            }
            if(remaininghours == 0) {
                if(currentPile > 0 || i != (piles.length - 1) ) {
                    break;
                }
                if(i == (piles.length - 1) && currentPile <= 0) {
                    return true;
                }
            }
        }
        if(remaininghours > 0) return true; // smallest integer
        return false;
    }
    public int guessNumber(int n) { // use binary search
        return binarySearchRange(1, n);
    }

    public int binarySearchRange(int low, int high) {
        while(low <= high) {
            int mid = low + (high - low) / 2; // this is interesting... you need to do this for integer overflow
            if(isCorrect(mid) < 0) {
                high = mid - 1;
            } else if(isCorrect(mid) > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
