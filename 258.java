public class Solution {
    public int addDigits(int num) {
        num = 1 + (num-1) % 9;
		return num;
    }
}