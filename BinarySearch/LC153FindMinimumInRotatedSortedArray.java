class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] testcase1 = {3,4,5,1,2};
        int[] testcase2 = {4,5,6,7,0,1,2};
        int[] testcase3 = {11,13,15,17};
        int[] testcase4 = {1};
        int[] testcase5 = {2,1};

        System.out.println(findMinBetter(testcase1));
        System.out.println(findMinBetter(testcase2));
        System.out.println(findMinBetter(testcase3));
        System.out.println(findMinBetter(testcase4));
        System.out.println(findMinBetter(testcase5));
    }

    public static int findMin(int[] nums) {
        int leftptr = 0;
        int rightptr = nums.length - 1;
        int min = nums[0];

        while(leftptr <= rightptr){
            int middle = (rightptr - leftptr) / 2 + leftptr;

            if(nums[middle] < min){
                min = nums[middle];
            }

            if(nums[middle] >= nums[0]){
                leftptr = middle + 1;
            }else{
                rightptr = middle - 1;
            }
        }

        return min;
    }

    public static int findMinBetter(int[] nums) {
        int leftptr = 0;
        int rightptr = nums.length - 1;
        int min = nums[0];

        while(leftptr <= rightptr){
            if(nums[leftptr] < nums[rightptr]){
                min = Math.min(min, nums[leftptr]);
                break;
            }

            int middle = (rightptr - leftptr) / 2 + leftptr;
            min = Math.min(min, nums[middle]);

            if(nums[middle] >= nums[0]){
                leftptr = middle + 1;
            }else{
                rightptr = middle - 1;
            }
        }

        return min;
    }
}