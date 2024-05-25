import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class WordBreakTwo {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> answer = new ArrayList<>();
        HashSet<String> wordSet = new HashSet<>();

        for(String word : wordDict){
            wordSet.add(word);
        }

        constructSentences(s, 0, new StringBuilder(), new StringBuilder(), wordSet, answer);
        return answer;
    }

    public void constructSentences(String s, int index, StringBuilder cur, StringBuilder sentence, HashSet<String> wordSet, List<String> answer){
        if(index >= s.length()){
            if(sentence.length() > 0 && cur.length() == 0){
                sentence.deleteCharAt(sentence.length() - 1);
                answer.add(sentence.toString());
            }
            return;
        }

        cur.append(s.charAt(index));
        String prevSentence = sentence.toString();
        String prevWord = cur.toString();

        if(wordSet.contains(cur.toString())){
            sentence.append(cur.toString());
            sentence.append(" ");

            cur.setLength(0);
            constructSentences(s, index + 1, cur, sentence, wordSet, answer);
        }

        sentence.setLength(0);
        cur.setLength(0);

        sentence.append(prevSentence);
        cur.append(prevWord);
        constructSentences(s, index + 1, cur, sentence, wordSet, answer);
    }
}