/*
数组去重
*/
public class Solution {
    public int removeDuplicates(int[] nums) {
	        int leng = nums.length;
	        for(int i=0;i<leng-1;){
	            if(nums[i]==nums[i+1])
	            {
	            	 circle(nums,i+1);
	                leng--;
	            }
	            else  i++;
	        }
	        return leng;
	    }
    public void circle(int[] nums,int from){
        int temp=nums[from];
        for(int i=from;i<nums.length-1;i++){
           nums[i]=nums[i+1];
        }
        nums[nums.length-1]=temp;
    }
}