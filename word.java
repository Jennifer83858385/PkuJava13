import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordList {
	static List<String> readFile(String fileName){
		List<String> wordList = new ArrayList<String>();
		String[] tempStr;
		String lineStr;
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			while((lineStr = reader.readLine()) != null){
				tempStr = lineStr.split("[\\s,.;!]");
				for(String s:tempStr){
					if(!s.trim().equals("")){
						wordList.add(s.trim());
					}
				}
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return wordList;
	}
	static List<String> toToalList(List<String> list1, List<String> list2){
		
		if(list2.size() == 0){
			return list1;
		}else if(list1.size() == 0){
			return list2;
		}else{
			List<String> totalList = new ArrayList<String>();
			totalList.addAll(list1);
			for(String s:list2){
				if(totalList.contains(s)){
					continue;
				}else{
					totalList.add(s);
				}
				
			}
			return totalList;
		}
	}
	static List<String> toSameList(List<String> list1, List<String> list2){
		if(list1.size() == 0 || list2.size() == 0){
			return null;
		}else{
			List<String> sameList = new ArrayList<String>();
			for(String s:list2){
				if(list1.contains(s)){
					sameList.add(s);
					
				}else{
					continue;
				}
			}
			
			return sameList;
		}	
	}
	static boolean toFile(String fileName, List<String> list){
		boolean result = false;
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName);
			for(String s:list){
				fw.write(s+"\n");
			}
			result = true;
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fw != null){
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args){
		String fileName1 = "test1.txt";
		String fileName2 = "test2.txt";
		String totalListFile = "totalList.txt";
		String sameListFile = "sameList.txt";
		List<String> list1 = readFile(fileName1);
		List<String> list2 = readFile(fileName2);
		List<String> totalList = toToalList(list1, list2);
		List<String> sameList = toSameList(list1, list2);
		
		toFile(totalListFile, totalList);
		toFile(sameListFile, sameList);
		System.out.println("totalList.size():" + totalList.size());
		System.out.println("sameList.size():" + sameList.size());
	}
	
}
