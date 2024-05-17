class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] input1 = {7,1,5,3,6,4};
        int[] input2 = {7,6,4,3,1};
        int[] input3 = {2,7,1,11,4};
        int[] input4 = {8,6,4,3,3,2,3,5,8,3,8,2,6};

        System.out.println(maxProfit(input1));
        System.out.println(maxProfit(input2));
        System.out.println(maxProfit(input3));
        System.out.println(maxProfit(input4));
    }

    public static int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int profit = 0;

        while(right < prices.length){
            profit = Math.max(prices[right] - prices[left], profit);

            if(prices[right] < prices[left]){
                left = right;
            }

            right++;
        }

        return profit;
    }
}