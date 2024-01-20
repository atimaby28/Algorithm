package level0.week4;

import java.io.*;
import java.util.Arrays;

public class PG_level0_문자열잘라서정렬하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String myString = br.readLine();

        String[] result = solution(myString);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String[] solution(String myString) {
        String[] answer = {};

        String[] strSplit = myString.split("x");

        for (String str : strSplit) {
            if(str.isEmpty()) {
                continue;
            }

            answer = Arrays.copyOf(answer, answer.length + 1);
            answer[answer.length - 1] = str;

        }

        Arrays.sort(answer);

        return answer;
    }

}
