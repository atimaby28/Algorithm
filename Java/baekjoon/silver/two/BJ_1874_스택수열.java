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

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        String result = solution(n, array);

        bw.write(result + "\n");

        bw.flush();

        br.close();
        bw.close();
    }

    private static String solution(int n, int[] array) {

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int k = 1;

        for (int i = 0; i < array.length; i++) {
            int target = array[i];

            System.out.println(target + " " + k);
            System.out.println(stack + " " + target);

           if(target >= k) {
               while (stack.isEmpty() || target >= k) {
                   stack.push(k++);
                   sb.append('+');
               }
           } else {
               while (!stack.isEmpty() && stack.peek() >= target) {
                   stack.pop();
                   sb.append('-');
               }
           }

        }

        return sb.toString();
    }
}
