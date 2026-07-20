class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lowerBound = 1;
        int upperBound = Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++) {
            upperBound = Math.max(upperBound, piles[i]);
        }
        int ans = -1;
        while(lowerBound <= upperBound) {
            int mid = lowerBound + (upperBound - lowerBound)/2;
            if(isPossibleSolution(piles, h, mid)) {
                ans = mid;
                upperBound = mid-1;
            }
            else{
                lowerBound = mid+1;
            }
        }
        return ans;
    }

    public boolean isPossibleSolution(int[] piles, int h, int sol) {
        int periodToEat = 0;
        for(int i=0; i<piles.length; i++) {
            periodToEat += (piles[i]+sol-1)/sol;
        }
        return periodToEat <= h;
    }
}
