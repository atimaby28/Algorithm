package level2.week4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level2_요격시스템 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());

        int[][] targets = new int[k][2];

        for (int i = 0; i < targets.length; i++) {
            st = new StringTokenizer(br.readLine());

            targets[i][0] = Integer.parseInt(st.nextToken());
            targets[i][1] = Integer.parseInt(st.nextToken());
        }

        int result = solution(targets);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    /*
    1. 처음 요격기의 값을 0으로 초기화한다.
    2. 끝점으로 오름차순 정렬된 미사일의 시작점을 요격기의 값과 비교한다.
        2-1. 미사일의 시작점 값이 요격기 값 이상일 때, 요격기의 값을 해당 미사일의 끝점으로 업데이트 시키고 요격기의 개수를 추가한다.
    3. 미사일 개수만큼 2의 과정을 반복한다.
     */
    public static int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);

        int before = 0;
        for (int i = 0; i < targets.length; i++) {
            if (before <= targets[i][0]) {
                before = targets[i][1];
                answer++;
            }
        }

        return answer;
    }

}

/*
7
4 5
4 8
10 14
11 13
5 12
3 7
1 4
 */