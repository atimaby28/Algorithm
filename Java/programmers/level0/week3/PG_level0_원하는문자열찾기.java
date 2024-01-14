package level0.week3;

import java.io.*;

public class PG_level0_원하는문자열찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String myString = br.readLine();
        String pat = br.readLine();

        int result = solution(myString, pat);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(String myString, String pat) {
        int answer = 0;

        if(myString.toLowerCase().contains(pat.toLowerCase())) {
            answer = 1;
        }

        return answer;
    }

}
