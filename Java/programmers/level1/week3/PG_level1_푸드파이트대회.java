package level1.week3;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class PG_level1_푸드파이트대회 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int p = Integer.parseInt(br.readLine());

        int[] food = new int[p];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < food.length; i++) {
            food[i] = Integer.parseInt(st.nextToken());
        }

        String result = solution(food);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(int[] food) {
        String answer = "";

        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i < food.length; i++) {
            food[i] /= 2;
        }

        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i]; j++) {
                answer += i;
                stack.push(i);
            }
        }

        while(!stack.isEmpty()) {
            answer += stack.pop();
        }

        return answer;
    }

}
