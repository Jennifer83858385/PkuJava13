/*Author:李建锋
*Time：10.1
*Question：颜色分类
*Tips:一次快排
*/
public class Solution {
    public void sortColors(int[] nums) {
        int mark0=0,i=0;
        for(int j=nums.length-1;i<j;){
            if(nums[i]==0)i++;
            else mark0=1;
            if(nums[j]>0)j--;
            else if(mark0==1){
                mark0=0;
                int temp = 0;
                temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
               i++;j--;
            }
          }
          mark0=0;
         for(int j=nums.length-1;i<j;){
            if(nums[i]>1)mark0=1;
            else  i++;
            if(nums[j]>1)j--;
            else if(mark0==1){
                mark0=0;
                int temp = 0;
                temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;j--;
            }
          }
    }
}