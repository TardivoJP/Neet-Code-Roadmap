import java.util.Stack;

class ValidParentheses {
    public static void main(String[] args){
        String testcase1 = "()";
        String testcase2 = "()[]{}";
        String testcase3 = "(]";
        String testcase4 = "([)]";
        String testcase5 = "([])";
        String testcase6 = "]";

        System.out.println(isValid(testcase1));
        System.out.println(isValid(testcase2));
        System.out.println(isValid(testcase3));
        System.out.println(isValid(testcase4));
        System.out.println(isValid(testcase5));
        System.out.println(isValid(testcase6));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char cur = s.charAt(i);

            if(cur == '(' || cur == '[' || cur == '{'){
                stack.push(cur);
            }

            if(cur == ')' || cur == ']' || cur == '}'){
                if(stack.isEmpty()){
                    return false;
                }

                char top = stack.pop();
                if(top == '(' && cur != ')' || top == '[' && cur != ']' || top == '{' && cur != '}'){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
