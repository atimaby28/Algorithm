package level0.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_주사위게임 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int result = solution(a, b, c);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }


    public static int solution(int a, int b, int c) {
        int answer = 0;

        if(a != b && b != c && a != c) {
            answer = a + b + c;
        } else if(a == b && b == c && a == c) {
            answer = (a + b + c) * (a * a + b * b + c * c) * (a * a * a + b * b * b + c * c * c);
        } else {
            answer = (a + b + c) * (a * a + b * b + c * c);
        }

        return answer;
    }

}
