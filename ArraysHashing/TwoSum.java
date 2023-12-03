import java.util.HashMap;

class TwoSum {
    public static void main(String[] args){
        int[] nums1 = {2,7,11,15};
        int target1 = 9;
        int[] nums2 = {3,2,4};
        int target2 = 6;
        int[] nums3 = {3,3};
        int target3 = 6;

        int[] result1 = twoSum(nums1, target1);
        int[] result2 = twoSum(nums2, target2);
        int[] result3 = twoSum(nums3, target3);

        System.out.println(result1[0] + "," + result1[1]);
        System.out.println(result2[0] + "," + result2[1]);
        System.out.println(result3[0] + "," + result3[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] result = new int[2];

        for(int i=0;i<nums.length;i++){
            int complement = target - nums[i];

            if(map.containsKey(complement)){
                result[0] = map.get(complement);
                result[1] = i;
                return result;
            }else{
                map.put(nums[i], i);
            }
        }
        return result;
    }
}