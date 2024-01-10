package level0.week3;

import java.io.*;
public class PG_level0_문자열곱하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String my_string = br.readLine();

        int k = Integer.parseInt(br.readLine());

        String result = solution(my_string, k);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }
    public static String solution(String my_string, int k) {
        String answer = "";

        answer = repeat(my_string, k);

        return answer;
    }

    private static String repeat(String myString, int k) {
        if(k == 1) {
            return myString;
        }

        return repeat(myString, k - 1) + myString;
    }

}
