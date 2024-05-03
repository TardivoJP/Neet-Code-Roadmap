class ProductOfArrayExceptSelf {
    public static void main(String[] args){
        int[] testcase = {1,2,3,4};

        productExceptSelf(testcase);
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            result[i] = nums[i];
        }

        int prefix = 1;
        for(int i=0; i<nums.length; i++){
            result[i] = prefix;
            prefix *= nums[i];
        }

        int postfix = 1;
        for(int i=nums.length-1; i>=0; i--){
            result[i] *= postfix;
            postfix *= nums[i];
        }

        return result;
    }
}
