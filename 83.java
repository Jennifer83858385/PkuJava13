public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
 
        ListNode prev = head;    
        ListNode p = head.next;
 
        while(p != null){
            if(p.val == prev.val){
                prev.next = p.next;
                p = p.next;
                //no change prev
            }else{
                prev = p;
                p = p.next; 
            }
        }
 
        return head;
    }

//以下是我的误区，我以为数字的大小不是顺序排列的
public ListNode deleteDuplicates(ListNode head) {
		 ListNode p=head;
		 ListNode q=head;
		 int n=1;
		 if(p==null||p.next==null){
			 return p;
		 }
		 else{
		 while(p.next!=null){
			 n++;	 
			 p=p.next;
		 }
		 //以上求出了链表的长度，用来建立数组
		 int a[]=new int [n];
		 p=head;
		 a[0]=p.val;
		 int m=0;
		 //p会在倒数第二个弹出
		 while((p.next!=null)&&(p.next.next!=null)){
			 for(int i=0;i<=m;i++){
				 if (p.next.val==a[i]) {
					p.next=p.next.next; 
				}
				 else {
					 m++;
					a[m]=p.next.val;
					
				}
			 }
			 q=p;//标记倒数第二个元素
			 p=p.next;
		 }
		 
		 //记得对最后一个进行处理

	for(int i=0;i<=m;i++){
		 if (p.val==a[i]) {
			 //删除倒数第二
			q.next=p.next; 
			p=p.next;
		}
		 else {
			 m++;
			 a[m]=p.val;
			 q=p;
			 p=p.next;
		}
	 }
	
	for(int i=0;i<=m;i++){
		 if (p.val==a[i]) {
			 //删除倒数第1
			q.next=null;
		}
		 else {
		
		}
	 }
	
	
		 }
	        return head;
	    }