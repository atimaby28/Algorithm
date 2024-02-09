package level1.week1;

import java.io.*;

public class PG_level1_문자열정수로바꾸기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int result = solution(s);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(0) == '-') {
                answer = -1 * Integer.parseInt(s.substring(1));
            } else {
                if(s.charAt(0) == '+') {
                    answer = Integer.parseInt(s.substring(1));
                } else {
                    answer = Integer.parseInt(s);
                }
            }
        }

        return answer;
    }

}
