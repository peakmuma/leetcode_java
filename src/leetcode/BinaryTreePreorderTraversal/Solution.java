package leetcode.BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;

import leetcode.common.TreeNode;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<Integer> res;
	public List<Integer> preorderTraversal(TreeNode root) {
		 res = new ArrayList<Integer>();	
		 preorder(root);
         return res;
    }
	
	public void preorder(TreeNode node){
		if(node==null)
			return;
		res.add(node.val);
		preorder(node.left);
		preorder(node.right);
	}
}
