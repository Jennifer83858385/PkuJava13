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

//�������ҵ�����������Ϊ���ֵĴ�С����˳�����е�
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
		 //�������������ĳ��ȣ�������������
		 int a[]=new int [n];
		 p=head;
		 a[0]=p.val;
		 int m=0;
		 //p���ڵ����ڶ�������
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
			 q=p;//��ǵ����ڶ���Ԫ��
			 p=p.next;
		 }
		 
		 //�ǵö����һ�����д���

	for(int i=0;i<=m;i++){
		 if (p.val==a[i]) {
			 //ɾ�������ڶ�
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
			 //ɾ��������1
			q.next=null;
		}
		 else {
		
		}
	 }
	
	
		 }
	        return head;
	    }