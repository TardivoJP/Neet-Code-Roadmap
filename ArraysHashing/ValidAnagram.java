import java.util.Arrays;

class ValidAnagram {
    public static void main(String[] args){
        String s = "anagram", t = "nagaram";
        String x = "rat", y = "car";

        System.out.println(isAnagram(s,t));
        System.out.println(isAnagram(x,y));
    }

    public static boolean isAnagram(String s, String t) {
        char charArray1[] = s.toCharArray();
        char charArray2[] = t.toCharArray();

        if(charArray1.length!=charArray2.length){
            return false;
        }

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        String sortedS = new String(charArray1);
        String sortedT = new String(charArray2);

        if(sortedS.equals(sortedT)){
            return true;
        }

        return false;
    }
}