import java.util.ArrayList;
import java.util.List;

//no main function with tests inputs in this one because
//List<List<Integer>> are kind of annoying to work with compared to int[][]

class LC2812FindTheSafestPathInAGrid {
  public static int[] nextX = {1,-1,0,0};
  public static int[] nextY = {0,0,1,-1};
  public static int maxSafeness = 0;
  
  public static int maximumSafenessFactor(List<List<Integer>> grid) {
        int m = grid.size() - 1;
        int n = grid.get(0).size() - 1;
        
        int[][] safetyArr = new int[m+1][n+1];
        for(int i=0; i<m+1; i++){
          for(int j=0; j<n+1; j++){
            safetyArr[i][j] = Integer.MAX_VALUE;
          }
        }

        ArrayList<int[]> thieves = new ArrayList<>();
        boolean[][] visited = new boolean[m+1][n+1];
        
        for(int i=0; i<m+1; i++){
          for(int j=0; j<n+1; j++){
            if(grid.get(i).get(j) == 1){
              thieves.add(new int[]{i, j});
              visited[i][j] = true;
            }
          }
        }
        bfsThieves(grid, visited, safetyArr, thieves, 0, m, n);

        int start = 0;
        int end = maxSafeness;
        int answer = 0;

        while(start <= end){
          int mid = (start + end) / 2;

          if(isValidSafeness(grid, safetyArr, mid, m, n)){
            answer = Math.max(answer, mid);
            start = mid + 1;
          }else{
            end = mid - 1;
          }
        }

        return answer;
  }

  public static boolean isValidSafeness(List<List<Integer>> grid, int[][] safetyArr, int safeness, int m, int n){
    if(safetyArr[0][0] < safeness || safetyArr[m][n] < safeness){
      return false;
    }
    
    ArrayList<int[]> queue = new ArrayList<>();
    boolean[][] visited = new boolean[grid.size()][grid.get(0).size()];

    queue.add(new int[]{0, 0, safetyArr[0][0]});
    visited[0][0] = true;

    while(queue.size() != 0){
      int[] cur = queue.get(0);
      queue.remove(0);

      if(cur[0] == m && cur[1] == n){
        return true;
      }

      for(int i=0; i<4; i++){
        int curX = cur[0] + nextX[i];
        int curY = cur[1] + nextY[i];
        
        if(isValid(curX, curY, m, n)){
          if(visited[curX][curY] == false && safetyArr[curX][curY] >= safeness){
            visited[curX][curY] = true;
            queue.add(new int[]{curX, curY, safetyArr[curX][curY]});
          }
        }
      }
    }

    return false;
  }
  
  public static boolean isValid(int x, int y, int m, int n){
    if(x < 0 || y < 0 || x > m || y > n){
      return false;
    }
    return true;
  }

  public static void bfsThieves(List<List<Integer>> grid, boolean[][] visited, int[][]safetyArr, ArrayList<int[]> currentIteration, int depth, int m, int n){
    if(currentIteration.size() == 0){
      return;
    }

    maxSafeness = Math.max(maxSafeness, depth);

    ArrayList<int[]> nextIteration = new ArrayList<>();

    for(int[] coord : currentIteration){
      if(safetyArr[coord[0]][coord[1]] > depth){
        safetyArr[coord[0]][coord[1]] = depth;
      }

      for(int i=0; i<4; i++){
        int curX = coord[0] + nextX[i];
        int curY = coord[1] + nextY[i];
        
        if(isValid(curX, curY, m, n)){
          if(visited[curX][curY] == false){
            visited[curX][curY] = true;
            nextIteration.add(new int[]{curX, curY});
          }
        }
      }
    }

    bfsThieves(grid, visited, safetyArr, nextIteration, depth + 1, m, n);
  }
}