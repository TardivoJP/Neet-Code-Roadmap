import java.util.ArrayList;
import java.util.List;

class GenerateParenthesis {
    public static void main(String[] args) {
        generateParenthesis(3);
    }

    public static void generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();

        generate("(", 1, 0, n, answer);

        System.out.println(answer);
    }

    public static void generate(String cur, int open, int closed, int n, List<String> answer){
        if(open > n || closed > n){
            return;
        }

        if(open == n && closed == n){
            answer.add(cur);
        }

        if(closed < open){
            generate(cur + ")", open, closed+1, n, answer);
        }

        generate(cur + "(", open+1, closed, n, answer);
    }
}
