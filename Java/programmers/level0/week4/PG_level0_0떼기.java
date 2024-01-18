package level0.week4;

import java.io.*;

public class PG_level0_0떼기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String n_str = br.readLine();

        String result = solution(n_str);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(String n_str) {
        String answer = "";

        int i = 0;
        while(n_str.charAt(i) == '0') {
            i++;
        }

        for (int j = i; j < n_str.length(); j++) {
            answer += n_str.charAt(j);
        }

        return answer;
    }

//    public String solution(String n_str) {
//        return Integer.parseInt(n_str) + "";
//    }

}
