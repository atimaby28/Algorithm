package level1.week2;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class PG_level1_문자열내림차순으로배치하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();

        String result = solution(s);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }
    public static String solution(String s) {
        String answer = "";

//        String big = s.replace("[a-z]", "");
//        String small = s.replace("[A-Z]", "");
//
//        char[] bigChar = big.toCharArray();
//        char[] smallChar = small.toCharArray();
//
//        Arrays.sort(bigChar);
//        Arrays.sort(smallChar);

        char[] strChar = s.toCharArray();

        int n = strChar.length;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if(strChar[i] > strChar[j]) {
                    char temp = strChar[i];
                    strChar[i] = strChar[j];
                    strChar[j] = temp;
                }
            }
        }

        for (char c : strChar) {
            answer += c;
        }


        return answer;
    }

}
