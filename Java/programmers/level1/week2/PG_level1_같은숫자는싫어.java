package level1.week2;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class PG_level1_같은숫자는싫어 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solution(arr);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(int []arr) {
        int[] answer = {};

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if(st.isEmpty()) {
                st.add(arr[i]);
            } else if(st.peek() != arr[i]) {
                st.add(arr[i]);
            }
        }

        answer = new int[st.size()];

        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = st.pop();
        }

        return answer;

    }
}
