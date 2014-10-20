package leetcode.wordbreak;

import java.util.Set;

public class Solution {

	public static void main(String[] args) {

	}
	 public boolean wordBreak(String s, Set<String> dict) {
	        if(s==null || s.length()==0)
	        	return true;
	        boolean[] dp = new boolean[s.length()];
	        for(int i=s.length()-1;i>=0;i--){
	        	if(dict.contains(s.substring(i))){
	        		dp[i]=true;
	        		continue;
	        	}else {
	        		for(int j=i+1;j<s.length();j++){
	        			if(dp[j]&&dict.contains(s.substring(i,j)))
	        				dp[i]=true;
	        		}
	        	}
	        }
	        return dp[0];
	 }
}
