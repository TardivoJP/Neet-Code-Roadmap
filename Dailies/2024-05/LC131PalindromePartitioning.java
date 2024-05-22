import java.util.ArrayList;
import java.util.List;

class PalindromePartitioning {
    public static void main(String[] args) {
        String input1 = "aab";
        String input2 = "a";
        String input3 = "aaab";
        String input4 = "abcaa";
        
        List<List<String>> result = new ArrayList<>();

        result = partition(input1); // expected [[a, a, b], [aa, b]]
        System.out.println(result);

        result = partition(input2); // expected [[a]]
        System.out.println(result);

        result = partition(input3); // expected [[a, a, a, b], [a, aa, b], [aa, a, b], [aaa, b]]
        System.out.println(result);

        result = partition(input4); // expected [[a, b, c, a, a], [a, b, c, aa]]
        System.out.println(result);
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> answer = new ArrayList<>();
        List<String> cur = new ArrayList<>();

        generatePartitions(s, 0, cur, answer);

        return answer;
    }

    public static void generatePartitions(String s, int start, List<String> cur, List<List<String>> answer){
        if(start >= s.length()){
            answer.add(new ArrayList<>(cur));
            return;
        }

        for(int end=start; end<s.length(); end++){
            if(isPalindrome(s, start, end)){
                cur.add(s.substring(start, end + 1));
                generatePartitions(s, end + 1, cur, answer);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}