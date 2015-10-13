/*Author:李建锋
*Time：10.7
*Question：判断单向链表是否回文
*Tips:头插法逆序单向链表
*/
/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
*/
public class Solution {
    public boolean isPalindrome(ListNode head) {
		ListNode top = head;
		ListNode temp;
		ListNode step = head;
		while (true) {
			//处理空
			if(step==null){
			    return true;
			}
			// 有奇数个元素
			else if (step.next == null) {
				while (head.next != null) {
					if (head.next.val != top.next.val)return false;
					else {
						top=top.next;
						head=head.next;
					}
				}
				return true;
			}
			// 有偶数个元素
			else if (step.next.next == null) {
			    while (head.next != null) {
					if (head.next.val != top.val)return false;
					else {
						top=top.next;
						head=head.next;
					}
				}
				return true;

			} else {
				step = step.next.next;
			//头插法
				temp = head.next;
				head.next = head.next.next;
				temp.next = top;
				top = temp;
				}
		}
	}
}