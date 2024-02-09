package level1.week1;

import java.io.*;

public class PG_level1_자연수뒤집어배열로만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());

        int[] result = solution(n);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(long n) {
        int[] answer = {};

        String str = Long.toString(n);

        answer = new int[str.length()];

        for (int i = str.length() - 1; i >= 0; i--) {
            answer[(str.length() - 1) - i] = str.charAt(i) - '0';
        }

        return answer;
    }

}
