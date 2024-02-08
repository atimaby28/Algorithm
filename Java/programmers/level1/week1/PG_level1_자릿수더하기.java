package level1.week1;

import java.io.*;

public class PG_level1_자릿수더하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int result = solution(N);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int N) {
        int answer = 0;

        String str = Integer.toString(N);

        for (int i = 0; i < str.length(); i++) {
            answer += str.charAt(i) - '0';
        }

        return answer;
    }

}
