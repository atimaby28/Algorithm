package level0.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_카운트다운 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end_num = Integer.parseInt(st.nextToken());

        int[] result = solution(start, end_num);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }


    public static int[] solution(int start, int end_num) {
        int[] answer = new int[start - end_num + 1];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = start - i;
        }

        return answer;
    }

}
