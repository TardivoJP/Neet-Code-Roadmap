import java.util.HashMap;

class NumberOfWonderfulSubstrings {
    public static void main(String[] args){
        String a = "abab";
        String b ="ab";

        System.out.println(wonderfulSubstrings("aabb"));
    }

    public static long wonderfulSubstrings(String word) {
        int mask = 0;
        HashMap<Integer, Integer> maskCount = new HashMap<>();
        maskCount.put(0, 1);

        long answer = 0;

        for(char c : word.toCharArray()){
            int index = c - 'a';
            mask ^= (1<<index);

            if(!maskCount.containsKey(mask)){
                maskCount.put(mask, 0);
            }

            answer += maskCount.get(mask);

            for(int i=0; i<10; i++){
                int preMask = mask ^ (1<<i);

                if(!maskCount.containsKey(preMask)){
                    maskCount.put(preMask, 0);
                }

                answer += maskCount.get(preMask);
            }

            maskCount.put(mask, maskCount.get(mask) + 1);
        }

        return answer;
    }
}
