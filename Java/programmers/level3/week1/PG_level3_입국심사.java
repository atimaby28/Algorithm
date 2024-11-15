package level3.week1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level3_입국심사 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] times = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < times.length; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        long result = solution(n, times);

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    public static long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);

        long leftIdx = 0;
        long rightIdx = times[times.length - 1] * (long) n;

        while (leftIdx <= rightIdx) {
            long midIdx = (leftIdx + rightIdx) / 2;
            long totalTime = 0;

            for (int i = 0; i < times.length; i++) {
                totalTime += midIdx / times[i];
            }

            // 해당 시간에는 모든 사람이 검사받을 수 없다.
            if(totalTime < n) {
                leftIdx = midIdx + 1;
            // 모두 검사받았으나, 더 최솟값이 있을 수 있다.
            } else {
                rightIdx = midIdx - 1;
                answer = midIdx;
            }

            /*
            totalTime == n 이 없는 이유는 딱 맞아떨어지게 같은 경우가 없을 수도 있고
            여분의 시간이 남은 채로 모두 심사하는게 최선의 선택일 수도 있기 때문이다.
            따라서 totalTime >= n일 경우에 answer에 값을 저장해준 후, right의 범위를 줄여보며 더 빠른 시간이 있으면
            answer를 바꿔주고, 없다면 반복문을 빠져나와(leftIdx > rightIdx인 경우) 로직이 끝나게 된다.
             */

        }

        return answer;
    }

}
