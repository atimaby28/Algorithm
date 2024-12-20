package silver.two;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_1874_스택수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        String result = solution(array);

        bw.write(result + "\n");

        bw.flush();

        br.close();
        bw.close();
    }

    private static String solution(int[] array) {

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int k = 1;

        for (int num : array) {
            // 스택에 필요한 숫자까지 push
            while (k <= num) {
                stack.push(k++);
                sb.append("+").append("\n"); // push 연산
            }

            // 스택에서 pop하여 수열 구성
            if (!stack.isEmpty() && stack.peek() == num) {
                stack.pop();
                sb.append("-").append("\n"); // pop 연산
            } else {
                // 원하는 수열을 만들 수 없는 경우
                return "NO";
            }
        }

        return sb.toString();
    }
}
