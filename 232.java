public class MyQueue {
	 Stack <Integer> st1 = new Stack <Integer>();
	 Stack <Integer> st2 = new Stack <Integer>();
	    public void push(int x) {
	    	if (st1.isEmpty()) {
	    	while(st2.size()!=0){
	    		int temp=st2.pop();
	    		st1.push(temp);
	    	}
	    	}
	    	//�������ʽ����Ǵ���ش������뱣֤һ��Ϊ�յ�ʱ�򣬲���ֱ�Ӹ��ƹ�ȥ
	    	/**if (st1.isEmpty()) {
	    		Stack <Integer> st3 = new Stack <Integer>();
	    		st3=st2;
	    		st2=st1;
	    		st1=st3;
			}
			*/
	    	st1.push(x);
	    	while(st1.size()!=0){
	    		int temp=st1.pop();
	    		st2.push(temp);
	    	}
	    }

	    // Removes the element from in front of queue.
	    //����S1ʼ�ղ���
	    public void pop() {
	    	if (st1.isEmpty()) {
	    	while(st2.size()!=0){
	    		int temp=st2.pop();
	    		st1.push(temp);
	    	}
	    	}
	    	while(st1.size()!=0){
	    		int temp=st1.pop();
	    		st2.push(temp);
	    	}
	    	st2.pop();
	    	
	    }

	    // Get the front element.
	    public int peek() {
	    	if (st1.isEmpty()) {
	    	while(st2.size()!=0){
	    		int temp=st2.pop();
	    		st1.push(temp);
	    	}
	    	}
	    	while(st1.size()!=0){
	    		int temp=st1.pop();
	    		st2.push(temp);
	    	}
	    	int m=st2.pop();
	    	st2.push(m);
	    	return m;
	    }

	    // Return whether the queue is empty.
	    public boolean empty() {
	    	if (st1.isEmpty()&&st2.isEmpty()) {
				return true;
			}
	    	else {
	    		return false;
			}
	        
	    }


}
