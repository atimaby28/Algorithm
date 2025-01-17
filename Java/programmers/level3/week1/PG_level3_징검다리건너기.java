package level3.week1;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level3_징검다리건너기 {
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

        int left = 1; // 최소 친구 수
        int right = Integer.MAX_VALUE - 1; // 최대 친구 수

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canCross(stones, k, mid)) {
                answer = mid; // 현재 mid 값으로 건널 수 있음
                left = mid + 1; // 더 많은 친구가 건널 수 있는지 확인
            } else {
                right = mid - 1; // 현재 mid 값으로는 건널 수 없음
            }
        }

        return answer;
    }

    private static boolean canCross(int[] stones, int k, int friends) {
        int skipCount = 0; // 연속으로 건너뛴 디딤돌 수

        for (int stone : stones) {
            if (stone - friends < 0) { // 친구 수만큼 밟았을 때 디딤돌이 0보다 작아짐
                skipCount++;
                if (skipCount >= k) {
                    return false; // 건너뛸 수 있는 최대 칸수를 초과함
                }
            } else {
                skipCount = 0; // 건너뛴 디딤돌이 없으므로 초기화
            }
        }
        return true;
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
