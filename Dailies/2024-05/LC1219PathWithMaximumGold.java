class LC1219PathWithMaximumGold {
    public static void main(String[] args){
        int[][] input1 = {{0,6,0},{5,8,7},{0,9,0}};
        int[][] input2 = {{1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}};

        System.out.println(getMaximumGold(input1)); // expected 24
        System.out.println(getMaximumGold(input2)); // expected 28
    }

    public static int getMaximumGold(int[][] grid){
        int answer = 0;
        
        for(int i=0; i<grid.length; i++){
          for(int j=0; j<grid[i].length; j++){
            if(grid[i][j] != 0){
              answer = Math.max(answer, dfs(grid, i, j));    
            }
          }
        }
        
        return answer;
    }
    
    public static int dfs(int[][] grid, int x, int y){
      if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length){
        return 0;
      }
      
      if(grid[x][y] == 0){
        return 0;
      }
      
      int temp = grid[x][y];
      int total = temp;
      grid[x][y] = 0;
      
      total = Math.max(total, (temp + dfs(grid, x+1, y)));
      total = Math.max(total, (temp + dfs(grid, x-1, y)));
      total = Math.max(total, (temp + dfs(grid, x, y+1)));
      total = Math.max(total, (temp + dfs(grid, x, y-1)));
      
      grid[x][y] = temp;
      
      return total;
    }
}