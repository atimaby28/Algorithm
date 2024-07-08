package level2.week3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class PG_level2_줄서는방법 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] result = solution(n, k);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(int n, long k) {
        int[] answer = new int[n];

        List<Integer> arrList = new ArrayList<>();

        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            arrList.add(i);
            factorial *= i;
        }

        k -= 1;

        int i = 0;
        while (!arrList.isEmpty()) {
            factorial /= (n - i);
            answer[i++] = arrList.remove((int) (k / factorial));
            k %= factorial;
        }

        return answer;
    }

}
