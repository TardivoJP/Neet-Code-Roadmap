import java.util.ArrayDeque;

class SlidingWindowMaximum {
    public static void main (String[] args){
        int[] nums1 = {1,3,-1,-3,5,3,6,7};
        int k1 = 3;

        int[] nums2 = {1};
        int k2 = 1;

        int[] nums3 = {1, -1};
        int k3 = 1;

        int[] result = maxSlidingWindow(nums1, k1); // expected [3,3,5,5,6,7]
        printResult(result);

        result = maxSlidingWindow(nums2, k2); // expected [1]
        printResult(result);

        result = maxSlidingWindow(nums3, k3); // expected [1,-1]
        printResult(result);
    }
    
    public static void printResult(int[] answer){
        for(int num : answer){
            System.out.print(num+" ");
        }
        System.out.println();
    }

    public static int[] maxSlidingWindowClever(int[] nums, int k) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int left = 0;
        int right = 0;
        int[] answer = new int[nums.length - k + 1];

        while(right < nums.length){
            while(!queue.isEmpty() && nums[right] > nums[queue.peekLast()]){
                queue.pollLast();
            }
            queue.addLast(right);

            if(left > queue.peekFirst()){
                queue.pollFirst();
            }

            if(right + 1 >= k){
                answer[left] = nums[queue.peekFirst()];
                left++;
            }

            right++;
        }

        return answer;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for(int i=0; i<k; i++){
            if(!queue.isEmpty()){
                if(nums[i] < queue.peekLast()){
                    queue.addLast(nums[i]);
                }else{
                    while(!queue.isEmpty()){
                        if(nums[i] > queue.peekLast()){
                            queue.pollLast();
                        }else{
                            break;
                        }
                    }
                    queue.addLast(nums[i]);
                }       
            }else{
                queue.addFirst(nums[i]);
            }
        }

        int left = 0;
        int right = k - 1;
        int count = 0;
        int[] answer = new int[nums.length - k + 1];

        while(count < answer.length){
            answer[count] = queue.peekFirst();
            count++;
            if(count >= answer.length){
                break;
            }

            if(nums[left] == queue.peekFirst()){
                queue.pollFirst();
            }
            left++;
            right++;
            
            if(!queue.isEmpty()){
                if(nums[right] < queue.peekLast()){
                    queue.addLast(nums[right]);
                }else{
                    while(!queue.isEmpty()){
                        if(nums[right] > queue.peekLast()){
                            queue.pollLast();
                        }else{
                            break;
                        }
                    }
                    queue.addLast(nums[right]);
                }       
            }else{
                queue.addFirst(nums[right]);
            }
        }

        return answer;
    }
}