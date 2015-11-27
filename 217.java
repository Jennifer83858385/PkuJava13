/*
检查是否有重复的元素
*/
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set <Integer> set = new HashSet<Integer>();
        for(int i:nums){
            set.add(i);
        }
        if(set.size()<nums.length)return true;
        else return false;
    }
}