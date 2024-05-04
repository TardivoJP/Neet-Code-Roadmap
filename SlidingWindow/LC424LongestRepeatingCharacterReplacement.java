class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String input1 = "ABAB";
        int k1 = 2;

        String input2 = "AABABBA";
        int k2 = 1;

        String input3 = "A";
        int k3 = 1;

        String input4 = "ABBB";
        int k4 = 2;

        String input5 = "ABAA";
        int k5 = 0;

        String input6 = "ABCCCCC";
        int k6 = 2;

        System.out.println(characterReplacement(input1, k1));
        System.out.println(characterReplacement(input2, k2));
        System.out.println(characterReplacement(input3, k3));
        System.out.println(characterReplacement(input4, k4));
        System.out.println(characterReplacement(input5, k5));
        System.out.println(characterReplacement(input6, k6));
    }

    public static int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int[] alphabet = new int[26];

        int answer = 0;
        int mostFrequent = 0;

        while(right < s.length()){
            if(s.length() - left <= answer){
                break;
            }

            alphabet[s.charAt(right) - 'A']++;
            mostFrequent = Math.max(mostFrequent, alphabet[s.charAt(right) - 'A']);

            for(int num : alphabet){
                if(num > mostFrequent){
                    mostFrequent = num;
                }
            }

            if(right - left + 1 - mostFrequent > k){
                alphabet[s.charAt(left) - 'A']--;
                alphabet[s.charAt(right) - 'A']--;
                left++;
            }else{
                if(right - left + 1 > answer){
                    answer = right - left + 1;
                }
                right++;
            }
        }

        return answer;
    }
}