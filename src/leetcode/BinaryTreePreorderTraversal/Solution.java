package leetcode.BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
	
	//非递归解法,基本思路：用栈来保存节点
	public List<Integer> preorderIterativeTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root==null)
			return res;
		 Stack<TreeNode> stack = new Stack<TreeNode>();
		 stack.push(root);
		 while(!stack.isEmpty()){
			 TreeNode node = stack.pop();
			 res.add(node.val);
			 if(node.right!=null)
				 stack.push(node.right);
			 if(node.left!=null)
				 stack.push(node.left);
		 }
		 return res;
   }
}
