package leetcode.BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.common.TreeNode;

public class Solution {
	
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root == null)
			return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		while(node!=null || !stack.isEmpty()){
			if(node!=null){			
				stack.push(node);
				node = node.left;
			}else{
				node=stack.pop();
				res.add(node.val);
				node=node.right;
			}
		}
		return res;
    }
}
