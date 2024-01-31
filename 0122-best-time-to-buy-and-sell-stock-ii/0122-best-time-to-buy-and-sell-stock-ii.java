class Solution {
    public int maxProfit(int[] prices) {
        
        int profit = 0;

        for(int i=1; i<prices.length; i++){
            if(prices[i] > prices[i-1]){
                int currProfit = prices[i] - prices[i-1];
                profit += currProfit;
            }
        }

        return profit;

    }
}