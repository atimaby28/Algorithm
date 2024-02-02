package level0.week5;

import java.io.*;

public class PG_level0_문자개수세기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String my_string = br.readLine();

        int[] result = solution(my_string);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(String my_string) {
        int[] answer = new int[52];

        for (int i = 0; i < my_string.length(); i++) {
            if(my_string.charAt(i) >= 'A' && my_string.charAt(i) <= 'Z') {
                answer[my_string.charAt(i) - 'A']++;
            } else {
                answer[my_string.charAt(i) - 'A' - 6]++;
            }

        }

        return answer;
    }

}
