package level1.week3;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class PG_level1_문자열내마음대로정렬하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int x = Integer.parseInt(br.readLine());

        String[] strings = new String[x];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < strings.length; i++) {
            strings[i] = st.nextToken();
        }

        int n = Integer.parseInt(br.readLine());

        String[] result = solution(strings, n);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];

        return answer;
    }

}
