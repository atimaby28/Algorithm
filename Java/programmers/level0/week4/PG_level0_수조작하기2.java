package level0.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_수조작하기2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[] strArr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = Integer.parseInt(st.nextToken());
        }

        String result = solution(strArr);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(int[] numLog) {
        String answer = "";

        for (int i = 0; i < numLog.length - 1; i++) {
            if(numLog[i + 1] - numLog[i] == 1) {
                answer += "w";
            } else if (numLog[i + 1] - numLog[i] == -1) {
                answer += "s";
            } else if (numLog[i + 1] - numLog[i] == 10) {
                answer += "d";
            } else if (numLog[i + 1] - numLog[i] == -10) {
                answer += "a";
            }
        }

        return answer;
    }
}
