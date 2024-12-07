package silver.three;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_11659_구간합구하기4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] arrSum = new int[nums.length + 1];

        arrSum[0] = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            arrSum[i] = arrSum[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(solution(arrSum, start, end)).append("\n");
        }

        bw.write(sb + "\n");

        bw.flush();

        br.close();
        bw.close();
    }

    private static int solution(int[] arrSum, int start, int end) {
        int answer = 0;

        answer = arrSum[end] - arrSum[start - 1];

        return answer;
    }
}
