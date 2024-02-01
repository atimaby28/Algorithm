package level0.week4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level0_문자열묶기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int k = Integer.parseInt(br.readLine());

        String[] strArr = new String[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = st.nextToken();
        }

        int result = solution(strArr);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(String[] strArr) {
        int answer = 0;

        int[] count = new int[100000];

        for (int i = 0; i < strArr.length; i++) {
            count[strArr[i].length()]++;
        }

        Arrays.sort(count);

        answer = count[count.length - 1];

        return answer;
    }

}
