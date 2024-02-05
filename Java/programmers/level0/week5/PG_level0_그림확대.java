package level0.week5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level0_그림확대 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int x = Integer.parseInt(br.readLine());

        String[] picture = new String[x];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < picture.length; i++) {
            picture[i] = st.nextToken();
        }

        int k = Integer.parseInt(br.readLine());

        String[] result = solution(picture, k);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String[] solution(String[] picture, int k) {
        String[] answer = {};

        for (int i = 0; i < picture.length; i++) {
            String temp = "";
            for (int j = 0; j < picture[i].length(); j++) {
                for (int l = 0; l < k; l++) {
                    temp += picture[i].charAt(j);
                }
            }

            for (int j = 0; j < k; j++) {
                answer = Arrays.copyOf(answer, answer.length + 1);
                answer[answer.length - 1] = temp;
            }

        }

        return answer;
    }

}
