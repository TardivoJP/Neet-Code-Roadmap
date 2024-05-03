class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {4,5,6,7,0,1,2};
        int target1 = 0;

        int[] nums2 = {4,5,6,7,0,1,2};
        int target2 = 3;

        int[] nums3 = {1};
        int target3 = 0;

        int[] nums4 = {5,1,3};
        int target4 = 5;

        
        System.out.println(search(nums1, target1));
        System.out.println(search(nums2, target2));
        System.out.println(search(nums3, target3));
        System.out.println(search(nums4, target4));
    }

    public static int search(int[] nums, int target) {
        int ptrLeft = 0;
        int ptrRight = nums.length - 1;

        while(ptrLeft <= ptrRight){
            int middle = (ptrLeft + ptrRight) / 2;

            if(nums[middle] == target){
                return middle;
            }

            if(nums[middle] >= nums[0]){
                if(target < nums[0]){
                    ptrLeft = middle + 1;
                    continue;
                }
            }else{
                if(target >= nums[0]){
                    ptrRight = middle - 1;
                    continue;
                }
            }

            if(nums[middle] > target){
                ptrRight = middle - 1;
            }else{
                ptrLeft = middle + 1;
            }
        }

        return -1;
    }
}