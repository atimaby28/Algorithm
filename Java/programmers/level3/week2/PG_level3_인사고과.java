package level3.week2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level3_인사고과 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());


        int[][] scores = new int[p][q];

        for (int i = 0; i < scores.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < scores[0].length; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int result = solution(scores);

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    public static int solution(int[][] scores) {
        int answer = 1; // 완호의 초기 석차를 1등으로 설정

        int[] s = scores[0];

        // 첫 번째 원소를 기준으로 내림차순 s2[0] - s1[0]
        // 첫 번째 원소가 같다면 두 번째 원소를 기준으로 오름차순 s1[1] - s2[1]
        Arrays.sort(scores, (s1, s2) -> s1[0] == s2[0] ? s1[1] - s2[1] : s2[0] - s1[0]);

        int maxScore = 0;

        for (int[] score : scores) {
            if (score[1] < maxScore) { // 두 점수가 모두 낮은 사원으로 간주, 인센티브를 받지 못함
                if (Arrays.equals(score, s)) // 그 점수 중 완호의 점수와 같은 사원이 있다면, 역시 인센티브를 받지 못함
                    return -1;
            } else { // 정렬 되었으므로 이미 근무 평가는 낮지만 동료 평가가 높을 수 있으므로 확인
                maxScore = score[1];
                if (s[0] + s[1] < score[0] + score[1])
                    answer++;
            }
        }
        return answer;
    }
}
