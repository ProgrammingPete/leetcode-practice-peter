package neetcode.io.trees;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * 
 * 105. Construct Binary Tree from Preorder and Inorder Traversal https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
        Medium
        Topics
        Companies
        Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

        

        Example 1:


        Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        Output: [3,9,20,null,null,15,7]
        Example 2:

        Input: preorder = [-1], inorder = [-1]
        Output: [-1]
        

        Constraints:

        1 <= preorder.length <= 3000
        inorder.length == preorder.length
        -3000 <= preorder[i], inorder[i] <= 3000
        preorder and inorder consist of unique values.
        Each value of inorder also appears in preorder.
        preorder is guaranteed to be the preorder traversal of the tree.
        inorder is guaranteed to be the inorder traversal of the tree.

        hints: 2 facts;
        1. preoder, wew alwyas process the root first. 1st value is alwys gonna be the root, so we can take the sublist and do this recursively
            1a. After taking the value, which values  GO IN THE LEFT AND RIGHT SUBTREE (2nd index is always the value of the left subtree)
        2. Every val is going ot be unique , so in the indorder array we can find the number we are checking. 
            EVERY VALUE TO THE LEFT OF THIS VALUE IS GOING TO GO IN THE LEFT SUBTREE, EVERY VAL TO THE RIGHT WILL GO INTO THE RIGHT SUBTREE
            
            Steps to implement:
            1. start with the 0th index value in the pre-order traversal
            2. create node and call it root
            3. find the root val (it is unique) in the inorder traversal.
            4. set the left of the root equal to thhe recrusion of this function where pre order 1 to the 

        
 * 
 */
public class ConstructBinaryTreeTest {

    Solution sol = new Solution();
    TreeNode rootExample1Expected = new TreeNode(3);
    TreeNode rootExample2Expected = new TreeNode(-1);
    @BeforeAll
    
    static void setup(){
        TreeNode rootExample1Expected = new TreeNode(3);
		rootExample1Expected.left = new TreeNode(9);
		rootExample1Expected.right = new TreeNode(20);
		rootExample1Expected.right.left = new TreeNode(15);
		rootExample1Expected.right.right = new TreeNode(7);

    }

    @Test
    void testBuildTreeExample1() {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder =  new int[]{9,3,15,20,7};
        System.out.println(sol.buildTree(preorder, inorder));
        //9,3,15,20,7,
    }

    @Test
    void testBuildTreeExample2() {
        int[] preorder = new int[]{-1};
        int[] inorder =  new int[]{-1};
        System.out.println(sol.buildTree(preorder, inorder));
    }

    @Test
    void testindorder(){
        TreeNode root = new TreeNode(5);
		root.left = new TreeNode(7);
		root.left.left = new TreeNode(10);
		root.left.right = new TreeNode(11);
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(20);

        System.out.println("Inorder");
        sol.inorder(root);
        System.out.println("Preorder");
        sol.preorder(root);
        System.out.println("postrder");
        sol.postorder(root);
    }
}
