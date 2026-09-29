class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n;i++) {
            //if prev ele at i is equal to next then continue
            if(i>0 && nums[i] == nums[i-1]) continue;
            int j=i+1, k=n-1;
            while(j<k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0 ) {
                    //as array is sorted we need larger element so move forward
                    j++;
                } else if (sum > 0) {
                    //we need smaller element
                    k--;
                } else {
                    List<Integer> result = new ArrayList<>();
                    Collections.addAll(result, nums[i], nums[j], nums[k]);
                    ans.add(result);
                    j++;
                    k--;
                    //move forward if same elements found
                    while(j<k && nums[j] == nums[j-1]) j++;
                    while(j<k && nums[k] == nums[k+1]) k--;
                }
            }
        }
        return ans;
    }
}
