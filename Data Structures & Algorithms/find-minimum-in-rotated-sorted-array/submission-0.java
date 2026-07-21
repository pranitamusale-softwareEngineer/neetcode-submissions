class Solution {
    public int findMin(int[] nums) {
        int l =0, r= nums.length-1;
        
        while(l<r){
            int mid = l+ (r-l)/2;
            if(nums[r] < nums[mid]) {
                //min exist in right part
                l = mid+1;
            } else {
                //min exist in left part
                r = mid;
            }
        }
        return nums[l];
    }
}
