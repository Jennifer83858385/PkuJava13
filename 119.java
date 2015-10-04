/*Author:李建锋
*Time：10.2
*Question：杨辉三角
*Tips:利用排列组合公式即可
*/
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer>list = new ArrayList<Integer>();
        for(int i=0;i<=rowIndex;i++){
            list.add(combination(rowIndex,i));
            
        }
        return list;
    }
    public Integer combination(int n,int i){
        long sum=1,bot=1;
        for(int j=n;j>n-i;j--){
            sum=sum*j/bot++;
        }
        return (int)sum;
    }
}