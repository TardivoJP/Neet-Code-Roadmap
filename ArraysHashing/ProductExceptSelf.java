public class ProductExceptSelf {
    public static void main(String[] args){
        int[] nums1 = {1,2,3,4};
        int[] nums2 = {-1,1,0,-3,3};

        int[] result1 = productExceptSelf(nums1);
        int[] result2 = productExceptSelf(nums2);

        for(int number : result1){
            System.out.print(number+" ");
        }

        System.out.println();

        for(int number : result2){
            System.out.print(number+" ");
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int result[] = new int[size];
        result[0] = 1;

        int prefix = 1;
        for(int i=0;i<size;i++){
            result[i] = prefix;
            if(i<size-1){
                prefix *= nums[i];
            }
        }

        int postfix = 1;
        for(int i=size;i>0;i--){
            if(i==size){
                result[i-1] *= postfix;
            }else{
                postfix *= nums[i];
                result[i-1] *= postfix;
            }
        }

        return result;
    }
}