package level0.week3;

import java.io.*;

public class PG_level0_정수부분 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double flo = Double.parseDouble(br.readLine());

        int result = solution(flo);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(double flo) {
        int answer = 0;

        answer = (int)flo;

        return answer;
    }
}
