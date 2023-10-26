package neetcode.io.core;

import java.util.List;
import java.util.TreeMap;
class TreeNode {
    int val;
    int key;
    TreeNode left;
    TreeNode right;
    public TreeNode(int key, int val) {
        this.val = val;
    }
    public TreeNode(int key, int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left; 
        this.right = right;
    }
    public TreeNode() {
    }
}

class TreeMapImpl {
    TreeNode root = null;
    public TreeMapImpl() {
        // empty constructor
    }

    public void insert(int key, int val) {

    }

    public int get(int key) {
        return 0;
    }

    public int getMin() {
        return 0;

    }

    public int getMax() {
        return 0;

    }

    public void remove(int key) {
       
    }

    public List<Integer> getInorderKeys() {
        return null;
    }
}