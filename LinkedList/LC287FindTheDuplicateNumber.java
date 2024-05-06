class FindTheDuplicateNumber {
    public static void main(String[] args) {
        int[] nums1 = {1,3,4,2,2};
        int[] nums2 = {3,1,3,4,2};
        int[] nums3 = {3,3,3,3,3};
        int[] nums4 = {18,13,14,17,9,19,7,17,4,6,17,5,11,10,2,15,8,12,16,17};

        System.out.println(findDuplicate(nums1)); // expected 2
        System.out.println(findDuplicate(nums2)); // expected 3
        System.out.println(findDuplicate(nums3)); // expected 3
        System.out.println(findDuplicate(nums4)); // expected 17
    }

    public static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];

            if(slow == fast){
                break;
            }
        }

        int slow2 = 0;

        while(true){
            slow = nums[slow];
            slow2 = nums[slow2];

            if(slow == slow2){
                return slow;
            }
        }
    }
}