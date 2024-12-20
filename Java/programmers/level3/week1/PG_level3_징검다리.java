package level3.week1;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class PG_level3_징검다리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] stones = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < stones.length; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(stones, k);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    // 이분탐색 풀이
    public static int solution(int[] stones, int k) {
        int answer = 0;
        int l = 0, r = -1;
        for (int s : stones) {
            r = Math.max(r, s);
        }

        while (l <= r) {
            int m = (l + r) / 2;

            int sequence = 0;
            int maxSequence = 0;
            for (int i = 0; i < stones.length; i++) {
                if (stones[i] - m <= 0) {
                    sequence++;
                    maxSequence = Math.max(maxSequence, sequence);
                } else {
                    sequence = 0;
                }
            }

            if (maxSequence + 1 > k) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    // 슬라이딩 윈도우 풀이
//    public static int solution(int[] stones, int k) {
//        int answer = Integer.MAX_VALUE;
//        Deque<Data> dq = new ArrayDeque<>();
//
//        for (int i = 0; i < stones.length; i++) {
//            int stone = stones[i];
//
//            // 슬라이딩 윈도우의 크기가 k가 되도록 조절
//            while (!dq.isEmpty() && i - dq.peekFirst().index >= k) {
//                dq.pollFirst();
//            }
//
//            // 윈도우 내부의 최대 값을 유지
//            while (!dq.isEmpty() && stone > dq.peekLast().value) {
//                dq.pollLast();
//            }
//
//            dq.addLast(new Data(stone, i));
//
//            // 슬라이딩 윈도우의 크기가 k가 되면 최대 값을 확인하고 갱신
//            if (i >= k - 1) {
//                answer = Math.min(answer, dq.peekFirst().value);
//            }
//        }
//
//        if (answer == Integer.MAX_VALUE) return 0;
//        return answer;
//    }


}

//class Data {
//    int value;
//    int index;
//
//    Data (int value, int index) {
//        this.value = value;
//        this.index = index;
//    }
//}
