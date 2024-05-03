import java.util.ArrayList;
import java.util.List;

class EncodeAndDecodeStrings {

    public static void main(String[] args){
        //String[] testCasesArr = {"neet","code","love","you"};
        String[] testCasesArr = {"we","say",":","yes"};
        List<String> testCasesList = new ArrayList<>();

        for(String str : testCasesArr){
            testCasesList.add(str);
        }

        String encoded = encode(testCasesList);
        List<String> decoded = decode(encoded);
        System.out.println(encoded);
        System.out.println(testCasesList);
        System.out.println(decoded);
    }

    public static String encode(List<String> strs) {
        String result = "";
        char delimiter = '#';

        for(String string : strs){
            result += string.length();
            result += delimiter;
            result += string;
        }

        return result;
    }

    public static List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        StringBuilder digitBuilder = new StringBuilder();
        StringBuilder separateString = new StringBuilder();
        boolean delimiterFound = false;
        char delimiter = '#';
        int delimiterPtr = 0;
        int curStrLen = 0;

        for(int i=0; i<str.length(); i++){
            if(!delimiterFound && str.charAt(i) == delimiter){
                curStrLen = Integer.parseInt(digitBuilder.toString());
                digitBuilder = new StringBuilder();
                delimiterFound = true;
            }

            if(delimiterPtr == 0 && !delimiterFound){
                digitBuilder.append(str.charAt(i));
            }

            if(delimiterFound){
                if(delimiterPtr>0){
                    separateString.append(str.charAt(i));
                }
                delimiterPtr++;
            }

            if(delimiterPtr > curStrLen){
                result.add(separateString.toString());
                separateString = new StringBuilder();
                delimiterPtr = 0;
                delimiterFound = false;
            }
        }

        return result;
    }
    
}
