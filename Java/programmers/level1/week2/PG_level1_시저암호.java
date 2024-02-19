package level1.week2;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level1_시저암호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());

        String result = solution(s, n);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(String s, int n) {
        String answer = "";

        char[] sArr = s.toCharArray();

        for (int i = 0; i < sArr.length; i++) {
            if(sArr[i] >= 'A' && sArr[i] <= 'Z') {
                if(sArr[i] + n > 'Z') {
                    sArr[i] = (char) (sArr[i] + n - 26);
                } else {
                    sArr[i] = (char) (sArr[i] + n);
                }
            } else if(sArr[i] >= 'a' && sArr[i] <= 'z') {
                if(sArr[i] + n > 'z') {
                    sArr[i] = (char) (sArr[i] + n - 26);
                } else {
                    sArr[i] = (char) (sArr[i] + n);
                }
            }

        }

        for (char c : sArr) {
            answer += c;
        }

        return answer;
    }

}
