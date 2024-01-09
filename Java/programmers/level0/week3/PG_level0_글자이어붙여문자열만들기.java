package level0.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_글자이어붙여문자열만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        String my_string = br.readLine();

        int[] index_list = new int[my_string.length()];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < index_list.length; i++) {
            index_list[i] = Integer.parseInt(st.nextToken());
        }

        String result = solution(my_string, index_list);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(String my_string, int[] index_list) {
        String answer = "";

        for (int i = 0; i < index_list.length; i++) {
            answer += my_string.charAt(index_list[i]);
        }

        return answer;
    }

}
