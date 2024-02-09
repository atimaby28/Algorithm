package level1.week1;

import java.io.*;

public class PG_level1_문자열내p와y의개수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        boolean result = solution(s);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    static boolean solution(String s) {
        boolean answer = true;

        int pCount = 0;
        int yCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'p' || s.charAt(i) == 'P') {
                pCount++;
            } else if(s.charAt(i) == 'y' || s.charAt(i) == 'Y') {
                yCount++;
            }
        }

        if(pCount == yCount) {
            answer = true;
        } else {
            answer = false;
        }
        return answer;
    }
}
