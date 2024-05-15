class LC861ScoreAfterFlippingMatrix {
    public static void main(String[] args) {
        int[][] input1 = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        int[][] input2 = {{0}};
        int[][] input3 = {{0,1,1},{1,1,1},{0,1,0}};
        
        
        System.out.println(matrixScore(input1)); // expected 39
        System.out.println(matrixScore(input2)); // expected 1
        System.out.println(matrixScore(input3)); // expected 18
    }

    public static int matrixScore(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
      
        for(int i=0; i<n; i++){
            if(grid[i][0] == 0){
                for(int j = 0; j < m; j++){
                    if(grid[i][j] == 0){
                        grid[i][j] = 1;
                    }else{
                        grid[i][j] = 0;
                    }
                }
            }
        }

        for(int j=0; j<m; j++){
            int zeroes = 0;
            
            for(int i=0; i<n; i++){
                if(grid[i][j] == 0){
                    zeroes++;
                }
            }
            
            if(zeroes > (n / 2)){
                for(int i=0; i<n; i++){
                    if(grid[i][j] == 0){
                        grid[i][j] = 1;
                    }else{
                        grid[i][j] = 0;
                    }
                }
            }
        }

        int answer = 0;

        for(int i=0; i<n; i++) {
            int binaryInt = 0;
        
            for(int j=0; j<m; j++) {
                binaryInt = (binaryInt << 1) | grid[i][j];
            }
        
            answer += binaryInt;
        }

        return answer;
    }
}