/*
股票买卖
*/
public class Solution {
    public int maxProfit(int[] prices) {
        int lowPrice=Integer.MAX_VALUE;
        //caonima
        int mostPro=0;
        //new line
        for(int i:prices){
            if(i<lowPrice)lowPrice=i;
            else if(i-lowPrice>mostPro)mostPro=i-lowPrice;
        }
        return mostPro;
    }
}
