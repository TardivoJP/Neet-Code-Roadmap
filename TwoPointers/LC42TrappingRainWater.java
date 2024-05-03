class TrappingRainWater {
    public static void main(String[] args) {
        int[] testcase1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] testcase2 = {4,2,0,3,2,5};
        int[] testcase3 = {4,2,3};
        int[] testcase4 = {9,8,2,6};
        
        System.out.println(trap(testcase1));
        System.out.println(trap(testcase2));
        System.out.println(trap(testcase3));
        System.out.println(trap(testcase4));
    }

    public static int trap(int[] height) {
        if(height.length < 3){
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int maxLeft = height[left];
        int maxRight = height[right];

        int answer = 0;

        while(left < right){
            if(maxRight > maxLeft){
                left++;

                if(maxLeft - height[left] > 0){
                    answer += maxLeft - height[left];
                }

                if(height[left] > maxLeft){
                    maxLeft = height[left];
                }
            }else{
                right--;

                if(maxRight - height[right] > 0){
                    answer += maxRight - height[right];
                }

                if(height[right] > maxRight){
                    maxRight = height[right];
                }
            }
        }

        return answer;
    }
}