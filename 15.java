/*Author:李建锋
*Time：10.7
*Question：三数之和等于target
*Tips:通过排序简化问题，设置双指针快捷搜索，结果注意去重
*/
public class Solution {
    public List<List<Integer>> removeDuplicate(List<List<Integer>> list){
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		for (Iterator<List<Integer>> itor = list.iterator();itor.hasNext();) {
			set.add(itor.next());
		}
		list.clear();
		list.addAll(set);
		return list;
	}
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);//排序简化搜索过程
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        for(int i=0;i<nums.length;i++){
            int begin=i+1,end=nums.length-1;
            while(begin<end){//从当前位置开始向后搜索
            	if(nums[begin]+nums[end]+nums[i]>0){//三数之和结果偏大
            		end--;
            	}else if(nums[begin]+nums[end]+nums[i]<0){//结果偏小
            		begin++;
            	}
            	else {//结果正合适
            		List<Integer> one = new LinkedList<Integer>();
            		one.add(nums[i]);
            		one.add(nums[begin]);
            		one.add(nums[end]);
            		list.add(one);
					//可能有其他的可行结果，继续搜索
            		end--;
            		begin++;
            	}
            }
        }
		return removeDuplicate(list);//可能出现重复的结果
    }
}