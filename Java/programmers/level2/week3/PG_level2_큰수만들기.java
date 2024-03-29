package level2.week3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class PG_level2_큰수만들기 {

    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String number = br.readLine();
        int k = Integer.parseInt(br.readLine());

        String result = solution(number, k);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }


    public static String solution(String number, int k) {
        String answer = "";

        int startIdx = number.length() - k;

        for (int i = 0; i < startIdx; i++) {
            System.out.println(startIdx);
        }

        return answer;
    }

}
