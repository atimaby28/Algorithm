package bronze.one;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1546_평균 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        double result = solution(nums);

        bw.write(result + "\n");

        bw.flush();

        br.close();
        bw.close();
    }

    private static double solution(int[] nums) {
        double answer = 0;

        int maxScore = Arrays.stream(nums).max().orElseThrow();

        answer = Arrays.stream(nums).mapToDouble(n -> n / (double) maxScore).average().orElseThrow();

        return answer * 100;
    }
}
