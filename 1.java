 public static  int[] twoSum(int[] nums, int target) {
        int [] res=new int [2];
        for (int i = 0; i < nums.length; i++) {
        	for (int j = i+1; j < nums.length; j++) {
                //提交了两次，第一次j=i而不是j=i+1，出错
				if (nums[j]==target-nums[i]) {
					res[0]=i+1;
					res[1]=j+1;
					break;
				}
			}
			
		}
        
        return res;
    }




    public static int[] twoSum(int[] numbers, int target) {
	        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
	        for (int i=0;i<numbers.length;i++) {
	            map.put(numbers[i], i);
	        }
	         
	        for (int i=0;i<numbers.length;i++) {
	            int dif = target-numbers[i];
	            Integer index = map.get(dif);
	             
	            if (index!=null && i!=index) {
	                if (index>i)
	                    return new int[]{i+1,index+1};
	                else
	                    return new int[]{index+1,i+1};
	            }
	        }
	         
	        return null;
	    }