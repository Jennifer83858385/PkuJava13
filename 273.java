/*Author:李建锋
*Time：10.7
*Question：数字转单词
*Tips:细节处理好
*/public class Solution {
	public static String numberToWords(int num) {
	    if(num==0)return "Zero";
        ArrayList<Integer> handreds = toHandreds(num);
        StringBuffer resu =new StringBuffer();
        for(int i=handreds.size()-1;i>=0;i--){
        	String postfix0 = "",sec="";
            switch (i){
                case 0:break;
                case 1:
                    postfix0="Thousand";
                    break;
                case 2:
                    postfix0 = "Million";
                     break;
                case 3:
                    postfix0 = "Billion";
                    break;
                default:break;
            }
           int euqalsZero=0;
           int temp = (Integer)handreds.get(i);
           if(temp==0)euqalsZero=1;
           if(temp>=100){
        	  resu.append(" ").append(readNumberLessThan20(temp/100)).append(" Hundred");
        	  }
           temp=temp%100;
           if(temp!=0)resu .append(" ").append(readNumberLessThan100(temp));
           if((!postfix0.equals(""))&&(euqalsZero==0))resu.append(" ").append(postfix0);
           
        }
        return resu.delete(0, 1).toString();
    }
    
    public static String readNumberLessThan20(int num){
        String postfix1="";
            if(num<10)switch(num){
                case 1:postfix1 = "One";break;
                case 2:postfix1 = "Two";break;
                case 3:postfix1 = "Three";break;
                case 4:postfix1 = "Four";break;
                case 5:postfix1 = "Five";break;
                case 6:postfix1 = "Six";break;
                case 7:postfix1 = "Seven";break;
                case 8:postfix1 = "Eight";break;
                case 9:postfix1 = "Nine";break;
                default:break;
            }
            else if(num<20)switch(num){
                case 10:postfix1 = "Ten";break;
                case 11:postfix1 = "Eleven";break;
                case 12:postfix1 = "Twelve";break;
                case 13:postfix1 = "Thirteen";break;
                case 14:postfix1 = "Fourteen";break;
                case 15:postfix1 = "Fifteen";break;
                case 16:postfix1 = "Sixteen";break;
                case 17:postfix1 = "Seventeen";break;
                case 18:postfix1 = "Eighteen";break;
                case 19:postfix1 = "Nineteen";break;
                default:break;
                }
            return postfix1;
    }
    public static String readNumberLessThan100(int num){
        if (num<20)return readNumberLessThan20(num);
    	String postfix1=null;
        switch(num/10){
            case 2:postfix1 = "Twenty";break;
            case 3:postfix1 = "Thirty";break;
            case 4:postfix1 = "Forty";break;
            case 5:postfix1 = "Fifty";break;
            case 6:postfix1 = "Sixty";break;
            case 7:postfix1 = "Seventy";break;
            case 8:postfix1 = "Eighty";break;
            case 9:postfix1 = "Ninety";break;
            default:break;
        }
        int temp = num%10;
        if (temp==0)return postfix1;
        else return postfix1+" "+readNumberLessThan20(temp) ;
}
    public static ArrayList<Integer> toHandreds(int num){
        ArrayList<Integer> han= new ArrayList<Integer>() ;
         while(num>0){
            han.add(num%1000);
            num=num/1000;
        }
         System.out.println(han);     	
        return han;
    }
    
}