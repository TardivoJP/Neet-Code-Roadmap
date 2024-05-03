import java.util.HashSet;

class ValidSudoku {
    public static void main(String[] args){
        char[][] testcase1 = {{'5','3','.','.','7','.','.','.','.'}
                             ,{'6','.','.','1','9','5','.','.','.'}
                             ,{'.','9','8','.','.','.','.','6','.'}
                             ,{'8','.','.','.','6','.','.','.','3'}
                             ,{'4','.','.','8','.','3','.','.','1'}
                             ,{'7','.','.','.','2','.','.','.','6'}
                             ,{'.','6','.','.','.','.','2','8','.'}
                             ,{'.','.','.','4','1','9','.','.','5'}
                             ,{'.','.','.','.','8','.','.','7','9'}};

        char[][] testcase2 = {{'8','3','.','.','7','.','.','.','.'}
                             ,{'6','.','.','1','9','5','.','.','.'}
                             ,{'.','9','8','.','.','.','.','6','.'}
                             ,{'8','.','.','.','6','.','.','.','3'}
                             ,{'4','.','.','8','.','3','.','.','1'}
                             ,{'7','.','.','.','2','.','.','.','6'}
                             ,{'.','6','.','.','.','.','2','8','.'}
                             ,{'.','.','.','4','1','9','.','.','5'}
                             ,{'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValidSudoku(testcase1));
        System.out.println(isValidSudoku(testcase2));
    }


    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character>[][] boxes = new HashSet[3][3];
        HashSet<Character>[] colSets = new HashSet[9];

        Character.getNumericValue(0);

        for(int i=0; i<9; i++){
            HashSet<Character> rowSet = new HashSet<>();
            
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){
                    continue;
                }

                if(boxes[i / 3][j / 3] == null){
                    boxes[i / 3][j / 3] = new HashSet<>();
                    boxes[i / 3][j / 3].add(board[i][j]);
                }else if(!boxes[i / 3][j / 3].contains(board[i][j])){
                    boxes[i / 3][j / 3].add(board[i][j]);
                }else{
                    return false;
                }

                if(!rowSet.contains(board[i][j])){
                    rowSet.add(board[i][j]);
                }else{
                    return false;
                }

                if(colSets[j] == null){
                    colSets[j] = new HashSet<>();
                    colSets[j].add(board[i][j]);
                }else if(!colSets[j].contains(board[i][j])){
                    colSets[j].add(board[i][j]);
                }else{
                    return false;
                }
            }
        }

        return true;
    }
}
