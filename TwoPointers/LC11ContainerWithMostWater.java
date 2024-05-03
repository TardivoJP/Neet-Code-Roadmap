class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] testcase1 = {1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea(testcase1));
    }

    public static int maxArea(int[] height) {
        int answer = 0;
        int ptrLeft = 0;
        int ptrRight = height.length-1;

        while(ptrLeft < ptrRight){
            if(height[ptrLeft] > height[ptrRight]){
                int containerVolume = (ptrRight - ptrLeft) * height[ptrRight];

                if(containerVolume > answer){
                    answer = containerVolume;
                }

                ptrRight--;
            }else{
                int containerVolume = (ptrRight - ptrLeft) * height[ptrLeft];

                if(containerVolume > answer){
                    answer = containerVolume;
                }

                ptrLeft++;
            }
        }

        return answer;
    }
}