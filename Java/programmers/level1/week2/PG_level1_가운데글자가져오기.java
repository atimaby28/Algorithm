package level1.week2;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level1_가운데글자가져오기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();

        String result = solution(s);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }
    public static String solution(String s) {
        String answer = "";

        if (s.length() % 2 != 0) {
            answer += s.charAt(s.length() / 2);
        } else {
            answer += s.charAt(s.length() / 2);
            answer += s.charAt((s.length() / 2) + 1);
        }

        return answer;
    }

//    String getMiddle(String word){
//        return word.substring((word.length()-1)/2, word.length()/2 + 1);
//    }


}
