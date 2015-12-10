/*Author:李建锋
*Time：10.29
*Question：四数之和等于target
*Tips:参考三数之和
*/
public class Solution {
    public static List<List<Integer>> removeDuplicate(List<List<Integer>> list) {
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		for (Iterator<List<Integer>> itor = list.iterator(); itor.hasNext();) {
			set.add(itor.next());
		}
		list.clear();
		list.addAll(set);
		return list;
	}
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);//排序简化搜索范围
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		for (int i = 0; i < nums.length-3; i++) {//相比三数之和多了一层循环
			for (int j = i + 1; j < nums.length-2; j++) {//本质上就是三数之和等于定值问题
				int begin = j + 1, end = nums.length - 1;//从当前位置向后搜索
				while (begin < end) {
					if (nums[begin] + nums[end] + nums[i] + nums[j] > target) {//偏大
						end--;
					} else if (nums[begin] + nums[end] + nums[i] + nums[j] < target) {//偏小
						begin++;
					} else {//正合适
						List<Integer> one = new LinkedList<Integer>();
						one.add(nums[i]);
						one.add(nums[j]);
						one.add(nums[begin]);
						one.add(nums[end]);
						list.add(one);
						end--;
						begin++;
					}
				}

			}
		}
		return removeDuplicate(list);//结果去重
	
    }
}
