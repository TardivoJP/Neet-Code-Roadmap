class ReversePrefixOfWord {
    public static void main(String[] args){
        String testcase1str = "abcdefd";
        char testcase1char = 'd';

        String testcase2str = "xyxzxe";
        char testcase2char = 'z';

        String testcase3str = "abcd";
        char testcase3char = 'z';

        System.out.println(reversePrefix(testcase1str, testcase1char));
        System.out.println(reversePrefix(testcase2str, testcase2char));
        System.out.println(reversePrefix(testcase3str, testcase3char));
    }

    public static String reversePrefix(String word, char ch) {
        int index = -1;

        for(int i=0; i<word.length(); i++){
            if(word.charAt(i) == ch){
                index = i;
                break;
            }
        }

        if(index == -1){
            return word;
        }

        int startPointer = 0;
        char[] wordArr = word.toCharArray();

        while(startPointer < index){
            char temp = wordArr[index];
            wordArr[index] = wordArr[startPointer];
            wordArr[startPointer] = temp;

            startPointer++;
            index--;
        }

        return String.valueOf(wordArr);
    }
}