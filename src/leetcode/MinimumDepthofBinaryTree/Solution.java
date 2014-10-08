package leetcode.MinimumDepthofBinaryTree;

import leetcode.common.TreeNode;

public class Solution {

	public int minDepth(TreeNode root) {
        if(root==null)
        	return 0;
        return intNodeDepth(root);
    }
	
	public int intNodeDepth(TreeNode node){
		if(node.left == null && node.right == null)
			return 1;
		int leftDepth = Integer.MAX_VALUE;
		int rightDepth = Integer.MAX_VALUE;
		if(node.left != null)
			leftDepth = intNodeDepth(node.left);
		if(node.right != null)
			rightDepth = intNodeDepth(node.right);
		return Math.min(leftDepth, rightDepth)+1;
	}
}
