package level3.week1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PG_level3_최고의집합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int s = Integer.parseInt(st.nextToken());

        int[] result = solution(n, s);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(int n, int s) {
        int[] answer = {};

        if(n <= s) {

            answer = new int[n];

            for(int i = 0; i < answer.length; i++) {
                int digitVal = s / n--;
                answer[i] = digitVal;
                s -= digitVal;
            }

        } else {
            answer = new int[]{-1};
        }

        return answer;
    }
}
