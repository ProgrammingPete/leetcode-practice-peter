package neetcode.io.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	public static void main(String[] args){
		Solution sol = new Solution();
		
		
		/**
		 * 
		 *      4
		 *    2   7 
 		 *   1 3 6 9
		 */
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);

		/**
		 * 
		 *      2
		 *    1   3
		 */
		TreeNode easyRoot = new TreeNode(1);
		easyRoot.left = new TreeNode(2);
		easyRoot.right = new TreeNode(3);
		easyRoot.right.left = new TreeNode(3);
		
		
		TreeNode diameterRoot = new TreeNode(1);
		diameterRoot.left = new TreeNode(2);
		diameterRoot.right = new TreeNode(3);
		diameterRoot.left.left = new TreeNode(4);
		diameterRoot.left.right = new TreeNode(5);
		
		
		TreeNode balancedRoot = new TreeNode(3);
		balancedRoot.left = new TreeNode(9);
		balancedRoot.right = new TreeNode(20);
		balancedRoot.right.left = new TreeNode(15);
		balancedRoot.right.right = new TreeNode(7);
		
		// TreeNode invertedRoot = sol.invertTree(easyRoot);
		TreeNode balancedRootfalse = new TreeNode(1);
		balancedRootfalse.left = new TreeNode(2);
		balancedRootfalse.right = new TreeNode(2);
		balancedRootfalse.left.left = new TreeNode(20);
		balancedRootfalse.left.right = new TreeNode(20);
		balancedRootfalse.left.left.right = new TreeNode(4);
		balancedRootfalse.left.left.left = new TreeNode(4);
		// System.out.println("Diameter: " + sol.diameterOfBinaryTree(balancedRoot));
		// System.out.println(sol.isBalanced(balancedRootfalse));
		
		// sol.preLevelOrderTraversal(root);
		
		sol.printTreeBfs(easyRoot);
		sol.bfsWithLevel(easyRoot);
		
	}
	
	public void printTreeBfs(TreeNode root){
		Deque<TreeNode> deque = new LinkedList<>();
		deque.offer(root);
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		while(!deque.isEmpty()){
			
			//bfs traversal
			TreeNode curr = deque.poll();
			builder.append(curr);
			if(curr.left != null)
				deque.offer(curr.left);
			if(curr.right != null)
				deque.offer(curr.right);
				
			if(!deque.isEmpty())
				builder.append(",");
		}
		builder.append("]");
		System.out.println(builder.toString());
	}

	public void bfsWithLevel(TreeNode root) { // from neetcode
		Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        if (root != null) {
            queue.offer(root);
        }    
        int level = 0;
        while(!queue.isEmpty()) {
            System.out.print("level " + level + ": ");
            int levelLength = queue.size();
            for (int i = 0; i < levelLength; i++) {
                TreeNode curr = queue.poll(); 
                System.out.print(curr.val + " ");
                if(curr.left != null) {
                    queue.offer(curr.left);  
                }
                if(curr.right != null) {
                    queue.offer(curr.right);
                }  
            }
            level++;
            System.out.println();
        }
	}
	
	/**
	 * 
	 * Invert Binary Tree - https://leetcode.com/problems/invert-binary-tree/
	 * Given the root of a binary tree, invert the tree, and return its root.
	 * 
	 * @param root
	 * @return
	 */
    public TreeNode invertTree(TreeNode root) {
		// this was done on the linux machine
        return root;
    }
	
	
	/**
	 * 
	 * Find Maximum Depth of a Tree
	 * Given the root of a binary tree, return its maximum depth.
	 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
	 * 
	 * 
	 * @param root
	 * @return
	 */
	public int maxDepth(TreeNode root) {
        //recursive defintion
		if(root ==null)
			return 0;
		
		// add one for the current node we are on, then take the max depth of either the left or right subtree (whichever is larger)
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

	/**
	 * 
	 * Diameter of Binary Tree - https://leetcode.com/problems/diameter-of-binary-tree/
	 * Given the root of the binary tree, return the length of the 
	 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
	 * The length of a path between two nodes is represented by the number of edges between them.
	 * 
	 * 
	 * @param root
	 * @return diameter of the tree
	 */
    public int diameterOfBinaryTree(TreeNode root) {
		int[] heightAndDiameter = new int[2];
		this.dfsDiameter(root,heightAndDiameter);
		return heightAndDiameter[1];
    }
	public int[] dfsDiameter(TreeNode root, int[] heightAndDiameter){
		if(root == null)
			return new int[]{0, 0}; //this counts the null node height to be -1. Because technically the node does not exist. Also diamter is 0
		
		int leftSubTreeHeight = dfsDiameter(root.left, heightAndDiameter)[0]; 
		int rightSubTreeHeight = dfsDiameter(root.right, heightAndDiameter)[0]; 
		heightAndDiameter[1] =  Math.max(heightAndDiameter[1], leftSubTreeHeight + rightSubTreeHeight); //max diameter
		heightAndDiameter[0] = 1 + Math.max(leftSubTreeHeight, rightSubTreeHeight); // height
		return heightAndDiameter;
		
	}
	
	public int height(TreeNode root){
		if(root == null)
			return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}
	/**
	 * 
	 * Balanced Binary Tree https://leetcode.com/problems/balanced-binary-tree/
	 * Given a binary tree, determine if it is height-balanced. 
	 * 
	 * We can use the bottom-up approached and start from a leaf and work our way up. Use DFS
	 * 
	 * 
	 * @param root
	 * @return
	 */
	public boolean isBalanced(TreeNode root){
		if(root == null)
			return true;
		
		return heightAndIsbalanced(root)[1] == 1;
	}
	public int[] heightAndIsbalanced(TreeNode root){
		if(root == null)
			return new int[]{0,1};
		int[] left = heightAndIsbalanced(root.left);
		int[] right = heightAndIsbalanced(root.right);
		boolean subIsBalanced =  Math.abs(left[0] - right[0]) <= 1 
								&& left[1] == 1 && right[1] == 1;
		return new int[] {1 + Math.max(left[0], right[0]), subIsBalanced ? 1 : 0 };
	}
	/*
	 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
	 * 
	 * 
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		if(root == null) return ans; 
		Deque<TreeNode> deque = new LinkedList<>();
		deque.offer(root);
		boolean switchorder = false; 
		while(!deque.isEmpty()){
			List<Integer> lst = new ArrayList<>();
			int size = deque.size();
			for(int i = 0; i < size; i++){
				TreeNode curr = deque.poll();
				lst.add(curr.val);
				if(curr.left != null)
					deque.add(curr.left);
				if(curr.right != null)
					deque.add(curr.right);
			}
			if(switchorder)
				Collections.reverse(lst);
			ans.add(lst);
			switchorder = !switchorder;
		}
		return ans;
	}
	
	public void preLevelOrderTraversal(TreeNode root){
		if(root == null) return;
		System.out.println(root.val);
		System.out.println(root.left + " " + root.right);
		preLevelOrderTraversal(root.left);
		preLevelOrderTraversal(root.right);
	}
	public void inorder(TreeNode root) {
		if(root == null) return;
		inorder(root.left);
		System.out.println(root.val);
		inorder(root.right);
	}
	public void preorder(TreeNode root) {
		if(root == null) return;
		System.out.println(root.val);
		preorder(root.left);
		preorder(root.right);
	}

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length < 1 || inorder == null || inorder.length < 1) {
            return null; 
        }
        TreeNode root = new TreeNode(preorder[0]); // create root with the left most value in the preorder list
		
		// find the index to partition on
		int partitionIndex = -1;
		for(int i = 0; i < inorder.length; i++) {
			if(inorder[i] == root.val) {
				partitionIndex = i;
				break;
			}
		}
		int[] preOrderLeftSubtree = Arrays.copyOfRange(preorder, 1, partitionIndex + 1);
		int[] inOrderLeftSubtree = Arrays.copyOfRange(inorder, 0, partitionIndex);
		int[] preOrderRightSubtree = Arrays.copyOfRange(preorder, partitionIndex + 1, preorder.length);
		int[] inOrderRightSubtree = Arrays.copyOfRange(inorder, partitionIndex + 1, inorder.length);
		// System.out.println("preOrderLeftSubtree: " + Arrays.toString(preOrderLeftSubtree));
		// System.out.println("inOrderLeftSubtree: " + Arrays.toString(inOrderLeftSubtree));
		// System.out.println("preOrderRightSubtree: " + Arrays.toString(preOrderRightSubtree));
		// System.out.println("inOrderRightSubtree: " + Arrays.toString(inOrderRightSubtree));
		root.left = buildTree(preOrderLeftSubtree, inOrderLeftSubtree);
		root.right = buildTree(preOrderRightSubtree, inOrderRightSubtree);

		return root;
    }

    public void postorder(TreeNode root) {
		if(root == null) return;
		
		postorder(root.left);
		postorder(root.right);
		System.out.println(root.val);
    }
}
