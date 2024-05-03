class SearchA2DMatrix {

    public static void main(String[] args) {
        int[][] testcase1 = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target1 = 3;

        int[][] testcase2 = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target2 = 13;
        
        System.out.println(searchMatrix(testcase1, target1));
        System.out.println(searchMatrix(testcase2, target2));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int downPtr = 0;
        int upPtr = matrix.length - 1;
        int verticalMiddle = (upPtr - downPtr) / 2 + downPtr;
        int leftPtr = 0;
        int rightPtr = matrix[0].length - 1;
        int horizontalMiddle = (rightPtr - leftPtr) / 2 + leftPtr;

        while(downPtr <= upPtr){
            if(target >= matrix[verticalMiddle][0] && target <= matrix[verticalMiddle][matrix[0].length - 1]){
                while(leftPtr <= rightPtr){
                    if(target == matrix[verticalMiddle][horizontalMiddle]){
                        return true;
                    }else if(target > matrix[verticalMiddle][horizontalMiddle]){
                        leftPtr = horizontalMiddle + 1;
                        horizontalMiddle = (rightPtr - leftPtr) / 2 + leftPtr;
                    }else{
                        rightPtr = horizontalMiddle - 1;
                        horizontalMiddle = (rightPtr - leftPtr) / 2 + leftPtr;
                    }
                }
                return false;
            }else if(target > matrix[verticalMiddle][matrix[0].length - 1]){
                downPtr = verticalMiddle + 1;
                verticalMiddle = (upPtr - downPtr) / 2 + downPtr;
            }else{
                upPtr = verticalMiddle - 1;
                verticalMiddle = (upPtr - downPtr) / 2 + downPtr;
            }
        }

        return false;
    }
}