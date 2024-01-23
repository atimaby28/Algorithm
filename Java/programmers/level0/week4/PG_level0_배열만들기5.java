package level0.week4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level0_배열만들기5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int x = Integer.parseInt(br.readLine());

        String[] intStrs = new String[x];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < intStrs.length; i++) {
            intStrs[i] = st.nextToken();
        }

        st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] result = solution(intStrs, k, s, l);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(String[] intStrs, int k, int s, int l) {
        int[] answer = {};

        for (int i = 0; i < intStrs.length; i++) {
            String temp = "";
            for (int j = s; j < s + l; j++) {
                temp += intStrs[i].charAt(j);
            }

            if(Integer.parseInt(temp) > k) {
                answer = Arrays.copyOf(answer, answer.length + 1);
                answer[answer.length - 1] = Integer.parseInt(temp);
            }
        }

        return answer;
    }

}
