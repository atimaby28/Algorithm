package level0.week4;

import java.io.*;
import java.util.Arrays;

public class PG_level0_세개의구분자 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String myString = br.readLine();

        String[] result = solution(myString);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String[] solution(String myStr) {
        String[] answer = {};

        myStr = myStr.replaceAll("[a|b|c]", " ");

        String[] strChar = myStr.split(" ");

        for (int i = 0; i < strChar.length; i++) {
            if(!strChar[i].equals("")) {
                answer = Arrays.copyOf(answer, answer.length + 1);
                answer[answer.length - 1] = strChar[i];
            }
        }

        if(answer.length == 0) {
            answer = new String[]{"EMPTY"};
        }

        return answer;
    }

}
