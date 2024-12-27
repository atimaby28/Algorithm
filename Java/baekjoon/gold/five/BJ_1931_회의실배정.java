package gold.five;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1931_회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] time = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        int result = solution(time);

        bw.write(result + "\n");

        bw.flush();

        bw.close();
        br.close();
    }

    private static int solution(int[][] time) {
        int answer = 1;

        // 끝나는 시간 기준 오름차순, 끝나는 시간이 같을경우 시작시간도 오름차순
        Arrays.sort(time, (t1, t2) -> {
            if(t1[1] == t2[1]) {
                return Integer.compare(t1[0], t2[0]);
            } else {
                return Integer.compare(t1[1], t2[1]);
            }
        });

        // 끝나는 시간보다 시작시간이 같거나 크다면 회의실 이용 가능
        int ns = time[0][1];
        for (int i = 1; i < time.length; i++) {
            if(ns <= time[i][0]) {
                ns = time[i][1];
                answer++;
            }
        }

        return answer;
    }
}
