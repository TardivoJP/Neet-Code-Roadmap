class LC167TwoSumInputArrayIsSorted {
    public static void main(String[] args) {
        int[] testcase1arr = {2,7,11,15};
        int testcase1target = 9;

        int[] testcase2arr = {2,3,4};
        int testcase2target = 6;

        int[] testcase3arr = {-1,0};
        int testcase3target = -1;

        int[] testcase4arr = {0,0,3,4};
        int testcase4target = 0;

        int[] answer = twoSum(testcase1arr, testcase1target);
        
        for(int num : answer){
            System.out.print(num + " ");
        }
        System.out.println();


        answer = twoSum(testcase2arr, testcase2target);
        for(int num : answer){
            System.out.print(num + " ");
        }
        System.out.println();


        answer = twoSum(testcase3arr, testcase3target);
        for(int num : answer){
            System.out.print(num + " ");
        }
        System.out.println();


        answer = twoSum(testcase4arr, testcase4target);
        for(int num : answer){
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static int[] twoSum(int[] numbers, int target) {
        int ptrA = 0;
        int ptrB = numbers.length-1;

        while(ptrA < ptrB){
            if(numbers[ptrA] + numbers[ptrB] == target){
                return new int[]{ptrA+1, ptrB+1};
            }

            if(numbers[ptrA] + numbers[ptrB] > target){
                ptrB--;
                continue;
            }

            if(numbers[ptrA] + numbers[ptrB] > target){
                ptrA++;
                continue;
            }

            ptrA++;
            ptrB--;
        }

        return new int[]{0,0};
    }
}