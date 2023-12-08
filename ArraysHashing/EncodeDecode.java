import java.util.ArrayList;

public class EncodeDecode {
    public static void main(String[] args){
        String[] input1 = {"lint","code","love","you"};
        String[] input2 = {"we", "say", ":", "yes"};

        String result1a = encode(input1);
        String[] result1b = decode(result1a);

        String result2a = encode(input2);
        String[] result2b = decode(result2a);


        for(String str : input1){
            System.out.print(str+" ");
        }
        System.out.println();
        System.out.println(result1a);
        for(String str : result1b){
            System.out.print(str+" ");
        }

        System.out.println();

        for(String str : input2){
            System.out.print(str+" ");
        }
        System.out.println();
        System.out.println(result2a);
        for(String str : result2b){
            System.out.print(str+" ");
        }
    }

    public static String encode(String[] input){
        String result = "";

        for(int i=0;i<input.length;i++){
            String temp = input[i];
            temp = input[i].length() + "#" + temp;

            result = result + temp;
        }

        return result;
    }

    public static String[] decode(String input){
        ArrayList<String> strs = new ArrayList<>();

        boolean infoState = true, ignoreFirstSymbol = false;
        String currStr = "", digit = "";
        int strSize = 0, strCounter = 0;
        for(char c : input.toCharArray()){
            if(c == '#' && infoState == true){
                infoState = false;
                ignoreFirstSymbol = true;
            }

            if(infoState){
                digit = digit + c;
                strSize = Integer.parseInt(digit);
            }else{
                if(strCounter<strSize){
                    if(ignoreFirstSymbol){
                        ignoreFirstSymbol = false;
                    }else{
                        currStr = currStr + c;
                    }
                    strCounter++;
                }else{
                    strSize = 0;
                    strCounter = 0;
                    infoState = true;

                    currStr = currStr + c;
                    strs.add(currStr);

                    currStr = "";
                    digit = "";
                }
            }
        }

        String[] result = new String[strs.size()];

        for(int i=0;i<strs.size();i++){
            result[i] = strs.get(i);
        }

        return result;
    }
}