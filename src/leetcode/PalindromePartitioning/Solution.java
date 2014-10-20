package leetcode.PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		new Solution().partition("aab");
	}
	
	public List<List<String>> partition(String s) {
		if(s==null || s.length()==0)
			return null;
		List<List<String>> res = new ArrayList<List<String>>();
		ArrayList<String> path = new ArrayList<String>();
		partitionString(s, 0, path, res);
		return res;
    }
	
	public void partitionString(String s,int index,ArrayList<String> path,List<List<String>> res) {
		if(index == s.length()){
			res.add(new ArrayList<String>(path));
			return;
		}
		for(int i=index+1;i<=s.length();i++){
			String subStr = s.substring(index,i);
			if(isPalindrome(subStr)){
				path.add(subStr);
				partitionString(s, i, path, res);
				path.remove(path.size()-1);
			}
		}
		return;
    }
	
	public boolean isPalindrome(String s){
		for(int i=0,j=s.length()-1;i<j;i++,j--)
			if(s.charAt(i)!=s.charAt(j))
				return false;
		return true;
	}
}
