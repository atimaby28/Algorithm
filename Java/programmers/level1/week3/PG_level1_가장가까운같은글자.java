package level1.week3;

import java.io.*;
import java.util.Arrays;

public class PG_level1_가장가까운같은글자 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int[] result = solution(s);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }


    public static int[] solution(String s) {
        int[] answer = new int[s.length()];

        int[] check = new int[26];

        Arrays.fill(check, -1);

        for (int i = 0; i < answer.length; i++) {
            if(check[s.charAt(i) - 'a'] == -1) {
                answer[i] = -1;
                check[s.charAt(i) - 'a'] = i;
            } else if(check[s.charAt(i) - 'a'] != -1){
                answer[i] = i - check[s.charAt(i) - 'a'];
                check[s.charAt(i) - 'a'] = i;
            }
        }

        for (int i : answer) {
            System.out.println(i);
        }

        return answer;
    }

}
