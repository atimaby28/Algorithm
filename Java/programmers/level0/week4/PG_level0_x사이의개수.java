package level0.week4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level0_x사이의개수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String myString = br.readLine();

        int[] result = solution(myString);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(String myString) {
        int[] answer = {};

        String[] splitStr = myString.split("x", - 1);

        answer = new int[splitStr.length];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = splitStr[i].length();
        }

        return answer;
    }

}
