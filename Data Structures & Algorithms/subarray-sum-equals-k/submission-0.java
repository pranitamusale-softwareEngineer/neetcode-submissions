class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0,1);//subarrays starting at 0 index will be counted
        int sum=0;
        int count=0;
        for(int num: nums) {
            sum += num;
            count += prefixCount.getOrDefault(sum-k, 0);
            prefixCount.put(sum, prefixCount.getOrDefault(sum,0)+1);
        }
        return count;
    }
}