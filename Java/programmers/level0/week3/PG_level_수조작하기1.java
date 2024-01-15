package level0.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level_수조작하기1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String control = br.readLine();

        int result = solution(n, control);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }
    public static int solution(int n, String control) {
        int answer = 0;

        for (int i = 0; i < control.length(); i++) {
            if(control.charAt(i) == 'w') {
                n += 1;
            } else if (control.charAt(i) == 's') {
                n -= 1;
            } else if (control.charAt(i) == 'd') {
                n += 10;
            } else if (control.charAt(i) == 'a') {
                n -= 10;
            } else {
                answer = -1;
            }
        }

        answer = n;

        return answer;
    }

}
