package excel;

public class Solution {
    public int titleToNumber(String s) {
       int sum = 0;  
        int tmp = 0;
        char[] sChar = s.toCharArray();
        for (int i = 0; i < sChar.length; i++) {  
            tmp = sChar[i] - 'A' + 1;  
            sum = 26 * sum + tmp;  
        }  
        return sum;  
    }
}