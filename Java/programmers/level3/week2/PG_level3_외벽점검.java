package level3.week2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PG_level3_외벽점검 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());


        int[] weak = new int[p];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < weak.length; i++) {
            weak[i] = Integer.parseInt(st.nextToken());
        }

        int[] dist = new int[q];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(n, weak, dist);

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    public static int solution(int n, int[] weak, int[] dist) {
        // Step 1: 취약 지점 확장
        int weakLen = weak.length;
        int[] extendedWeak = new int[weakLen * 2];
        for (int i = 0; i < weakLen; i++) {
            extendedWeak[i] = weak[i];
            extendedWeak[i + weakLen] = weak[i] + n;
        }

        // Step 2: 최소 친구 수 초기화
        int minFriends = Integer.MAX_VALUE;

        // Step 3: 모든 시작점과 친구 순열 탐색
        List<int[]> permutations = generatePermutations(dist);

        for (int start = 0; start < weakLen; start++) {
            for (int[] friends : permutations) {
                int count = 1; // 사용한 친구 수
                int position = extendedWeak[start] + friends[count - 1]; // 첫 친구의 커버 위치

                for (int i = start + 1; i < start + weakLen; i++) {
                    if (extendedWeak[i] > position) { // 커버할 수 없는 지점이 나오면
                        count++; // 친구 추가
                        if (count > friends.length) { // 친구를 더 추가할 수 없다면 중단
                            break;
                        }
                        position = extendedWeak[i] + friends[count - 1]; // 새로운 친구의 커버 위치 갱신
                    }
                }

                // 최소 친구 수 갱신
                minFriends = Math.min(minFriends, count);
            }
        }

        // Step 4: 결과 반환
        return minFriends <= dist.length ? minFriends : -1;
    }

    // 친구 이동 거리의 모든 순열 생성
    private static List<int[]> generatePermutations(int[] dist) {
        List<int[]> result = new ArrayList<>();
        permute(dist, 0, result);
        return result;
    }

    private static void permute(int[] array, int start, List<int[]> result) {
        if (start == array.length) {
            result.add(array.clone());
            return;
        }

        for (int i = start; i < array.length; i++) {
            swap(array, start, i);
            permute(array, start + 1, result);
            swap(array, start, i);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
