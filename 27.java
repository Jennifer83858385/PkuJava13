	    public int removeElement(int[] nums, int val) {
	        int a=nums.length;
	        for (int i = 0,position=0; i < nums.length; i++) {
				if (nums[i]==val) {
					//每次检测到都前挪？千诺会超时，那就往前覆盖吧         
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