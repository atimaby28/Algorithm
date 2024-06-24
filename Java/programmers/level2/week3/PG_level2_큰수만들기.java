package level2.week3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PG_level2_큰수만들기 {

    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String number = br.readLine();
        int k = Integer.parseInt(br.readLine());

        String result = solution(number, k);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

//    Testcase 10번 시간 초과 O(n^2)
//    public static String solution(String number, int k) {
//        String answer = "";
//
//        int len = number.length() - k;
//
//        int start = 0;
//        for (int i = 0; i < len; i++) {
//            char max = '0';
//            for (int j = start; j <= i + k; j++) {
//                if(max < number.charAt(j)) {
//                    max = number.charAt(j);
//                    start = j + 1;
//                }
//            }
//            answer += max;
//        }
//
//        return answer;
//    }

//    public static String solution(String number, int k) {
//        String answer = "";
//
//        Stack<Character> stack = new Stack<>();
//        StringBuilder sb = new StringBuilder();
//
//        int len = number.length() - k;
//
//        int i = 0;
//        while (k > 0 && i < number.length()) {
//            char digit = number.charAt(i);
//            while (!stack.isEmpty() && k > 0 && stack.peek() < digit) {
//                stack.pop();
//                k--;
//            }
//            stack.push(digit);
//            i++;
//        }
//
//        while (!stack.isEmpty()) sb.append(stack.pop());
//
//
//        System.out.println(sb);
//
////        answer = sb.reverse() + number.substring(i);
//        answer = sb.reverse().substring(0, len);
//
//        return answer;
//    }

    public static String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }

            stack.push(c);
            
            if (k < 0 && stack.size() == result.length)
                break;
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }

}
