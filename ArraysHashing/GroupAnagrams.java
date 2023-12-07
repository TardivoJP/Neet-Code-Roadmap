import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args){
        String[] strArr = {"eat","tea","tan","ate","nat","bat"};
        String[] strArr2 = {""};
        String[] strArr3 = {"a"};

        String[][] test = groupAnagrams(strArr);
        String[][] test2 = groupAnagrams(strArr2);
        String[][] test3 = groupAnagrams(strArr3);

        for (String[] array : test) {
            for (String value : array) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (String[] array : test2) {
            for (String value : array) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (String[] array : test3) {
            for (String value : array) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static String[][] groupAnagrams(String[] strs) {
        HashMap<String, String[]> map = new HashMap<>();

        for(int i=0;i<strs.length;i++){
            char charArray[] = strs[i].toCharArray();
            Arrays.sort(charArray);
            String temp = new String(charArray);
            
            if(map.containsKey(temp)){
                String[] oldValues = map.get(temp);
                String[] newValues = new String[oldValues.length + 1];
                System.arraycopy(oldValues, 0, newValues, 0, oldValues.length);
                newValues[newValues.length - 1] = strs[i];
                map.put(temp, newValues);
            }else{
                String[] tempArr = new String[1];
                tempArr[0] = strs[i];
                map.put(temp, tempArr);
            }
        }

        ArrayList<String[]> arrayOfArrays = new ArrayList<>();

        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            arrayOfArrays.add(entry.getValue());
        }

        String[][] result = new String[arrayOfArrays.size()][];
        for (int i = 0; i < arrayOfArrays.size(); i++) {
            result[i] = arrayOfArrays.get(i);
        }

        return result;
    }
}