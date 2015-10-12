package validPalindrome;

public class Solution {
	public static boolean isPalindrome(String s) {
		boolean result = true;
		s = checkKeyWord(s);
		//System.out.println(s);
		char[] strChar = s.trim().toCharArray();
		int j = strChar.length - 1;
		//System.out.println(j);
		for(int i = 0; i < j; i++, j--){
			System.out.println("in");
			if(!(normLetter(strChar[i])+"").equals((normLetter(strChar[j])+""))){
				return false;
			}
		}
		return result;
    }
	public static char normLetter(char n){
		if(n>='A' && n<='Z'){
			n = (char)(n - 'A' + 'a');
		}
		return n;
	}
	//check the KeyWord if we expect
	//if not:delete illegal character
	public static String checkKeyWord(String KeyWord){
		KeyWord = KeyWord.replaceAll("[^0-9a-zA-Z]","");
		return KeyWord;
	}
	public static void main(String args[]){
		System.out.println(isPalindrome("1a2"));
		System.out.println(isPalindrome("121aba"));
	}
}
