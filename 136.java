/*Author:李建锋
*Time：10.12
*Question：找到单身狗
*Tips:两个一样的数字异或等于零
*/
public class Solution {
    public int singleNumber(int[] nums) {
        for(int i=1;i<nums.length;i++){
            nums[0]^=nums[i];
        }
        return nums[0];
    }
}