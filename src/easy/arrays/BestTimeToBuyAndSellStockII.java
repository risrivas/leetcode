package easy.arrays;

public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int[] prices1 = new int[]{1, 2, 3, 4, 5};
        int[] prices2 = new int[]{7, 6, 4, 3, 1};

        System.out.println(maxProfit(prices));
        System.out.println(maxProfit(prices1));
        System.out.println(maxProfit(prices2));

        int[] prices3 = new int[]{6, 1, 3, 2, 4, 7};
        System.out.println(maxProfit(prices3));
    }

    /**
     * Simplest Algorithm:
     * whenever current price is greater than previous price,
     * add the diff to profit
     *
     * @param prices
     * @return
     */
    private static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                profit += (prices[i] - prices[i - 1]);
        }

        return profit;
    }


    /**
     * Peak-valley algorithm:
     * find the first minimum - deepest valley
     * then find the next maximum - highest peak
     * profit += peak - valley
     * reset peak, valley and continue
     *
     * @param prices
     * @return
     */
    private static int maxProfit1(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        int profit = 0;

        int current_min = prices[0];
        int current_max = Integer.MIN_VALUE;

        boolean isCurrentMinFound = false;

        for (int i = 1; i < prices.length; i++) {
            if (!isCurrentMinFound && current_min > prices[i]) {
                current_min = prices[i];
                continue;
            } else {
                isCurrentMinFound = true;
                if (prices[i] > current_max) {
                    current_max = prices[i];
                    continue;
                } else {
                    // both current_min and current_max found
                    profit += (current_max - current_min);

                    // reset
                    isCurrentMinFound = false;
                    current_min = prices[i];
                    current_max = Integer.MIN_VALUE;
                }
            }
        }

        if ((current_min == prices[0] || current_max == prices[prices.length - 1]) && current_max > current_min) {
            profit += (current_max - current_min);
        }

        return profit;
    }

}
