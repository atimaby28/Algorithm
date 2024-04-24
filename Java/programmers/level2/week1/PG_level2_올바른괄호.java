package level2.week1;

import java.io.*;
import java.util.Stack;

public class PG_level2_올바른괄호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        boolean result = solution(s);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    static boolean solution(String s) {
        boolean answer = true;

        answer = isStack(s);

        return answer;
    }

    private static boolean isStack(String s) {
        if(s.charAt(0) == ')' || s.charAt(s.length() - 1) == '(') {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push('(');
            } else if(!stack.isEmpty() && s.charAt(i) == ')'){
                return false;
            } else {
                stack.pop();
            }
        }

        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
