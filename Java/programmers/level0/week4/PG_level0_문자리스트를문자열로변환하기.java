package level0.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_문자리스트를문자열로변환하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        String[] strArr = new String[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = st.nextToken();
        }

        String result = solution(strArr);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(String[] arr) {
        String answer = "";

        for (String str : arr) {
            answer += str;
        }

        return answer;
    }

}
