import java.util.Stack;

class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] testecase1 = {"2","1","+","3","*"};
        String[] testecase2 = {"4","13","5","/","+"};
        String[] testecase3 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        String[] testecase4 = {"4","3","-"};

        System.out.println(evalRPN(testecase1));
        System.out.println(evalRPN(testecase2));
        System.out.println(evalRPN(testecase3));
        System.out.println(evalRPN(testecase4));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token : tokens){
            switch(token){
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int b = stack.pop();
                    int a = stack.pop();

                    stack.push(a - b);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int d = stack.pop();
                    int c = stack.pop();

                    stack.push(c / d);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }

        return stack.pop();
    }
}
