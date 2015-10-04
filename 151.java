/*Author:李建锋
*Time：10.1
*Questioin:按照单词翻转句子
*Tips:按照正则匹配单词
*/
public class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        s="";
        for(int i=words.length-1;i>=0;i--){
         s=s+words[i];
         if(i>0)s+=" ";
        }
        return s;
    }
}