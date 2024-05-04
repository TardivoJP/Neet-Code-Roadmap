class LC567PermutationInString {
    public static void main(String[] args) {
        String a1 = "ab";
        String b1 = "eidbaooo";

        String a2 = "ab";
        String b2 = "eidboaoo";

        String a3 = "abc";
        String b3 = "bcabcaaaaaaaaaaaaaa";

        System.out.println(checkInclusionClever(a1, b1));
        System.out.println(checkInclusionClever(a2, b2));
        System.out.println(checkInclusionClever(a3, b3));
    }

    public static boolean checkInclusionClever(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        int[] alphabetS1 = new int[26];
        int[] alphabetS2 = new int[26];
        int matches = 0;
        for(int i=0; i<s1.length(); i++){
            alphabetS1[s1.charAt(i) - 'a']++;
            alphabetS2[s2.charAt(i) - 'a']++;
        }

        for(int i=0; i<alphabetS1.length; i++){
            if(alphabetS1[i] == alphabetS2[i]){
                matches++;
            }
        }

        if(matches == 26){
            return true;
        }

        int left = 0;
        int right = s1.length() - 1;

        while(right < s2.length()){
            alphabetS2[s2.charAt(left) - 'a']--;
            if(alphabetS1[s2.charAt(left) - 'a'] == alphabetS2[s2.charAt(left) - 'a']){
                matches++;
            }else{
                matches--;
            }
            
            left++;
            right++;
            if(right == s2.length()){
                break;
            }

            alphabetS2[s2.charAt(right) - 'a']++;
            if(alphabetS1[s2.charAt(right) - 'a'] == alphabetS2[s2.charAt(right) - 'a']){
                matches++;
            }else{
                matches--;
            }

            if(matches == 26){
                return true;
            }
        }

        return false;
    }
    
    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        int[] alphabetS1 = new int[26];
        int[] alphabetS2 = new int[26];
        for(int i=0; i<s1.length(); i++){
            alphabetS1[s1.charAt(i) - 'a']++;
            alphabetS2[s2.charAt(i) - 'a']++;
        }

        if(compareAlphabets(alphabetS1, alphabetS2)){
            return true;
        }

        int left = 0;
        int right = s1.length() - 1;

        while(right < s2.length()){
            alphabetS2[s2.charAt(left) - 'a']--;
            left++;
            right++;
            if(right == s2.length()){
                break;
            }
            alphabetS2[s2.charAt(right) - 'a']++;

            if(compareAlphabets(alphabetS1, alphabetS2)){
                return true;
            }
        }

        return false;
    }

    private static boolean compareAlphabets(int[] a, int[] b){
        for(int i=0; i<a.length; i++){
            if(a[i] != b[i]){
                return false;
            }
        }

        return true;
    }
}