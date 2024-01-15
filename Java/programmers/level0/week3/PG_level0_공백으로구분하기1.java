package level0.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_공백으로구분하기1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String my_string = br.readLine();

        String[] result = solution(my_string);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String[] solution(String my_string) {
        String[] answer = {};

        answer = my_string.split(" ");

        return answer;
    }

}
