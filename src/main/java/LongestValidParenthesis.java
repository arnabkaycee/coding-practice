import java.util.Stack;

public class LongestValidParenthesis {


    public static int longestValidParenthesis(String s) {
        int opened = 0;
        int closed = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':{
                    opened++;
                    break;
                }
                case ')': {
                    closed++;
                    break;
                }
            }
            if (opened == closed && opened > max) {
                max = closed - opened + 1;
                opened = closed = 0;
            }
            if (closed > opened){
                opened = closed = 0;
            }
        }
        opened = closed = 0;
        for (int i = s.length() - 1; i>=0; i--){
            switch (s.charAt(i)) {
                case ')':{
                    opened++;
                    break;
                }
                case '(': {
                    closed++;
                    break;
                }
            }
            if (opened == closed && opened > max) {
                max = closed - opened + 1;
                opened = closed = 0;
            }
            if (closed > opened){
                opened = closed = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "(()";
        System.out.println("asdfasdf");
        System.out.println(longestValidParenthesis(str));
    }

}
