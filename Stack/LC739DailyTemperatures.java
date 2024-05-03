import java.util.ArrayDeque;
import java.util.Stack;

class DailyTemperatures {
    public static void main(String[] args) {
        int[] testcase1 = {73,74,75,71,69,72,76,73};
        int[] testcase2 = {30,40,50,60};
        int[] testcase3 = {30,60,90};

        dailyTemperaturesClever(testcase1);
        dailyTemperaturesClever(testcase2);
        dailyTemperaturesClever(testcase3);
    }

    public static class Measurement{
        int temperature;
        int index;

        public Measurement(int temperature, int index){
            this.temperature = temperature;
            this.index = index;
        }
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Measurement> stack = new Stack<>();
        int[] answer = new int[temperatures.length];

        for(int i=0; i<temperatures.length; i++){

            if(!stack.empty()){
                Measurement previous = stack.peek();

                while(temperatures[i] > previous.temperature){
                    stack.pop();
                    answer[previous.index] = i - previous.index;

                    if(stack.empty()){
                        break;
                    }
                    previous = stack.peek();
                }
            }

            stack.push(new Measurement(temperatures[i], i));
        }

        while(!stack.empty()){
            Measurement current = stack.pop();
            answer[current.index] = 0;
        }

        for(int num : answer){
            System.out.print(num + " ");
        }
        System.out.println();

        return answer;
    }

    public static int[] dailyTemperaturesClever(int[] temperatures) {
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        int[] answer = new int[temperatures.length];

        for(int i=0; i<temperatures.length; i++){
            if(!stack.isEmpty()){
                while(temperatures[i] > temperatures[stack.peek()]){
                    answer[stack.peek()] = i - stack.peek();
                    stack.pop();

                    if(stack.isEmpty()){
                        break;
                    }
                }
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int current = stack.pop();
            answer[current] = 0;
        }

        for(int num : answer){
            System.out.print(num + " ");
        }
        System.out.println();

        return answer;
    }
}