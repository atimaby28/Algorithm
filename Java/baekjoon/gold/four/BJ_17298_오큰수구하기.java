package gold.four;

import java.io.*;
import java.util.*;

public class BJ_17298_오큰수구하기 {
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

        String result = solution(array);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    private static String solution(int[] array) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int[] result = new int[array.length];

        Arrays.fill(result, -1);

        for (int i = 0; i < array.length; i++) {
            // 현재 원소가 스택의 top 값보다 크면, 오큰수 계산
            while (!stack.isEmpty() && array[stack.peek()] < array[i]) {
                result[stack.pop()] = array[i];
            }
            // 현재 원소의 인덱스를 스택에 넣음
            stack.push(i);
        }

        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]).append(" ");
        }

        return sb.toString().trim();
    }
}

