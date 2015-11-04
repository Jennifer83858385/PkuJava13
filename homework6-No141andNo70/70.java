package climbingStairs;

public class Solution {
	public int climbStairs(int n) {
        if(n == 1){
        	return 1;
        }
        int pre = 1, cur = 1, tmp=1;
        for(int i =2; i <= n; i++){
        	tmp = pre + cur;
        	pre = cur;
        	cur = tmp;
        }
        return cur;
    }
}