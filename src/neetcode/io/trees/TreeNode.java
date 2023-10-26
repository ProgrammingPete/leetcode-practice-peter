package neetcode.io.trees;

public class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode() {}
	 TreeNode(int val) { this.val = val; }
	 TreeNode(int val, TreeNode left, TreeNode right) {
	     this.val = val;
	     this.left = left;
	     this.right = right;
	 }
	@Override
	public String toString() {
		StringBuilder builder = inorder(new StringBuilder(), this);
		return builder.toString();
	}
	private StringBuilder inorder(StringBuilder builder, TreeNode root) {
		if(root == null) return builder;
		inorder(builder, root.left);
		builder.append(root.val + ",");
		inorder(builder, root.right);
		return builder;
	}
	
}
