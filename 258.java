/*Author:李建锋
*Time：10.11
*Question：每位数字加和
*Tips:对9取余
*/
public class Solution {
    public int addDigits(int num) {
       int temp=num%9;
       if(num==0)return 0;
       else if(temp==0)return 9;
       else return temp;
    }
}