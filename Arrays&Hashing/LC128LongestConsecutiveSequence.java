import java.util.HashSet;

class LongestConsecutiveSequence {
    public static void main(String[] args){
        int[] testcase1 = {100,4,200,1,3,2};
        int[] testcase2 = {0,3,7,2,5,8,4,6,0,1};

        
        System.out.println(longestConsecutive(testcase1));
        System.out.println(longestConsecutive(testcase2));
    }

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }

        int longestSequence = 0;

        for(int i=0; i<nums.length; i++){
            int val = nums[i];
            int curSequence = 1;

            if(!set.contains(val-1)){
                while(set.contains(val+1)){
                    val++;
                    curSequence++;
                }
            }
            
            if(curSequence > longestSequence){
                longestSequence = curSequence;
            }
        }

        return longestSequence;
    }

}
