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

        int low = 1;
        int high = max;
        int res = max;

        while(low <= high) {
            int mid = (low + high) >>> 1; // >>> 1  shifts bit to the right
            if(canCompletePiles(piles, h, mid)) {
                high = mid - 1;
                res = mid;
            } else {
                low = mid + 1;
            }
        }

        // // i will try to implement the brute force solution at first.. this is the brute
        // for(int k = 1; k <= max; k++) {
        //     if(canCompletePiles(piles, h, k)) return k;
        // }
        return res;
    }

    private boolean canCompletePiles(int[] piles, int h, int k) {
        if(k == 0) return false;
        int pileIndex = 0;
        while(h >= 0  && pileIndex < piles.length) {
            h -= Math.ceil((double)piles[pileIndex] / k);
            pileIndex++;
        }
        return h >= 0 && pileIndex >= piles.length;
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
