	    public int removeElement(int[] nums, int val) {
	        int a=nums.length;
	        for (int i = 0,position=0; i < nums.length; i++) {
				if (nums[i]==val) {
					//ÿ�μ�⵽��ǰŲ��ǧŵ�ᳬʱ���Ǿ���ǰ���ǰ�         
					/*for (int j = i; j < nums.length-a; j++) {
						nums[j]=nums[j+1];}*/
					a--; 
				}
				else {
					nums[position++]=nums[i];
				}
			}
	        
	        return a;
	    	
	    	
	    }