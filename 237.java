/*Author:李建锋
*Time：10.11
*Question：删除链表特定节点
*Tips:设置pre指针
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void deleteNode(ListNode node) {
        ListNode temp=node;
        ListNode pre = null;
        while(temp.next!=null){
            temp.val=temp.next.val;
            pre=temp;
            temp=temp.next;
            }pre.next=null;
            
            
    }
}