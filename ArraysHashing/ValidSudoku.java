import java.util.HashSet;

public class ValidSudoku {
    public static void main(String[] args){
        char[][] board1 = 
        {{'5','3','.','.','7','.','.','.','.'}
        ,{'6','.','.','1','9','5','.','.','.'}
        ,{'.','9','8','.','.','.','.','6','.'}
        ,{'8','.','.','.','6','.','.','.','3'}
        ,{'4','.','.','8','.','3','.','.','1'}
        ,{'7','.','.','.','2','.','.','.','6'}
        ,{'.','6','.','.','.','.','2','8','.'}
        ,{'.','.','.','4','1','9','.','.','5'}
        ,{'.','.','.','.','8','.','.','7','9'}};

        char[][] board2 = 
        {{'8','3','.','.','7','.','.','.','.'}
        ,{'6','.','.','1','9','5','.','.','.'}
        ,{'.','9','8','.','.','.','.','6','.'}
        ,{'8','.','.','.','6','.','.','.','3'}
        ,{'4','.','.','8','.','3','.','.','1'}
        ,{'7','.','.','.','2','.','.','.','6'}
        ,{'.','6','.','.','.','.','2','8','.'}
        ,{'.','.','.','4','1','9','.','.','5'}
        ,{'.','.','.','.','8','.','.','7','9'}};

        boolean result1 = isValidSudoku(board1);
        boolean result2 = isValidSudoku(board2);

        System.out.println(result1);
        System.out.println(result2);
    }

    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rowSet = new HashSet[9];
        HashSet<Character>[] columnSet = new HashSet[9];
        
        for(int i=0;i<9;i++){
            rowSet[i] = new HashSet<Character>();
            columnSet[i] = new HashSet<Character>();
        }

        HashSet<Character>[][] boxSet = new HashSet[3][3];

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                boxSet[i][j] = new HashSet<Character>();
            }
        }
        

        int boxRow = 0, countRow = 0;
        int boxColumn = 0, countColumn = 0;

        for(int i=0;i<9;i++){
            if(countRow==3){
                countRow=0;
                boxRow++;
            }
            boxColumn = 0;
            countColumn = 0;
            for(int j=0;j<9;j++){
                if(countColumn==3){
                    countColumn=0;
                    boxColumn++;
                }
                
                if(board[i][j] != '.'){
                    if(rowSet[i].contains(board[i][j])){
                        return false;
                    }else{
                        rowSet[i].add(board[i][j]);
                    }

                    if(columnSet[j].contains(board[i][j])){
                        return false;
                    }else{
                        columnSet[j].add(board[i][j]);
                    }

                    if(boxSet[boxRow][boxColumn].contains(board[i][j])){
                        return false;
                    }else{
                        boxSet[boxRow][boxColumn].add(board[i][j]);
                    }
                }

                countColumn++;
            }

            countRow++;
        }

        return true;
    }
}