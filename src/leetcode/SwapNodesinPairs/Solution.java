package leetcode.SwapNodesinPairs;

import leetcode.common.ListNode;

public class Solution {
	public ListNode swapPairs(ListNode head) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode pre = preHead;
        ListNode l1 = head;
        ListNode l2;
        while(l1!=null && l1.next!=null){
        	l2=l1.next;
        	pre.next=l2;
        	l1.next=l2.next;
        	l2.next=l1;
        	pre=l1;
        	l1=l1.next;
        } 
        return preHead.next;
    }
}
