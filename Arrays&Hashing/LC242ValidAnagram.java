import java.util.Arrays;

class ValidAnagram {
    public static void main(String[] args){
        String testS1 = "anagram";
        String testT1 = "nagaram";

        String testS2 = "rat";
        String testT2 = "car";

        System.out.println(isAnagram(testS1, testT1));
        System.out.println(isAnagram(testS2, testT2));
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        int[] alphabetS = new int[26];
        int[] alphabetT = new int[26];
        Arrays.fill(alphabetS, 0);
        Arrays.fill(alphabetT, 0);

        for(int i=0; i<s.length(); i++){
            alphabetS[(int) s.charAt(i) - 97]++;
            alphabetT[(int) t.charAt(i) - 97]++;
        }

        return Arrays.equals(alphabetS, alphabetT);
    }
}
