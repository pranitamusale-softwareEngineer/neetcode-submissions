class Solution {
    public boolean hasDuplicate(int[] nums) {
        //using frequency map
        HashSet<Integer> unique = new HashSet<>();
        for(int i=0;i<nums.length;i++) {
            if(!unique.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}