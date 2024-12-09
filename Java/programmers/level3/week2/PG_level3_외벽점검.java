package level3.week2;

import java.io.*;
import java.util.*;

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
        int len = weak.length;
        int[] extendWall = new int[len * 2];

        // 취약 지점을 두 배로 확장 (원형을 직선처럼 처리하기 위해)
        for (int i = 0; i < len; i++) {
            extendWall[i] = weak[i];            // 원래의 취약 지점
            extendWall[i + len] = weak[i] + n; // 확장된 취약 지점
        }

        int minFriends = Integer.MAX_VALUE; // 최소 친구 수 초기화
        List<int[]> permutations = getPermutations(dist); // 친구들의 이동 거리 순열을 모두 구함

        // 모든 시작 지점에서 순열을 통해 최소 친구 수 계산
        for (int i = 0; i < len; i++) {
            for (int[] friends : permutations) {
                int count = 1; // 사용한 친구 수
                int position = extendWall[i] + friends[count - 1]; // 첫 번째 친구의 커버 범위

                // 취약 지점들에 대해 커버가 안 되는 곳이 있으면 친구를 추가
                for (int j = i + 1; j < i + len; j++) {
                    // 현재 지점이 커버되지 않으면 추가 친구를 배치
                    if (extendWall[j] > position) {
                        count++;
                        if (count > friends.length) break; // 친구 수가 부족하면 종료
                        position = extendWall[j] + friends[count - 1]; // 새로운 친구의 커버 범위 갱신
                    }
                }
                minFriends = Math.min(minFriends, count); // 최소 친구 수 갱신
            }
        }

        return minFriends <= dist.length ? minFriends : -1;
    }

    // 친구들의 이동 거리 배열에서 모든 순열을 생성하는 메서드
    private static List<int[]> getPermutations(int[] dist) {
        List<int[]> result = new LinkedList<>();
        permutation(dist, new int[dist.length], 0, result, new boolean[dist.length]);
        return result;
    }

    // 순열을 재귀적으로 생성하는 메서드
    private static void permutation(int[] dist, int[] perm, int depth, List<int[]> result, boolean[] visited) {
        // 순열이 완성되면 리스트에 추가
        if (depth == dist.length) {
            result.add(perm); // 배열 복사본을 추가
            return;
        }

        for (int i = 0; i < dist.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                perm[depth] = dist[i];
                permutation(dist, perm, depth + 1, result, visited); // 재귀 호출
                visited[i] = false;
            }
        }
    }

}
