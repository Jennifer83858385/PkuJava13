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
	    	//我这个方式真的是大错特错！！！想保证一个为空的时候，不能直接复制过去
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
	    //我令S1始终不空
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
