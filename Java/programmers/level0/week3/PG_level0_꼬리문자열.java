package level0.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_꼬리문자열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int k = Integer.parseInt(br.readLine());

        String[] str_list = new String[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < str_list.length; i++) {
            str_list[i] = st.nextToken();
        }

        String ex = br.readLine();

        String result = solution(str_list, ex);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }
    public static String solution(String[] str_list, String ex) {
        String answer = "";

        for (String str : str_list) {
            if(!str.contains(ex)) {
                answer += str;
            }
        }

        return answer;
    }

}
