package level3.week2;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level3_110옮기기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        String[] s = new String[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < s.length; i++) {
            s[i] = st.nextToken();
        }

        String[] result = solution(s);

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    static StringBuilder sb;
    public static String[] solution(String[] s) {
        String[] answer = {};

        for(int i = 0; i < s.length; i++) {

            int zeroPos = 0;
            for(int j = 0; j < s[i].length(); j++) {
                if(s[i].charAt(j) == '1') {
                    zeroPos = j;
                    break;
                }
            }

            if(s[i].contains("110")) {
                s[i] = s[i].replaceFirst("110", "");
                sb = new StringBuilder(s[i]);
                sb.insert(zeroPos, "110");

            }

            System.out.println(sb.toString());


        }

        return answer;
    }
}
