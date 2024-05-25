import java.util.HashMap;

class MaximumScoreWordsFormedByLetters {
    int maxScore = 0;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        HashMap<Character, Integer> alphabet = new HashMap<>();
        HashMap<String, HashMap<Character, Integer>> wordsFreq = new HashMap<>();

        for(String word : words){
            wordsFreq.put(word, new HashMap<>());
            HashMap<Character, Integer> wordMap = wordsFreq.get(word);

            for(int i=0; i<word.length(); i++){
                if(!wordMap.containsKey(word.charAt(i))){
                    wordMap.put(word.charAt(i), 1);
                }else{
                    wordMap.put(word.charAt(i),  wordMap.get(word.charAt(i)) + 1);
                }
            }
        }

        for(int i=0; i<letters.length; i++){
            if(!alphabet.containsKey(letters[i])){
                alphabet.put(letters[i], 1);
            }else{
                alphabet.put(letters[i],  alphabet.get(letters[i]) + 1);
            }
        }

        constructWords(0, 0, words, alphabet, wordsFreq, score);

        return maxScore;
    }

    public void constructWords(int index, int curScore, String[] words, HashMap<Character, Integer> alphabet, HashMap<String, HashMap<Character, Integer>> wordsFreq, int[] score){
        if(index >= words.length){
            maxScore = Math.max(maxScore, curScore);
            return;
        }

        constructWords(index + 1, curScore, words, alphabet, wordsFreq, score);


        HashMap<Character, Integer> wordMap = wordsFreq.get(words[index]);
        boolean canConstruct = true;

        for(char key : wordMap.keySet()){
            if(!alphabet.containsKey(key)){
                canConstruct = false;
                break;
            }

            if(alphabet.get(key) < wordMap.get(key)){
                canConstruct = false;
                break;
            }
        }

        if(canConstruct){
            for(char key : wordMap.keySet()){
                int freq = wordMap.get(key);

                alphabet.put(key, alphabet.get(key) - freq);
                curScore += score[key - 'a'] * freq;
            }

            constructWords(index + 1, curScore, words, alphabet, wordsFreq, score);

            for(char key : wordMap.keySet()){
                int freq = wordMap.get(key);

                alphabet.put(key, alphabet.get(key) + freq);
                curScore -= score[key - 'a'] * freq;
            }
        }
    }
}