package level3.week2;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level3_풍선터뜨리기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        long result = solution(a);

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }


    public static int solution(int[] a) {
        int answer = 0;

        int n = a.length;
        if (n <= 2) {
            return n; // 풍선이 2개 이하라면 모두 생존 가능
        }

        // 왼쪽과 오른쪽 최소값 배열 초기화
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];

        // 왼쪽 최소값 계산
        leftMin[0] = a[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], a[i]);
        }

        // 오른쪽 최소값 계산
        rightMin[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], a[i]);
        }

        // 생존 가능한 풍선 개수 계산
        for (int i = 0; i < n; i++) {
            if (a[i] <= leftMin[i] || a[i] <= rightMin[i]) {
                answer++;
            }
        }

        return answer;
    }

}
