class GetEqualSubstringsWithinBudget {
    public static void main(String[] args) {
        String s1 = "abcd";
        String t1 = "bcdf";

        String s2 = "abcd";
        String t2 = "cdef";

        String s3 = "abcd";
        String t3 = "acde";

        String s4 = "krrgw";
        String t4 = "zjxss";


        System.out.println(equalSubstring(s1, t1, 3)); // expected 3
        System.out.println(equalSubstring(s2, t2, 3)); // expected 1
        System.out.println(equalSubstring(s3, t3, 0)); // expected 1
        System.out.println(equalSubstring(s4, t4, 19)); // expected 2
    }

    public static int equalSubstring(String s, String t, int maxCost) {
        int answer = 0;
        int size = 1;
        int start = 0;
        int startCost = Math.abs(s.charAt(start) - t.charAt(start));
        if(startCost <= maxCost){
            answer = 1;
        }

        int totalCost = startCost;
        
        for(int i=1; i<s.length(); i++){
            int curCost = Math.abs(s.charAt(i) - t.charAt(i));
            totalCost += curCost;
            size++;

            while(totalCost > maxCost && start < i){
                totalCost -= startCost;
                start++;
                startCost = Math.abs(s.charAt(start) - t.charAt(start));
                size--;
            }

            if(totalCost <= maxCost){
                answer = Math.max(size, answer);
            }
        }
        
        return answer;
    }
}