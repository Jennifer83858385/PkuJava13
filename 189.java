/*Author:李建锋
*Time：10.1
*Question:数组移位
*/
public class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k=len-k%len;
        spin(nums,0,k-1);
        spin(nums,k,len-1);
        spin(nums,0,len-1);
        
    }
    public void spin(int[] nums,int begin,int end){
        for(int i=begin,j=end;i<j;i++,j--){
            int temp=0;
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}