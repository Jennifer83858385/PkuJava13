package uglynum;

public class Solution {
	
	public boolean isUgly(int num) {
		if(0 == num){
			return false;
		}
		if(1 == num){
			return true;
		}		
		while(true){
			if(num%2 == 0){
				num = num/2;
			}
			else if(num%3 == 0){
				num = num/3;
			}
			else if(num%5 == 0){
				num = num/5;
			}
			else{
				return false;
			}			
			if(num == 1){
				return true;
			}			
		}				        
    }
}
