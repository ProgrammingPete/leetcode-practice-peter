package neetcode.io.binarysearch;

public class GuessGame {
    private int pick;

    public GuessGame(int pick) {
        this.pick = pick;
    }
    public int isCorrect(int n) { //auxillary function
        if(n > pick) {
            return -1;
        } else if(n < pick) {
            return 1;
        } else {
            return 0;
        }
    }
}
