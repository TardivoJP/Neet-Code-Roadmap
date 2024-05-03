import java.util.ArrayList;
import java.util.HashMap;

class TopKFrequentElements {
    public static void main(String[] args){
        int[] testcase1nums = {1,1,1,2,2,3};
        int testcase1k = 2;

        int[] testcase2nums = {1};
        int testcase2k = 1;

        int[] testcase3nums = {4,1,-1,2,-1,2,3};
        int testcase3k = 2;

        int[] result = topKFrequent(testcase1nums, testcase1k);

        for(int val : result){
            System.out.print(val + " ");
        }
        System.out.println();

        result = topKFrequent(testcase2nums, testcase2k);

        for(int val : result){
            System.out.print(val + " ");
        }
        System.out.println();

        result = topKFrequent(testcase3nums, testcase3k);

        for(int val : result){
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        int[] result = new int[k];

        for(int i=0; i<nums.length; i++){
            if(frequency.containsKey(nums[i])){
                frequency.put(nums[i], frequency.get(nums[i])+1);
            }else{
                frequency.put(nums[i], 1);
            }
        }

        ArrayList<Integer>[] scoreboard = new ArrayList[nums.length];

        for(int i=0; i<nums.length; i++){
            scoreboard[i] = new ArrayList<>();
        }

        for(int key : frequency.keySet()){
            scoreboard[frequency.get(key)-1].add(key);
        }

        int currentResultSize = 0;

        for(int i=nums.length-1; i>=0; i--){
            if(currentResultSize >= k){
                break;
            }

            if(scoreboard[i].size() > 0){
                for(int num : scoreboard[i]){
                    result[currentResultSize] = num;
                    currentResultSize++;

                    if(currentResultSize >= k){
                        break;
                    }
                }
            }
        }

        return result;
    }
}
