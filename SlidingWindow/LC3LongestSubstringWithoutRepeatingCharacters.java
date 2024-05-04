import java.util.HashSet;

class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

        s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s));

        s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));

        s = " ";
        System.out.println(lengthOfLongestSubstring(s));

        s = "dvdf";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int longest = 0;
        int curSequence = 0;

        HashSet<Character> uniques = new HashSet<>();

        while(right < s.length()){
            longest = Math.max(longest, curSequence);

            if(!uniques.contains(s.charAt(right))){
                uniques.add(s.charAt(right));
                curSequence++;
            }else{
                while(uniques.contains(s.charAt(right))){
                    uniques.remove(s.charAt(left));
                    curSequence--;
                    left++;
                }

                uniques.add(s.charAt(right));
                curSequence++;
            }
            
            right++;
        }

        return Math.max(longest, curSequence);
    }
}