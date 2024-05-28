import java.util.Arrays;

class SpecialArrayWithXElementsGreaterThanOrEqualX {
    public static void main(String[] args) {
        int[] input1 = {3,5};
        int[] input2 = {0,0};
        int[] input3 = {0,4,3,0,4};
        int[] input4 = {3,6,7,7,0};
        int[] input5 = {0,5};
        int[] input6 = {3,9,7,8,3,8,6,6};

        System.out.println(specialArrayClever(input1)); // expected 2
        System.out.println(specialArrayClever(input2)); // expected -1
        System.out.println(specialArrayClever(input3)); // expected 3
        System.out.println(specialArrayClever(input4)); // expected -1
        System.out.println(specialArrayClever(input5)); // expected 1
        System.out.println(specialArrayClever(input6)); // expected 6
    }

    public static int specialArrayClever(int[] nums) {
        int numsSize = nums.length;
        int[] freq = new int[numsSize + 1];

        for(int i=0; i<numsSize; i++){
            freq[Math.min(numsSize, nums[i])]++;
        }

        int numsGreaterSum = 0;
        for(int i=nums.length; i>=0; i--){
            numsGreaterSum += freq[i];

            if(i == numsGreaterSum){
                return i;
            }
        }

        return -1;
    }

    public static int specialArray(int[] nums) {
        Arrays.sort(nums);
        int zeroes = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                zeroes++;
                continue;
            }

            break;
        }

        for(int i=1; i<=nums.length - zeroes; i++){
            int count = 0;

            for(int j=zeroes; j<nums.length; j++){
                if(nums[j] >= i){
                    count++;
                }

                if(count > i){
                    break;
                }
            }

            if(count == i){
                return i;
            }
        }

        return -1;
    }
}