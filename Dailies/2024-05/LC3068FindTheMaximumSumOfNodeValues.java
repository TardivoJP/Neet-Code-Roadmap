class FindTheMaximumSumOfNodeValues {
    public static void main(String[] args) {
        int[] nums1 = {1,2,1};
        int k1 = 3;
        int[][] edges1 = {{0,1},{0,2}};

        int[] nums2 = {2,3};
        int k2 = 7;
        int[][] edges2 = {{0,1}};

        int[] nums3 = {7,7,7,7,7,7};
        int k3 = 3;
        int[][] edges3 = {{0,1},{0,2},{0,3},{0,4},{0,5}};

        int[] nums4 = {24,78,1,97,44};
        int k4 = 6;
        int[][] edges4 = {{0,2},{1,2},{4,2},{3,4}};

        int[] nums5 = {78,43,92,97,95,94};
        int k5 = 6;
        int[][] edges5 = {{1,2},{3,0},{4,0},{0,1},{1,5}};

        System.out.println(maximumValueSum(nums1, k1, edges1)); // expected 6
        System.out.println(maximumValueSum(nums2, k2, edges2)); // expected 9
        System.out.println(maximumValueSum(nums3, k3, edges3)); // expected 42
        System.out.println(maximumValueSum(nums4, k4, edges4)); // expected 260
        System.out.println(maximumValueSum(nums5, k5, edges5)); // expected 507
    }

    public static long maximumValueSum(int[] nums, int k, int[][] edges) {
        long maxSum = 0;
        int posNodes = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++){
            int kXOR = nums[i] ^ k;
            int diff = kXOR - nums[i];

            if(diff > 0){
                maxSum += diff;
                posNodes++;
                min = Math.min(min, diff);
            }else{
                max = Math.max(max, diff);
            }

            maxSum += nums[i];
        }

        if(posNodes % 2 != 0){
            return Math.max(maxSum - min, maxSum + max);
        }

        return maxSum;
    }
}
