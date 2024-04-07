package level2.week3;

import java.io.*;
import java.util.Stack;

public class PG_level2_괄호변환 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String p = br.readLine();

        String result = solution(p);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(String p) {
        String answer = "";

        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if(p.equals("")) {
            return p;
        }

        // 2. 문자열 p를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다.
        int left = 0, right = 0, index = 0;
        for (int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(') {
                left++;
            } else if(p.charAt(i) == ')') {
                right++;
            }

            if(left == right) {
                index = i + 1;
                break;
            }
        }
        String u = p.substring(0, index);
        String v = p.substring(index);

        // 3. 문자열 u가 "올바른 괄호 문자열"이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
        // 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
        if(isCorrect(u)) {
            return u + solution(v);
        }

        // 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
        // 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
        // 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
        // 4-3. ')'를 다시 붙입니다.
        // 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.

        answer = "(" + solution(v) + ")" + reverse(u);

        return answer;
    }
    private static boolean isCorrect(String u) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < u.length(); i++) {
            if(u.charAt(i) == '(') {
                stack.push(u.charAt(i));
            } else {
                if(stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        if(!stack.isEmpty()) {
            return false;
        }

        return true;
    }

    private static String reverse(String u) {
        u = u.substring(1, u.length() - 1);

        String newStr = "";
        for (int i = 0; i < u.length(); i++) {
            if(u.charAt(i) == '(') {
                newStr += ')';
            } else {
                newStr += '(';
            }
        }

        return newStr;
    }


}
