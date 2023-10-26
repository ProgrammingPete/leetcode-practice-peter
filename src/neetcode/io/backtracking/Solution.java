package neetcode.io.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(target == 1) return res;
        backtrackCombination(candidates, res, target, new ArrayList<>(), 0);
        return res;
    }

    /**
     * 
     * Backtracking formula: 
     * Backtrack:
     *  if Goal reached:   \
     *      Add solution to res
     * for(int i = 0; i < NB_CHOICES; i++) {
     *      if(choice is valid)
     *          make choices[i] // add to list
     *          backtrack(res, args)
     *          undo choices[i] // remove from list
     * }
     * 
     * @param candidates
     * @param res
     * @param target
     * @param currentSumList
     * @param index
     */
    private void backtrackCombination(int[] candidates, List<List<Integer>> res, int target,
            List<Integer> currentSumList, Integer index) {
            if(target == 0) {
                res.add(new ArrayList<>(currentSumList));
                return;
            }
            for(int i = index; i < candidates.length; i++) {
                if(target - candidates[i] >= 0) { 
                    currentSumList.add(candidates[i]);
                    backtrackCombination(candidates, res, target - candidates[i], currentSumList, i);
                    currentSumList.remove(currentSumList.size() - 1);
                }
            }
    }

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;
        boolean[][] visited = new boolean[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++) {
                if(board[i][j] == word.charAt(0)) {
                     System.out.println("visited: " + visited);
                    if(backtrackFound(word, board, visited, "", i, j)) return true;
                }
            }
        }
        return false;
    }
    private boolean backtrackFound(String word, char[][] board, boolean[][] visited, String currword, int i, int j) {
        if(currword.length() == word.length()) {
            return true;
        }
        if(
            i < 0 ||
            i >=  board.length ||
            j < 0 ||
            j >= board[i].length ||
            word.charAt(currword.length()) != board[i][j] ||
            visited[i][j]
        ) return false;
        System.out.println("currword: " + currword);
        visited[i][j] = true;
        if(
            backtrackFound(word, board, visited, currword+board[i][j], i+1, j) ||
            backtrackFound(word, board, visited, currword+board[i][j], i-1, j) ||
            backtrackFound(word, board, visited, currword+board[i][j], i, j+1) ||
            backtrackFound(word, board, visited, currword+board[i][j], i, j-1)
        ) return true;

        visited[i][j] = false;
        
        return false;
    }
    public List<String> letterCombinations(String digits) {
        Map<Character, String> keyboard = Map.of(
                    '2', "abc",
                    '3', "def",
                    '4', "ghi",
                    '5', "jkl",
                    '6', "mno",
                    '7', "pqrs",
                    '8', "tuv",
                    '9', "wxyz");
        List<String> res = new ArrayList<>();
        if(digits.length() == 0) return res;
        for(int i = 0; i < digits.length(); i++) {
            backtrack(digits, keyboard, res, "");
        }
        return res;
    }

    private void backtrack(String digits, Map<Character, String> keyboard, List<String> res, String currentCombo) {
        if(digits.length() == currentCombo.length()) {
            res.add(currentCombo);
            return ;
        }
        for(Character c : keyboard.get(digits.charAt(currentCombo.length())).toCharArray()) 
            currentCombo = currentCombo + c;
            backtrack(digits, keyboard, res, currentCombo);
        return;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length]; // need visited so that we dont add the same number multiple times
        backtrackPerm(nums, new LinkedList<>(), res, visited);
        return res;
    }

    private void backtrackPerm(int[] nums, LinkedList<Integer> currentPermutation, List<List<Integer>> res, boolean[] visited) {
        if(currentPermutation.size() == nums.length) {
            // this is an odd workaround.... need to make a copy
            List<Integer> perm = new ArrayList<>();
            for(Integer i : currentPermutation) {
                perm.add(i);
            }
            res.add(perm);
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                currentPermutation.add(nums[i]);
                backtrackPerm(nums, currentPermutation, res, visited);
                visited[i] = false;
                currentPermutation.removeLast();
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // if(Arrays.stream(candidates).sum() < target) return res;
        dfscombsum2(candidates,target,res,new ArrayList<>(),0);
        return res;
    }

    private void dfscombsum2(int[] candidates, int target, List<List<Integer>> res, ArrayList<Integer> currentSum, int start) {
        if(target == 0) {
            List<Integer> temp = new ArrayList<>(currentSum);
            Collections.sort(temp);
            if(!res.contains(temp))
                res.add(temp);
            return;
        }
        for(int i = start; i < candidates.length; i++) {
            // for all indexes that are greater than the start index, we skip if its the same as the previous candidate
            if(i > start && candidates[i] == candidates[i-1]) continue; 
            if(candidates[i] > target) continue; // skip the candidates that are also greater than target 
            currentSum.add(candidates[i]);
            dfscombsum2(candidates, target - candidates[i], res, currentSum, i + 1);
            currentSum.remove(currentSum.size() - 1);
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return false;
    }

}
