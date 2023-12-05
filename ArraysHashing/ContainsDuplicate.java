import java.util.HashSet;

class ContainsDuplicate {
    public static void main(String[] args){
        int[] nums = {1,2,3,1};
        int[] example2 = {1,2,3,4};
        int[] example3 = {1,1,1,3,3,4,3,2,4,2};

        System.out.println(containsDuplicate(nums));
        System.out.println(containsDuplicate(example2));
        System.out.println(containsDuplicate(example3));
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){

            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }else{
                return true;
            }
        }
        return false;
    }
}