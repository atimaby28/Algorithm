package level1.week1;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level1_서울에서김서방찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        String[] seoul = new String[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < seoul.length; i++) {
            seoul[i] = st.nextToken();
        }

        String result = solution(seoul);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(String[] seoul) {
        String answer = "";

        int pos = -1;
        for (int i = 0; i < seoul.length; i++) {
            if(seoul[i].equals("Kim")) {
                pos = i;
                break;
            }
        }

        answer = "김서방은 " + pos + "에 있다";

        return answer;
    }

}
