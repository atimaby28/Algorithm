package level3.week2;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level3_미로탈출명령어 {
    static char[] directions = {'d', 'l', 'r', 'u'};
    static int[] dx = {1, 0, 0, -1}; // 아래, 왼쪽, 오른쪽, 위쪽
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String result = solution(n, m, x, y, r, c, k);

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();

    }

    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        // 출발점과 도착점 간 거리와 k의 홀짝 불일치 시 불가능
        int distance = Math.abs(r - x) + Math.abs(c - y);
        if (distance > k || (k - distance) % 2 != 0) return "impossible";

        StringBuilder result = new StringBuilder("impossible");

        // dfs 호출하여 경로를 result에 저장
        dfs(n, m, x, y, r, c, k, new StringBuilder(), result);

        return result.toString();
    }

    private static void dfs(int n, int m, int x, int y, int r, int c, int k, StringBuilder path, StringBuilder result) {
        // 결과가 이미 결정된 경우 더 이상 탐색하지 않음
        if (!result.toString().equals("impossible")) return;

        // 목적지 도달 시 결과 갱신
        if (x == r && y == c && path.length() == k) {
            result.setLength(0);  // 기존 내용 초기화
            result.append(path);
            return;
        }

        // 목표까지의 남은 거리와 k-현재 경로 길이 차이가 홀수이면 도달 불가능
        int remainingDistance = Math.abs(r - x) + Math.abs(c - y);
        if (remainingDistance > k - path.length()) return;

        // 사전 순으로 방향 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 격자 범위를 벗어나면 무시
            if (nx < 1 || nx > n || ny < 1 || ny > m) continue;

            // 이동 후 경로 추가
            path.append(directions[i]);
            dfs(n, m, nx, ny, r, c, k, path, result);
            path.deleteCharAt(path.length() - 1); // 백트래킹
        }
    }

}
