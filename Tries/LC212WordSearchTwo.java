import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class WordSearchTwo{
    public static void main(String[] args) {
        char[][] board1 = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words1 = {"oath","pea","eat","rain"};

        char[][] board2 = {{'a','b'},{'c','d'}};
        String[] words2 = {"abcb"};

        char[][] board3 = {{'a','a'}};
        String[] words3 = {"aaa"};

        char[][] board4 =  {{'b','a','b','a','b','a','b','a','b','a'},
                            {'a','b','a','b','a','b','a','b','a','b'},
                            {'b','a','b','a','b','a','b','a','b','a'},
                            {'a','b','a','b','a','b','a','b','a','b'},
                            {'b','a','b','a','b','a','b','a','b','a'},
                            {'a','b','a','b','a','b','a','b','a','b'},
                            {'b','a','b','a','b','a','b','a','b','a'},
                            {'a','b','a','b','a','b','a','b','a','b'},
                            {'b','a','b','a','b','a','b','a','b','a'},
                            {'a','b','a','b','a','b','a','b','a','b'}};
        String[] words4 = {"ababababaa","ababababab","ababababac","ababababad","ababababae","ababababaf","ababababag","ababababah","ababababai","ababababaj","ababababak","ababababal","ababababam","ababababan","ababababao","ababababap","ababababaq","ababababar","ababababas","ababababat","ababababau","ababababav","ababababaw","ababababax","ababababay","ababababaz","ababababba","ababababbb","ababababbc","ababababbd","ababababbe","ababababbf","ababababbg","ababababbh","ababababbi","ababababbj","ababababbk","ababababbl","ababababbm","ababababbn","ababababbo","ababababbp","ababababbq","ababababbr","ababababbs","ababababbt","ababababbu","ababababbv","ababababbw","ababababbx","ababababby","ababababbz","ababababca","ababababcb","ababababcc","ababababcd","ababababce","ababababcf","ababababcg","ababababch","ababababci","ababababcj","ababababck","ababababcl","ababababcm","ababababcn","ababababco","ababababcp","ababababcq","ababababcr","ababababcs","ababababct","ababababcu","ababababcv","ababababcw","ababababcx","ababababcy","ababababcz","ababababda","ababababdb","ababababdc","ababababdd","ababababde","ababababdf","ababababdg","ababababdh","ababababdi","ababababdj","ababababdk","ababababdl","ababababdm","ababababdn","ababababdo","ababababdp","ababababdq","ababababdr","ababababds","ababababdt","ababababdu","ababababdv","ababababdw","ababababdx","ababababdy","ababababdz","ababababea","ababababeb","ababababec","ababababed","ababababee","ababababef","ababababeg","ababababeh","ababababei","ababababej","ababababek","ababababel","ababababem","ababababen","ababababeo","ababababep","ababababeq","ababababer","ababababes","ababababet","ababababeu","ababababev","ababababew","ababababex","ababababey","ababababez","ababababfa","ababababfb","ababababfc","ababababfd","ababababfe","ababababff","ababababfg","ababababfh","ababababfi","ababababfj","ababababfk","ababababfl","ababababfm","ababababfn","ababababfo","ababababfp","ababababfq","ababababfr","ababababfs","ababababft","ababababfu","ababababfv","ababababfw","ababababfx","ababababfy","ababababfz","ababababga","ababababgb","ababababgc","ababababgd","ababababge","ababababgf","ababababgg","ababababgh","ababababgi","ababababgj","ababababgk","ababababgl","ababababgm","ababababgn","ababababgo","ababababgp","ababababgq","ababababgr","ababababgs","ababababgt","ababababgu","ababababgv","ababababgw","ababababgx","ababababgy","ababababgz","ababababha","ababababhb","ababababhc","ababababhd","ababababhe","ababababhf","ababababhg","ababababhh","ababababhi","ababababhj","ababababhk","ababababhl","ababababhm","ababababhn","ababababho","ababababhp","ababababhq","ababababhr","ababababhs","ababababht","ababababhu","ababababhv","ababababhw","ababababhx","ababababhy","ababababhz","ababababia","ababababib","ababababic","ababababid","ababababie","ababababif","ababababig","ababababih","ababababii","ababababij","ababababik","ababababil","ababababim","ababababin","ababababio","ababababip","ababababiq","ababababir","ababababis","ababababit","ababababiu","ababababiv","ababababiw","ababababix","ababababiy","ababababiz","ababababja","ababababjb","ababababjc","ababababjd","ababababje","ababababjf","ababababjg","ababababjh","ababababji","ababababjj","ababababjk","ababababjl","ababababjm","ababababjn","ababababjo","ababababjp","ababababjq","ababababjr","ababababjs","ababababjt","ababababju","ababababjv","ababababjw","ababababjx","ababababjy","ababababjz","ababababka","ababababkb","ababababkc","ababababkd","ababababke","ababababkf","ababababkg","ababababkh","ababababki","ababababkj","ababababkk","ababababkl","ababababkm","ababababkn","ababababko","ababababkp","ababababkq","ababababkr","ababababks","ababababkt","ababababku","ababababkv","ababababkw","ababababkx","ababababky","ababababkz","ababababla","abababablb","abababablc","ababababld","abababable","abababablf","abababablg","abababablh","ababababli","abababablj","abababablk","ababababll","abababablm","ababababln","abababablo","abababablp","abababablq","abababablr","ababababls","abababablt","abababablu","abababablv","abababablw","abababablx","abababably","abababablz","ababababma","ababababmb","ababababmc","ababababmd","ababababme","ababababmf","ababababmg","ababababmh","ababababmi","ababababmj","ababababmk","ababababml","ababababmm","ababababmn","ababababmo","ababababmp","ababababmq","ababababmr","ababababms","ababababmt","ababababmu","ababababmv","ababababmw","ababababmx","ababababmy","ababababmz","ababababna","ababababnb","ababababnc","ababababnd","ababababne","ababababnf","ababababng","ababababnh","ababababni","ababababnj","ababababnk","ababababnl","ababababnm","ababababnn","ababababno","ababababnp","ababababnq","ababababnr","ababababns","ababababnt","ababababnu","ababababnv","ababababnw","ababababnx","ababababny","ababababnz","ababababoa","ababababob","ababababoc","ababababod","ababababoe","ababababof","ababababog","ababababoh","ababababoi","ababababoj","ababababok","ababababol","ababababom","ababababon","ababababoo","ababababop","ababababoq","ababababor","ababababos","ababababot","ababababou","ababababov","ababababow","ababababox","ababababoy","ababababoz","ababababpa","ababababpb","ababababpc","ababababpd","ababababpe","ababababpf","ababababpg","ababababph","ababababpi","ababababpj","ababababpk","ababababpl","ababababpm","ababababpn","ababababpo","ababababpp","ababababpq","ababababpr","ababababps","ababababpt","ababababpu","ababababpv","ababababpw","ababababpx","ababababpy","ababababpz","ababababqa","ababababqb","ababababqc","ababababqd","ababababqe","ababababqf","ababababqg","ababababqh","ababababqi","ababababqj","ababababqk","ababababql","ababababqm","ababababqn","ababababqo","ababababqp","ababababqq","ababababqr","ababababqs","ababababqt","ababababqu","ababababqv","ababababqw","ababababqx","ababababqy","ababababqz","ababababra","ababababrb","ababababrc","ababababrd","ababababre","ababababrf","ababababrg","ababababrh","ababababri","ababababrj","ababababrk","ababababrl","ababababrm","ababababrn","ababababro","ababababrp","ababababrq","ababababrr","ababababrs","ababababrt","ababababru","ababababrv","ababababrw","ababababrx","ababababry","ababababrz","ababababsa","ababababsb","ababababsc","ababababsd","ababababse","ababababsf","ababababsg","ababababsh","ababababsi","ababababsj","ababababsk","ababababsl","ababababsm","ababababsn","ababababso","ababababsp","ababababsq","ababababsr","ababababss","ababababst","ababababsu","ababababsv","ababababsw","ababababsx","ababababsy","ababababsz","ababababta","ababababtb","ababababtc","ababababtd","ababababte","ababababtf","ababababtg","ababababth","ababababti","ababababtj","ababababtk","ababababtl","ababababtm","ababababtn","ababababto","ababababtp","ababababtq","ababababtr","ababababts","ababababtt","ababababtu","ababababtv","ababababtw","ababababtx","ababababty","ababababtz","ababababua","ababababub","ababababuc","ababababud","ababababue","ababababuf","ababababug","ababababuh","ababababui","ababababuj","ababababuk","ababababul","ababababum","ababababun","ababababuo","ababababup","ababababuq","ababababur","ababababus","ababababut","ababababuu","ababababuv","ababababuw","ababababux","ababababuy","ababababuz","ababababva","ababababvb","ababababvc","ababababvd","ababababve","ababababvf","ababababvg","ababababvh","ababababvi","ababababvj","ababababvk","ababababvl","ababababvm","ababababvn","ababababvo","ababababvp","ababababvq","ababababvr","ababababvs","ababababvt","ababababvu","ababababvv","ababababvw","ababababvx","ababababvy","ababababvz","ababababwa","ababababwb","ababababwc","ababababwd","ababababwe","ababababwf","ababababwg","ababababwh","ababababwi","ababababwj","ababababwk","ababababwl","ababababwm","ababababwn","ababababwo","ababababwp","ababababwq","ababababwr","ababababws","ababababwt","ababababwu","ababababwv","ababababww","ababababwx","ababababwy","ababababwz","ababababxa","ababababxb","ababababxc","ababababxd","ababababxe","ababababxf","ababababxg","ababababxh","ababababxi","ababababxj","ababababxk","ababababxl","ababababxm","ababababxn","ababababxo","ababababxp","ababababxq","ababababxr","ababababxs","ababababxt","ababababxu","ababababxv","ababababxw","ababababxx","ababababxy","ababababxz","ababababya","ababababyb","ababababyc","ababababyd","ababababye","ababababyf","ababababyg","ababababyh","ababababyi","ababababyj","ababababyk","ababababyl","ababababym","ababababyn","ababababyo","ababababyp","ababababyq","ababababyr","ababababys","ababababyt","ababababyu","ababababyv","ababababyw","ababababyx","ababababyy","ababababyz","ababababza","ababababzb","ababababzc","ababababzd","ababababze","ababababzf","ababababzg","ababababzh","ababababzi","ababababzj","ababababzk","ababababzl","ababababzm","ababababzn","ababababzo","ababababzp","ababababzq","ababababzr","ababababzs","ababababzt","ababababzu","ababababzv","ababababzw","ababababzx","ababababzy","ababababzz"};

        List<String> answer = findWords(board1, words1); // expected "oath" "eat"
        printList(answer);

        System.out.println("@@@@@@@@@@@@@@@@@@@@@");

        answer = findWords(board2, words2); // expected empty
        printList(answer);

        System.out.println("@@@@@@@@@@@@@@@@@@@@@");

        answer = findWords(board3, words3); // expected empty
        printList(answer);

        System.out.println("@@@@@@@@@@@@@@@@@@@@@");

        answer = findWords(board4, words4); // expected "ababababab"
        printList(answer);
    }

    public static void printList(List<String> list){
        for(String word : list){
            System.out.print("\""+word+"\" ");
        }
        System.out.println();
    }

    public static class Trie{
        Node root;

        public Trie(){
            this.root = new Node();
        }

        public void addWord(String word){
            Node cur = root;

            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);

                if(!cur.children.containsKey(c)){
                    cur.children.put(c, new Node());
                }

                cur = cur.children.get(c);
            }

            cur.endOfWord = true;
        }
    }

    public static class Node{
        boolean endOfWord;
        HashMap<Character, Node> children;

        public Node(){
            this.endOfWord = false;
            this.children = new HashMap<>();
        }
    }

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> answer = new ArrayList<>();
        Trie trie = new Trie();

        for(int i=0; i<words.length; i++){
            trie.addWord(words[i]);
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(trie.root.children.containsKey(board[i][j])){
                    boolean[][] visitedArray = new boolean[board.length][board[i].length];
                    visitedArray[i][j] = true;
                    depthFirstSearch(answer, board, visitedArray, new StringBuilder(), trie.root.children.get(board[i][j]), i, j);
                }
            }
        }

        return answer;
    }

    public static void depthFirstSearch(List<String> answer, char[][] board, boolean[][] visitedArray, StringBuilder newWord, Node currentNode, int i, int j){
        StringBuilder sbCopy = new StringBuilder(newWord.toString());
        sbCopy.append(board[i][j]);

        if(currentNode.endOfWord){
            currentNode.endOfWord = false;
            answer.add(sbCopy.toString());
        }

        if(i+1 < board.length){
            if(currentNode.children.containsKey(board[i+1][j]) && visitedArray[i+1][j] == false){
                visitedArray[i+1][j] = true;
                depthFirstSearch(answer, board, visitedArray, sbCopy, currentNode.children.get(board[i+1][j]), i+1, j);
                visitedArray[i+1][j] = false;
            }      
        }

        if(i-1 >= 0){
            if(currentNode.children.containsKey(board[i-1][j]) && visitedArray[i-1][j] == false){
                visitedArray[i-1][j] = true;
                depthFirstSearch(answer, board, visitedArray, sbCopy, currentNode.children.get(board[i-1][j]), i-1, j);
                visitedArray[i-1][j] = false;
            }
        }

        if(j+1 < board[i].length){
            if(currentNode.children.containsKey(board[i][j+1]) && visitedArray[i][j+1] == false){
                visitedArray[i][j+1] = true;
                depthFirstSearch(answer, board, visitedArray, sbCopy, currentNode.children.get(board[i][j+1]), i, j+1);
                visitedArray[i][j+1] = false;
            }
        }

        if(j-1 >= 0){
            if(currentNode.children.containsKey(board[i][j-1]) && visitedArray[i][j-1] == false){
                visitedArray[i][j-1] = true;
                depthFirstSearch(answer, board, visitedArray, sbCopy, currentNode.children.get(board[i][j-1]), i, j-1);
                visitedArray[i][j-1] = false;
            }
        }
    }
}
