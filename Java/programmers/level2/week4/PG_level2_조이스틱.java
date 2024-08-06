package level2.week4;

import java.io.*;

public class PG_level2_조이스틱 {

    public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String name = br.readLine();

        int result = solution(name);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(String name) {
        int answer = 0; // 조이스틱 조작 횟수
        int len = name.length();
        int move = name.length() - 1; // 기본 최소 좌우이동 횟수 (좌, 우 커서)

        // 해당 커서 알파벳 변경 최솟값 (위, 아래 커서)
        for (int i = 0; i < len; i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            // 연속된 'A'가 끝나는 지점 찾기
            int next = i + 1;
            while(next < len && name.charAt(next) == 'A') {
                next++;
            }

            // 좌우이동 최소 횟수 구하기 (순서대로 가기 vs 뒤로 돌아가기)
            move = Math.min(move, (i * 2) + len - next);
            move = Math.min(move, (len - next) * 2 + i);
        }

        return answer + move;
    }

}

/*
커서 위치가 바뀌게 되는 경우는 총 세 가지이다.
1. 처음부터 쭉 오른쪽으로 가는 경우
    가장 일반적인 경우로 name.length() - 1로 해당한다.
2. 오른쪽으로 갔다 다시 리턴하여 왼쪽으로 가는 경우
    ex) BBAAAAAYYY 의 경우, BB까지 갔다가 다시 돌아가 YYY를 완성해준다.
3. 왼쪽으로 갔다 다시 리턴하여 오른쪽으로 가는 경우
    ex) CCCAAAAAAY 의 경우, 처음부터 왼쪽으로 움직여 Y를 완성해주고 다시 오른쪽으로 돌아가 CCC를 완성해준다.
 */
