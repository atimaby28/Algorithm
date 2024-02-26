package level1.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level1_숫자짝궁 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String X = st.nextToken();
        String Y = st.nextToken();

        String result = solution(X, Y);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }
    public static String solution(String X, String Y) {
        String answer = "";

        int[] checkX = new int[10];
        int[] checkY = new int[10];

        int[] common = new int[10];

        for (int i = 0; i < X.length(); i++) {
            checkX[(X.charAt(i) - '0')]++;
        }

        for (int i = 0; i < Y.length(); i++) {
            checkY[(Y.charAt(i) - '0')]++;
        }

        for (int i = 0; i < common.length; i++) {
            if(checkX[i] >= 1 && checkY[i] >= 1) {
                common[i] = checkX[i] > checkY[i]? checkY[i] : checkX[i];
            }
        }

        for (int i = common.length - 1; i >= 0; i--) {
            if(common[i] != 0) {
                answer += (i + "").repeat(common[i]);
            }
        }

        if(answer.length() == 0) {
            answer = "-1";
        }

        if(answer.charAt(0) == '0') {
            answer = "0";
        }

        return answer;
    }

}
