package leetcode.LRU;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	
	public int capacity;
	private int size=0;
	private Map<Integer,Node> map;
	private Node head;
	private Node lastNode;
	
	public LRUCache(int capacity) {
        this.capacity=capacity;
        map = new HashMap<Integer,Node>(capacity);
        head = new Node(0,0,null,null);
        lastNode = head;
    }
	
	public int get(int key) {
		Node node=map.get(key);
		if(node!=null){
			moveNodeToLast(node);
			return node.value;
		}
		return -1;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
        	Node node = map.get(key);
        	node.value=value;
        	moveNodeToLast(node);
        }else{
        	if(size<capacity){
        		size++;
        	}else{
        		Integer lrukey = removeFirstNode();
        		if(lrukey!=null)
        			map.remove(lrukey);
        	}
        	Node node = new Node(key,value,null,null);
        	addLast(node);
        	map.put(key, node);
        }
    }
    
    public void  moveNodeToLast(Node node){
    	if(node!=lastNode){
	    	node.next.pre=node.pre;
			node.pre.next=node.next;
			lastNode.next=node;
			node.pre=lastNode;
			node.next=null;
			lastNode = node;
    	}
    }
    
    public Integer removeFirstNode(){
    	if(head.next!=null){
    		Node node = head.next;
    		if(node!=lastNode){
    			head.next=node.next;
    			node.next.pre=head;
    		}else{
    			head.next=null;
    			lastNode=head;
    		}
    		return node.key;
    	}
    	return null;
    }
    
    public void addLast(Node node){
    	node.pre=lastNode;
    	lastNode.next=node;
    	node.next=null;
    	lastNode = node;
    }
    
    class Node{
    	Integer key;
    	Integer value;
    	Node pre;
    	Node next;
    	
    	Node(){
    	}
    	
    	Node(Integer key,Integer value,Node pre,Node next){
    		this.key=key;
    		this.value = value;
    		this.pre=pre;
    		this.next =next;
    	}
    }
    
}

