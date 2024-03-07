package level2.week1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PG_level2_괄호회전하기 {

    public static Stack<Character> stack;
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

        int count = 0;
        for (int i = 0; i < s.length(); i++) {

            stack = new Stack<>();

            for (int j = i; j < s.length() + i; j++) {
                char cha = s.charAt(j % s.length());

                if(stack.isEmpty() && (cha == ']' || cha == '}' || cha == ')')) {
                    stack.push('X');
                    break;
                } else if(cha == '[' || cha == '{' || cha == '(') {
                    stack.push(cha);
                } else if(cha == ']') {
                    if(stack.peek() == '[') {
                        stack.pop();
                    } else {
                        break;
                    }
                } else if(cha == '}') {
                    if(stack.peek() == '{') {
                        stack.pop();
                    } else {
                        break;
                    }
                } else if(cha == ')') {
                    if(stack.peek() == '(') {
                        stack.pop();
                    } else {
                        break;
                    }
                }

            }

            if(stack.isEmpty()) {
                count++;
            }
        }

        answer = count;

        return answer;
    }

}
