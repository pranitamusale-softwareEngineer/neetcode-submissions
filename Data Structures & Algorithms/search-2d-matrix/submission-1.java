class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int s =0, e = rows*cols -1;
        while(s<=e) {
            //calculate mid index of flattened array
            int mid = s+ (e-s)/2;
            //get value from row and cols in 2D array using mid
            //row = mid/cols, col = mid%cols
            int midVal = matrix[mid/cols][mid%cols];
            if(target==midVal) {
                return true;
            } else if(target < midVal) {
                e = mid-1;
            } else {
                s = mid+1;
            }
        }
        return false;
        
    }
}
