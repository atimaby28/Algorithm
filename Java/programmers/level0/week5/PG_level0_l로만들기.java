package level0.week5;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_l로만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String myString = st.nextToken();

        String result = solution(myString);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }
    public static String solution(String myString) {
        String answer = "";

        char[] strToChar = myString.toCharArray();

        for (int i = 0; i < strToChar.length; i++) {
            if(strToChar[i] < 'l') {
                strToChar[i] = 'l';
            }
        }

        for (char c : strToChar) {
            answer += c;
        }

        return answer;
    }

}
