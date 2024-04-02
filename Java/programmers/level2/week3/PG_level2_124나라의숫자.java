package level2.week3;

import java.io.*;

public class PG_level2_124나라의숫자 {

//    public static int count = 0;
//    public static String ans = "";
//
//    static int[] output;
//    public static int[] array = {1, 2, 4};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String result = solution(n);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(int n) {
        String answer = "";

        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            if(n % 3 == 0) {
                n = n / 3 - 1;
                sb.append(4);
            } else {
                sb.append(n % 3);
                n /= 3;
            }
        }

        answer = String.valueOf(sb.reverse());

        return answer;
    }

//    public static String solution(int n) {
//        String answer = "";
//
//        int a = 3;
//        int r = 3;
//
//        int digit = 0;
//
//        // 등비 수열의 합
//        while (n > a * (Math.pow(3, digit) - 1) / (r - 1)) {
//            digit++;
//        }
//
//        output = new int[digit];
//
//        int k = (int) (a * (Math.pow(3, digit - 1) - 1) / (r - 1));
//
//        DFS(0, digit, n, k);
//
//        answer = ans;
//
//        return answer;
//    }
//
//    private static void DFS(int depth, int digit, int n, int k) {
//        if (depth == digit) {
//            String temp = "";
//            for (int s : output) {
//                temp += s;
//            }
//
//            count++;
//
//            if(count == n - k) {
//                ans = temp;
//            }
//
//            return;
//        }
//
//        for (int i = 0; i < array.length; i++) {
//            output[depth] = array[i];
//            DFS(depth + 1, digit, n, k);
//        }
//    }
}
