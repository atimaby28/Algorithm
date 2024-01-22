package level0.week4;

import java.io.*;
import java.util.Arrays;

public class PG_level0_접미사배열 {

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
        String[] answer = new String[my_string.length()];

        for (int i = 0; i < my_string.length(); i++) {
            answer[i] = my_string.substring(i);
        }

        Arrays.sort(answer);

        return answer;
    }

}
