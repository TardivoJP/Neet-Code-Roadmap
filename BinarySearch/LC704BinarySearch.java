class BinarySearch {
    public static void main(String[] args) {
        int[] testcase1 = {-1,0,3,5,9,12};
        int target1 = 9;

        int[] testcase2 = {-1,0,3,5,9,12};
        int target2 = 2;

        int[] testcase3 = {5, 1};
        int target3 = 5;


        System.out.println(search(testcase1, target1));
        System.out.println(search(testcase2, target2));
        System.out.println(search(testcase3, target3));
    }

    public static int search(int[] nums, int target) {
        int leftPtr = 0;
        int rightPtr = nums.length-1;
        int middle = (rightPtr - leftPtr) / 2 + leftPtr;

        while(leftPtr <= rightPtr){
            if(target == nums[middle]){
                return middle;
            }else if(target > nums[middle]){
                leftPtr = middle + 1;
                middle = (rightPtr - leftPtr) / 2 + leftPtr;
            }else{
                rightPtr = middle - 1;
                middle = (rightPtr - leftPtr) / 2 + leftPtr;
            }
        }

        return -1;
    }
}