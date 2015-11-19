/* 作者：李建锋
 * 晚交原因：昨晚在刷政治求原谅
 * 题目：读取两个文件统计每个文件单词数目和词汇表，单词交集,
 * 对任务3“wd∈B且 wd∉A的单词占B文件的百分比” 的理解为：集合概念中b对a的补集占a集合的比例
 *
 */
package homework;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Set;

public class FIleRead {
	private static int[] total = new int[2];
	private static Set<String> jiaoset = new HashSet();
	private static  Set<String> bingset = new HashSet();
	private static double percent1=0,percent2=0;
	 /**
     * 按照行为单位一次读取一行字符
     * num:区分输入的是第几个文件
     */
    public static HashMap<String,Integer> readFileByLines(String fileName,int num) {
        File file = new File(fileName);
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            //一次读入一行一直到读到null为止
            while ((tempString = reader.readLine()) != null) {
                String words[] = tempString.trim().split("\\W+");
                 total[num]+=words.length;
                for(int i=0;i<words.length;i++){
                	int times = 0;
                	if(map.containsKey(words[i]))times=map.get(words[i]);
                	if(words[i].length()<=0){
                		total[num]--;
                		}
                	else map.put(words[i], ++times);
                }
                
            }
            System.out.println("文件"+num+"单词表："+map);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
		return map;
    }
    public static void jiao_bing(HashMap map1,HashMap map2){
    	Set set1 = (Set) map1.keySet();
    	Set set2 = (Set) map2.keySet();    	
    	Set temp = new HashSet();
    	//并集求解过程
    	bingset.addAll(set2);
    	bingset.addAll(set1);
    	//交集求解过程
    	jiaoset.addAll(set1);
    	//temp是set1对set2的补集
    	temp.addAll(set1);
    	temp.removeAll(set2);
    	jiaoset.removeAll(temp);
    	percent1=(set1.size()-jiaoset.size())/(set1.size()*1.0);
    	percent2=(set2.size()-jiaoset.size())/(set2.size()*1.0);
    	
    }
    public static void main(String[] args) {
    	HashMap<String,Integer> map1 = readFileByLines("D:\\file1.txt",0);
    	HashMap<String,Integer> map2 = readFileByLines("D:\\file2.txt",1);
    	jiao_bing(map1, map2);
    	System.out.println("file1所有单词数为"+total[0]);
    	System.out.println("file2所有单词数为"+total[1]);
    	System.out.print("交集个数"+jiaoset.size());
    	System.out.println("交集为"+jiaoset);
    	System.out.print("并集个数"+bingset.size());
    	System.out.println("并集为"+bingset);
    	System.out.println("file1词汇表对file2的补集占file1的比重为"+percent1);
    	System.out.println("file2词汇表对file1的补集占file2的比重为"+percent2);
    	
    	
	}
}
