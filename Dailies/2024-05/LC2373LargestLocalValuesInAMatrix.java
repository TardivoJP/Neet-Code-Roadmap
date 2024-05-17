class LargestLocalValuesInAMatrix {
    public static void main(String[] args) {
        int[][] input1 = {{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}};
        int[][] input2 = {{1,1,1,1,1},{1,1,1,1,1},{1,1,2,1,1},{1,1,1,1,1},{1,1,1,1,1}};
        
        int[][] output;


        output = largestLocal(input1); // expected [[9,9],[8,6]]
        printArr(output);

        output = largestLocal(input2); // expected [[2,2,2],[2,2,2],[2,2,2]]
        printArr(output);
    }

    public static void printArr(int[][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] largestLocal(int[][] grid) {
        int[][] answer = new int[grid.length - 2][grid.length - 2];

        int left = 0;
        int up = 0;

        int right = 2;
        int down = 2;

        int localMax = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;

        int k = 0;
        int l = 0;

        while(down < grid.length){
            if(grid[i][j] > localMax){
                localMax = grid[i][j];
            }

            i++;
            if(i > down){
                i = up;
                j++;
                if(j > right){
                    left++;
                    i = up;
                    j = left;

                    answer[k][l] = localMax;
                    localMax = Integer.MIN_VALUE;
                    l++;
                    if(l >= answer[k].length){
                        k++;
                        l = 0;
                    }

                    right++;
                    if(right >= grid.length){
                        left = 0;
                        right = 2;
                        up++;
                        down++;
                        i = up;
                        j = left;
                    }
                }
            }
        }

        return answer;
    }
}