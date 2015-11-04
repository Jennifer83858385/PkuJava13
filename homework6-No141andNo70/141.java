package linkedListCycle;

  
 
public class Solution {
	class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	     }
	 }
    public boolean hasCycle(ListNode head) {
    	if(head == null){
    		return false;
    	}
    	ListNode fast = head, slow = head;
    	for(;;){
    		fast = fast.next;
    		slow = slow.next;
    		if(fast != null){
    			fast = fast.next;
    		}
    		if(fast == null){
    			return false;
    		}
    		if(fast == slow){
    			return true;
    		}
    	}
    	
        
    }
}