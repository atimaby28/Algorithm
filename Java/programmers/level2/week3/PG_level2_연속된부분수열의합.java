package level2.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_연속된부분수열의합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[] sequence = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int k = Integer.parseInt(br.readLine());

        int[] result = solution(sequence, k);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    // 시간초과 코드
//    public static int[] solution(int[] sequence, int k) {
//        int[] answer = {0, 0};
//
//        int diff = sequence.length;
//        for (int i = 0; i < sequence.length; i++) {
//            int sum = 0;
//            for (int j = i; j >= 0; j--) {
//                if(sequence[j] <= sequence[i]) {
//                    sum += sequence[j];
//
//                    if(sum == k && Math.abs(i - j) < diff) {
//                        diff = Math.abs(i - j);
//                        answer = new int[]{j, i};
//
//                    }
//                }
//            }
//
//        }
//        return answer;
//    }


}

/*
Testcase 33의 반례
[2, 2, 2, 2, 2], 2
i와 j를 0부터 시작해야 한다.
 */
