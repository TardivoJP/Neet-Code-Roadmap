import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {
    public static void main(String[] args) {
        int[] testcase1 = {-1,0,1,2,-1,-4};

        threeSum(testcase1);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);

        int ptrA = 0;

        while(ptrA < nums.length-2){
            int ptrB = ptrA + 1;
            int ptrC = nums.length-1;

            if(ptrA > 0){
                if(nums[ptrA-1] == nums[ptrA]){
                    ptrA++;
                    continue;
                }
            }

            while(ptrB < ptrC){
                if(nums[ptrA] + nums[ptrB] + nums[ptrC] > 0){
                    ptrC--;
                    continue;
                }
    
                if(nums[ptrA] + nums[ptrB] + nums[ptrC] < 0){
                    ptrB++;
                    continue;
                }

                if(nums[ptrA] + nums[ptrB] + nums[ptrC] == 0){
                    answer.add(new ArrayList<>(Arrays.asList(nums[ptrA], nums[ptrB], nums[ptrC])));
                }

                ptrB++;
                ptrC--;

                while(nums[ptrB-1] == nums[ptrB] && ptrB < ptrC){
                    ptrB++;
                }
            }

            ptrA++;
        }

        System.out.println(answer);

        return answer;
    }
}