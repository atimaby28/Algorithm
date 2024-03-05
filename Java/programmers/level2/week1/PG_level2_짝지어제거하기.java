package level2.week1;

import java.io.*;
import java.util.Stack;

public class PG_level2_짝지어제거하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int result = solution(s);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(String s) {
        int answer = -1;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(stack.isEmpty()) {
                stack.push(c);
            } else if(stack.peek() != s.charAt(i)) {
                stack.push(c);
            } else if(stack.peek() == s.charAt(i)) {
                stack.pop();
            }
        }

        if(stack.isEmpty()) {
            answer = 1;
        } else {
            answer = 0;
        }

        return answer;
    }

}
