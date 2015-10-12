/*Author:李建锋
*Time：10.12
*Question：找到单身狗
*Tips:两个一样的数字异或等于零
*/
public class Solution {
    public boolean isUgly(int num) {
        if(num==0)return false;
        while(num!=1){
            if(num%5==0){
                num/=5;
            }
            else if(num%3==0){
                num/=3;
            }
            else if(num%2==0){
                num/=2;
            }
            else return false;
        }
        return true;
    }
}