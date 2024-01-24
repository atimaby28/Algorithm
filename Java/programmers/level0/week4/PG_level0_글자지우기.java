package level0.week4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level0_글자지우기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        String my_string = br.readLine();

        int n = Integer.parseInt(br.readLine());

        int[] indices = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < indices.length; i++) {
            indices[i] = Integer.parseInt(st.nextToken());
        }

        String result = solution(my_string, indices);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(String my_string, int[] indices) {
        String answer = "";

        boolean[] check = new boolean[my_string.length()];

        for (int i = 0; i < indices.length; i++) {
            check[indices[i]] = true;
        }

        for (int i = 0; i < check.length; i++) {
            if(check[i] == false) {
                answer += my_string.charAt(i);
            }
        }

        return answer;
    }

//    public String solution(String my_string, int[] indices) {
//        String answer = "";
//        String[] tmp = my_string.split("");
//
//        for (int i = 0; i < indices.length; i++) {
//            tmp[indices[i]] = "";
//        }
//
//        for (String x : tmp) {
//            answer += x;
//        }
//        return answer;
//    }

}
