class Solution {
    public int search(int[] nums, int target) {
       int pivotIdx = findPivotIdx(nums);
       
       if(target >= nums[0] && target <= nums[pivotIdx]) {
            return binarySearch(nums, target, 0, pivotIdx);   
       } else if(pivotIdx+1 < nums.length && target >= nums[pivotIdx+1] && target <= nums[nums.length-1]) {
            return binarySearch(nums, target, pivotIdx+1, nums.length-1);
       } 
       return -1;
        
    }

    public int findPivotIdx(int[] nums){
        int s=0, e=nums.length-1;
        while(s<e) {
            int mid = s+ (e-s)/2;
            if(mid+1 < nums.length && nums[mid] > nums[mid+1] ) {
                return mid;
            } if(mid-1>0 && nums[mid-1] > nums[mid]) {
                return mid-1;
            }
            if(nums[s] >= nums[mid]){
                e=mid-1;
            } else {
                s=mid;
            }
        }
        return s;
    }

    public int binarySearch(int nums[], int target, int s, int e) {
        while(s<=e) {
            int mid= s+(e-s)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                e=mid-1;
            } else {
                s=mid+1;
            }
        }
        return -1;
    }

}

