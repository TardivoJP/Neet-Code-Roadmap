class SumOfAllSubsetXORTotals {
    public static void main(String[] args) {
        int[] input1 = {1,3};
        int[] input2 = {5,1,6};
        int[] input3 = {3,4,5,6,7,8};

        System.out.println(subsetXORSum(input1)); // expected 6
        System.out.println(subsetXORSum(input2)); // expected 28
        System.out.println(subsetXORSum(input3)); // expected 480

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@");

        System.out.println(crazyBitHackSolution(input1)); // expected 6
        System.out.println(crazyBitHackSolution(input2)); // expected 28
        System.out.println(crazyBitHackSolution(input3)); // expected 480
    }

    public static int subsetXORSum(int[] nums) {
        answer = 0;
        
        int[] subset = new int[nums.length];
        generateSubsets(nums, subset, 0, 0);

        return answer;
    }

    public static int answer;

    public static void generateSubsets(int[] nums, int[] subset, int size, int i){
        if(i >= nums.length){
            if(size > 0){
                int op = subset[0];

                for(int j=1; j<size; j++){
                    op = op ^ subset[j];
                }

                answer += op;
            }
            return;
        }

        generateSubsets(nums, subset, size, i+1);

        subset[size] = nums[i];

        generateSubsets(nums, subset, size+1, i+1);
    }

    public static int crazyBitHackSolution(int[] nums) {
        int result = 0;
        // Capture each bit that is set in any of the elements
        for (int num : nums) {
            result |= num;
        }
        // Multiply by the number of subset XOR totals that will have each bit set
        return result << (nums.length - 1);
    }
}