public class Solution {
    public int romanToInt(String s) {
        if(s.length()==0||s.equals(null))return 0;
		int num=0;
		HashMap<Character,Integer>map=new HashMap<>();
		map.put('M',1000);
		map.put('D', 500);
		map.put('C', 100);
		map.put('L', 50);
		map.put('X',10);
		map.put('V',5);
		map.put('I',1);
		//MMCCMXXII
		int pre1 = Integer.MAX_VALUE,pre2=Integer.MAX_VALUE;
		int temp=0;
		for(int i=0;i<s.length();i++){
			temp=map.get(s.charAt(i));
			num+=temp;
			if(temp>pre1)num=num-2*pre1;
			if(temp>pre2)num=num-2*pre2;
			
			pre2=pre1;
			pre1=temp;
		}
		return num;
	
    }
    
}