package level1.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level1_로또최고순위와최저순위 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int p = Integer.parseInt(br.readLine());

        int[] lottos = new int[p];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < lottos.length; i++) {
            lottos[i] = Integer.parseInt(st.nextToken());
        }

        int q = Integer.parseInt(br.readLine());

        int[] win_nums = new int[q];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < win_nums.length; i++) {
            win_nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solution(lottos, win_nums);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        boolean[] checkNum = new boolean[46];

        for (int i = 0; i < lottos.length; i++) {
            checkNum[lottos[i]] = true;
        }

        int correctCnt = 0;
        int zeroCount = 0;
        for (int i = 0; i < win_nums.length; i++) {
            if(checkNum[win_nums[i]] == true) {
                correctCnt++;
            }
            if(lottos[i] == 0) {
                zeroCount++;
            }
        }

        if(correctCnt >= 1 || zeroCount >= 1) {
            answer[0] = 6 - (correctCnt + zeroCount) + 1;
            answer[1] = 6 - correctCnt + 1;

            if(zeroCount == 6) {
                answer[1] = 6;
            }
        } else {
            answer[0] = 6;
            answer[1] = 6;
        }

        return answer;
    }

}
