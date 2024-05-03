import java.util.HashMap;

class TwoSum {
    public static void main(String[] args){
        int[] testCase1 = {2,7,11,15};
        int target1 = 9;

        int[] testCase2 = {3,2,4};
        int target2 = 6;

        int[] testCase3 = {3, 3};
        int target3 = 6;

        int[] solution = twoSum(testCase1, target1);
        System.out.println(solution[0] + " " + solution[1]);

        solution = twoSum(testCase2, target2);
        System.out.println(solution[0] + " " + solution[1]);

        solution = twoSum(testCase3, target3);
        System.out.println(solution[0] + " " + solution[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] solution = new int[2];

        for(int i=0; i<nums.length; i++){
            int remainder = target - nums[i];

            if(map.containsKey(remainder)){
                solution[0] = map.get(remainder);
                solution[1] = i;
                break;
            }

            map.put(nums[i], i);
        }

        return solution;
    }
}