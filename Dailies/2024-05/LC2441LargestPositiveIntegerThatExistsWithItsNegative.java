import java.util.HashSet;

class LargestPositiveIntegerThatExistsWithItsNegative {

    public static void main(String[] args) {
        int[] testcase1 = {-1,2,-3,3};
        int[] testcase2 = {-1,10,6,7,-7,1};
        int[] testcase3 = {-10,8,6,7,-2,-3};

        System.out.println(findMaxK(testcase1));
        System.out.println(findMaxK(testcase2));
        System.out.println(findMaxK(testcase3));
    }

    public static int findMaxK(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int maxK = -1;

        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }

        for(int val : set){
            if(val > 0 && set.contains(val * -1) && val > maxK){
                maxK = val;
            }
        }

        return maxK;
    }
}