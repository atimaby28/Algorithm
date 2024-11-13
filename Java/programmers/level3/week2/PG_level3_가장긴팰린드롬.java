package level3.week2;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level3_가장긴팰린드롬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int result = solution(s);

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    public static int solution(String s) {
        // 가장 긴 문자열부터 팰린드롬 검사
        for (int i = s.length(); i > 1; i--) {

            // 시작 인덱스
            for (int j = 0; j + i <= s.length(); j++) {
                boolean chk = true;

                // 처음부터 문자열 길이의 반틈만큼 문자가 같은지 비교
                for (int k = 0; k < i / 2; k++) {
                    if (s.charAt(j + k) != s.charAt(j + i - k - 1)) {
                        chk = false;
                        break;
                    }
                }

                if (chk)
                    return i;
            }
        }
        return 1;
    }
}
