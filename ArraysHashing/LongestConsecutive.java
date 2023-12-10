import java.util.HashSet;

class LongestConsecutive {
    public static void main(String[] args){
        int[] nums1 = {100,4,200,1,3,2};
        int[] nums2 = {0,3,7,2,5,8,4,6,0,1};

        int result1 = longestConsecutive(nums1);
        int result2 = longestConsecutive(nums2);

        System.out.println(result1);
        System.out.println(result2);
    }

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            numSet.add(nums[i]);
        }

        int biggestSequence = 0;

        for(int i=0;i<nums.length;i++){
            int currentSequence = 0;

            int prev = nums[i] - 1;

            if(numSet.contains(prev)){
                continue;
            }else{
                int next = nums[i] + 1;
                while(numSet.contains(next)){
                    next += 1;
                    currentSequence++;
                }
                currentSequence++;
            }

            if(currentSequence>biggestSequence){
                biggestSequence = currentSequence;
            }
        }

        return biggestSequence;
    }
}