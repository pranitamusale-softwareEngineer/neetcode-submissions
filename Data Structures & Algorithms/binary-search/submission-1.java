class Solution {
    public int search(int[] nums, int target) {
        int s=0, e=nums.length-1;
        int mid = s+(e-s)/2;
        while(s<=e){
            if(target == nums[mid]) return mid;
            else if(target > nums[mid]){
                s = mid+1;
            } else {
                e = mid-1;
            }
            mid = s+(e-s)/2;
        }
        return -1;
    }
}
