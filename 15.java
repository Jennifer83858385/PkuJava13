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
        Arrays.sort(nums);
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        for(int i=0;i<nums.length;i++){
            int begin=i+1,end=nums.length-1;
            while(begin<end){
            	if(nums[begin]+nums[end]+nums[i]>0){
            		end--;
            	}else if(nums[begin]+nums[end]+nums[i]<0){
            		begin++;
            	}
            	else {
            		List<Integer> one = new LinkedList<Integer>();
            		one.add(nums[i]);
            		one.add(nums[begin]);
            		one.add(nums[end]);
            		list.add(one);
            		end--;
            		begin++;
            	}
            }
        }
		return removeDuplicate(list);
    }
}