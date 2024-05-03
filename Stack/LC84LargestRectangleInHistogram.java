import java.util.ArrayDeque;

class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] testcase1 = {2,1,5,6,2,3};
        int[] testcase2 = {2,4,4};
        int[] testcase3 = {2,1,5,6,2,3,2,2};
        int[] testcase4 = {1};

        System.out.println(largestRectangleArea(testcase1));
        System.out.println(largestRectangleArea(testcase2));
        System.out.println(largestRectangleArea(testcase3));
        System.out.println(largestRectangleArea(testcase4));
    }

    public static class Rectangle{
        int index;
        int height;

        public Rectangle(int index, int height){
            this.index = index;
            this.height = height;
        }
    }

    public static int largestRectangleArea(int[] heights) {
        ArrayDeque<Rectangle> stack = new ArrayDeque<>();

        int maxRectangle = 0;

        for(int i=0; i<heights.length; i++){
            int startIndex = i;

            if(!stack.isEmpty()){

                Rectangle previous = stack.peek();

                while(heights[i] < previous.height){
                    stack.pop();

                    int previousArea = (i - previous.index) * previous.height;
                    startIndex = previous.index;
                    
                    if(previousArea > maxRectangle){
                        maxRectangle = previousArea;
                    }
                    
                    if(stack.isEmpty()){
                        break;
                    }
                    previous = stack.peek();
                }
            }

            stack.push(new Rectangle(startIndex, heights[i]));
        }

        while(!stack.isEmpty()){
            Rectangle curr = stack.poll();

            int currArea = (heights.length - curr.index) * curr.height;
            
            if(currArea > maxRectangle){
                maxRectangle = currArea;
            }
        }

        return maxRectangle;
    }
}