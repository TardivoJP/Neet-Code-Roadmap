import java.util.ArrayList;
import java.util.List;

class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        generateSubset(nums, 0, cur, answer);
        System.out.println(answer);
        return answer;
    }

    public static void generateSubset(int[] nums, int index, List<Integer> cur, List<List<Integer>> answer){
        if(index >= nums.length){
            answer.add(new ArrayList<>(cur));
            return;
        }

        generateSubset(nums, index + 1, cur, answer);

        cur.add(nums[index]);
        generateSubset(nums, index + 1, cur, answer);
        cur.remove(cur.size() - 1);
    }
}