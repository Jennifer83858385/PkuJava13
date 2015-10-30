/*Author:李建锋
*Time：10.30
*Question：找到主元素
*Tips:参考判断是否有主元素的思想
*/
public class Solution {
    public int majorityElement(int[] nums) {
        int majorEle=nums[0],majorTimes=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==majorEle)majorTimes++;
            else {
                if(majorTimes<=0)majorEle=nums[i];
                else majorTimes--;
            }
            
        }
        return majorEle;
    }
}