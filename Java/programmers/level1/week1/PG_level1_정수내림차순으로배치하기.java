package level1.week1;

import java.io.*;
import java.util.Arrays;

public class PG_level1_정수내림차순으로배치하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Integer.parseInt(br.readLine());

        long result = solution(n);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static long solution(long n) {
        long answer = 0;

        String str = Long.toString(n);
        int[] strToint = new int[str.length()];

        for (int i = 0; i < strToint.length; i++) {
            strToint[i] = str.charAt(i) - '0';
        }

        Arrays.sort(strToint);

        String temp = "";
        for (int i = strToint.length - 1; i >= 0; i--) {
            temp += Long.toString(strToint[i]);
        }

        answer = Long.parseLong(temp);

        return answer;
    }

//    public long solution(long n) {
//        String[] list = String.valueOf(n).split("");
//        Arrays.sort(list);
//
//        StringBuilder sb = new StringBuilder();
//        for (String aList : list) sb.append(aList);
//
//        return Long.parseLong(sb.reverse().toString());
//    }

}
