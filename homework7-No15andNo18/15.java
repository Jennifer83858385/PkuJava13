package sum3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
        HashSet <List<Integer>> resultList = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        int max = nums.length - 1;
        for(int i = 0; i <= max; i++){
        	int j = i + 1;
        	int k = max;
        	for(;j < k;){
        		int sum = nums[i] + nums[k] + nums[j];
        		if(sum > 0){
        			k = k - 1;
        		}
        		else if(sum < 0){
        			j = j +1;
        		}
        		else{
        			ArrayList<Integer> curArray = new ArrayList<Integer>();
        			Collections.addAll(curArray, nums[i], nums[j], nums[k]);
        			resultList.add(curArray);
        			j = j + 1;
        			k = k - 1;
        		}
        	}
        }
        return new ArrayList<List<Integer>>(resultList);
    }
}
