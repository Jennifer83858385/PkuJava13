/*
AB=27
*/
public class Solution {
    public int titleToNumber(String s) {
        int total=0;
        for(int i=0;i<s.length();i++){
            char temp = s.charAt(i);
            total=26*total+((temp-'A')+1);
        }
        return total;
    }
}