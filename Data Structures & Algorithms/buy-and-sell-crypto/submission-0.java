class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit =0;
        for(int price: prices) {
            if(price < minPrice) {
                minPrice = price; //found a lower buy price
            } else if((price - minPrice) > maxProfit ) {
                maxProfit = price - minPrice; //selling today beats our best profit so far
            }
        }
        return maxProfit;
    }
}
