class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsIndex = new HashMap<>();
        int result[] = new int[2];
        for(int i=0; i< nums.length;i++) {
            int remaining = target - nums[i];
            if(numsIndex.containsKey(remaining)) {
                result[0] = numsIndex.get(remaining);
                result[1] = i;
            } 
            numsIndex.put(nums[i],i);
        }
        return result;
    }
}
