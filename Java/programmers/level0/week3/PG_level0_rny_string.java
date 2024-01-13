package level0.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_rny_string {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String rny_string = br.readLine();

        String result = solution(rny_string);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(String rny_string) {
        String answer = "";

        answer = rny_string.replaceAll("m", "rn");

        return answer;
    }

}
