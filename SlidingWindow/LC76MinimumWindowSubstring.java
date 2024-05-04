import java.util.HashMap;

class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";

        String s2 = "a";
        String t2 = "a";

        String s3 = "a";
        String t3 = "aa";

        String s4 = "cabwefgewcwaefgcf";
        String t4 = "cae";

        /* System.out.println(minWindow(s1, t1));
        System.out.println(minWindow(s2, t2));
        System.out.println(minWindow(s3, t3)); */
        System.out.println(minWindow(s4, t4));
    }

    public static class Pair{
        int current;
        int necessary;

        public Pair(int current, int necessary){
            this.current = current;
            this.necessary = necessary;
        }
    }

    public static String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }

        HashMap<Character, Pair> map = new HashMap<>();

        for(int i=0; i<t.length(); i++){
            if(!map.containsKey(t.charAt(i))){
                map.put(t.charAt(i), new Pair(0, 1));
            }else{
                map.get(t.charAt(i)).necessary++;
            }
        }

        int left = 0;

        int have = 0;
        int need = map.size();

        int bestLeft = 1;
        int bestRight = Integer.MAX_VALUE;

        for(int i=0; i<s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                map.get(s.charAt(i)).current++;
                if(map.get(s.charAt(i)).current == map.get(s.charAt(i)).necessary){
                    have++;
                }
            }

            while(have == need){
                if(i - left + 1 < bestRight - bestLeft + 1){
                    bestLeft = left;
                    bestRight = i;
                }

                if(map.containsKey(s.charAt(left))){
                    map.get(s.charAt(left)).current--;
                    if(map.get(s.charAt(left)).current < map.get(s.charAt(left)).necessary){
                        have--;
                    }
                }

                left++;
            }        
        }

        if(bestRight == Integer.MAX_VALUE){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for(int i=bestLeft; i<=bestRight; i++){
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}