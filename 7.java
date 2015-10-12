package reverseInteger;

public class Solution {
	public static int reverse(int x) {
		String s = x + "";
		char[] str = s.trim().toCharArray();
		String sNew = "";
		int time = str.length;
		for(int i = time-1; i > 0; i--){
			sNew = sNew + str[i];
		}
		long y;
		if("-".equals(str[0]+"")){
			y = Long.parseLong(sNew);
			if(y > Integer.MAX_VALUE){
				return -1;
			}
			y = y * (-1);
			//x = Integer.parseInt(sNew);
			//x = x * (-1);
		}
		else{
			sNew = sNew + str[0];
			y = Long.parseLong(sNew);
			//x = Integer.parseInt(sNew);
		}
		if(y > Integer.MAX_VALUE){
			return -1;//leetcodeÒª·µ»Ø0
		}
        return (int)y;
    }
	 
	public static void main(String args[]){
		System.out.println(reverse(1234567899));
		System.out.println(reverse(12));
		System.out.println(reverse(-1234567899));
		System.out.println(reverse(-12));
	}
}
