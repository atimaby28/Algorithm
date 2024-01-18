package level0.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_순서바꾸기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int k = Integer.parseInt(br.readLine());

        int[] num_list = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num_list.length; i++) {
            num_list[i] = Integer.parseInt(st.nextToken());
        }

        int n = Integer.parseInt(br.readLine());

        int[] result = solution(num_list, n);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length];

        String str = "";
        for (int num : num_list) {
            str += String.valueOf(num);
        }

        String temp1 = str.substring(0, n);
        String temp2 = str.substring(n);

        String ans = temp2 + temp1;

        for (int i = 0; i < ans.length(); i++) {
            answer[i] = ans.charAt(i) - '0';
        }

        return answer;
    }

    // 한 for문에서 끝내는 규칙을 찾아내지 못했다..
//    public int[] solution(int[] num_list, int n) {
//        int[] answer = new int[num_list.length];
//
//        for (int i = 0; i < num_list.length; i++) {
//            if (i < n) {
//                answer[num_list.length - n + i] = num_list[i];
//            } else {
//                answer[i - n] = num_list[i];
//            }
//        }
//
//        return answer;
//    }


}
