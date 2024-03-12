package level2.week2;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_뉴스클러스터링 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String str1 = st.nextToken();
        String str2 = st.nextToken();

        int result = solution(str1, str2);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }
    public static int solution(String str1, String str2) {
        int answer = 0;



        return answer;
    }

}
