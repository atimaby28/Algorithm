package silver.five;

import java.io.*;

public class BJ_2018_수들의합5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int result = solution(n);

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    private static int solution(int n) {
        int answer = 0;

        // 투 포인터 초기화
        int left = 0, right = 0;
        int sum = 0;

        while (right <= n) {
            if (sum < n) {
                // 현재 합이 작으면 오른쪽 포인터 이동
                sum += ++right;
            } else if (sum > n) {
                // 현재 합이 크면 왼쪽 포인터 이동
                sum -= ++left;
            } else {
                // 합이 N과 같으면 카운트 증가
                answer++;
                sum += ++right;
            }
        }

        return answer;
    }
}
