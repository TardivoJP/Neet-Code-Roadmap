import java.util.HashSet;

class ContainsDuplicate {
    public static void main(String[] args){
        int[] testCase1 = {1,2,3,1};

        int[] testCase2 = {1,2,3,4};

        int[] testCase3 = {1,1,1,3,3,4,3,2,4,2};

        System.out.println(containsDuplicate(testCase1));
        System.out.println(containsDuplicate(testCase2));
        System.out.println(containsDuplicate(testCase3));
    }


    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            if(set.contains(nums[i])){
                return true;
            }else{
                set.add(nums[i]);
            }
        }

        return false;
    }
}