import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class GroupAnagrams {
    public static void main(String[] args){
        String[] testCase1 = {"eat","tea","tan","ate","nat","bat"};
        String[] testCase2 = {""};
        String[] testCase3 = {"a"};

        List<List<String>> result = groupAnagrams2(testCase1);
        System.out.println(result);

        result = groupAnagrams2(testCase2);
        System.out.println(result);

        result = groupAnagrams2(testCase3);
        System.out.println(result);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, ArrayList<Integer>> anagrams = new HashMap<>();

        for(int i=0; i<strs.length; i++){
            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            String currentAnagram = new String(charArr);

            if(!anagrams.containsKey(currentAnagram)){
                anagrams.put(currentAnagram, new ArrayList<>());
            }

            anagrams.get(currentAnagram).add(i);
        }

        for(String key : anagrams.keySet()){
            ArrayList<Integer> anagramList = anagrams.get(key);
            List<String> anagram = new ArrayList<>();

            for(int i=0; i<anagramList.size(); i++){
                anagram.add(strs[anagramList.get(i)]);
            }

            result.add(anagram);
        }

        return result;
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> anagrams = new HashMap<>();

        for(int i=0; i<strs.length; i++){
            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            String currentAnagram = new String(charArr);

            if(!anagrams.containsKey(currentAnagram)){
                anagrams.put(currentAnagram, new ArrayList<>());
            }

            anagrams.get(currentAnagram).add(strs[i]);
        }

        for(String key : anagrams.keySet()){
            result.add(anagrams.get(key));
        }

        return result;
    }
}
