/**
*
*/
public class Solution {
	public  String biaoShi(int num,String ten,String five,String one){
		String resu="";
		if(num<4){
			for(int i=0;i<num;i++){
				resu+=one;
			}
		}else if(num<6){
			for(int i=0;i<5-num;i++){
				resu+=one;
			}
			resu+=five;
		}else if(num<9){
			resu+=five;
			for(int i=0;i<num-5;i++){
				resu+=one;
			}
		}else {
			for(int i=0;i<10-num;i++){
				resu+=one;
			}
			resu+=ten;
		}
		return resu;
	}


    public String intToRoman(int test) {
       String resu="";
        int temp=0;
    	temp=test/1000;
    	test=test%1000;
    	resu+=biaoShi(temp,"","","M");
    	temp=test/100;
    	test=test%100;
    	resu+=biaoShi(temp,"M","D","C");
    	temp=test/10;
    	test=test%10;
    	resu+=biaoShi(temp,"C","L","X");
    	resu+=biaoShi(test,"X","V","I");
    	return resu;
    }
}