/*Author:李建锋
*Time：12.13
*Question：求小于n的素数有多少个
*Tips:以空间换时间
*/
public class Solution {
    public int countPrimes(int n) {
        Boolean[] isPrime = new Boolean[n];
        for(int i=2;i<n;i++)isPrime[i]=true;
        int count = 0;
        for(int i=2;i<n;i++){
            if(true==isPrime[i]){
                count++;
                for(int j=2;i*j<n;j++){
                    isPrime[i*j]=false;
                }
            }
        }
        return count;
    }
    
}