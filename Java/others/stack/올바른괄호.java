package stack;

import java.io.*;
import java.util.Stack;

public class 올바른괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        String result = solution(str);

        bw.write(result);

        bw.flush();

        br.close();
        bw.close();
    }

    private static String solution(String str) {
        String answer = "No";

        Stack<Character> stack = new Stack<>();

        if(str.charAt(0) == ')') return answer;

//        for (int i = 0; i < str.length(); i++) {
//            if(str.charAt(i) == '(') stack.push(str.charAt(i));
//            else stack.pop();
//        }

        for (char c : str.toCharArray()) {
            if(c == '(') stack.push(c);
            else stack.pop();
        }

        if(stack.isEmpty()) return "Yes";

        return answer;
    }
}
