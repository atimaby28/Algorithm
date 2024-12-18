package level3.week2;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class PG_level3_표편집 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int x = Integer.parseInt(br.readLine());

        String[] cmd = new String[x];

        for (int i = 0; i < cmd.length; i++) {
            cmd[i] = br.readLine();
        }

        String result = solution(n, k, cmd);

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    public static String solution(int n, int k, String[] cmd) {
        String answer = "";

        // 연결 리스트를 표현하기 위한 배열
        int[] prev = new int[n];
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1; // 마지막 행의 다음을 -1로 설정

        // 삭제된 행을 복구하기 위한 스택
        Stack<int[]> removed = new Stack<>();

        // 현재 선택된 행
        int current = k;

        for (String command : cmd) {
            char op = command.charAt(0);
            if (op == 'U') {
                // 위로 이동
                int x = Integer.parseInt(command.substring(2));
                while (x-- > 0) {
                    current = prev[current];
                }
            } else if (op == 'D') {
                // 아래로 이동
                int x = Integer.parseInt(command.substring(2));
                while (x-- > 0) {
                    current = next[current];
                }
            } else if (op == 'C') {
                // 현재 행 삭제
                removed.push(new int[]{current, prev[current], next[current]});

                if (next[current] != -1) prev[next[current]] = prev[current];
                if (prev[current] != -1) next[prev[current]] = next[current];

                current = (next[current] != -1) ? next[current] : prev[current];

            } else {
                int[] restore = removed.pop();
                int index = restore[0], prevIdx = restore[1], nextIdx = restore[2];

                if (prevIdx != -1) next[prevIdx] = index;
                if (nextIdx != -1) prev[nextIdx] = index;
            }
        }

        // 결과 문자열 생성
        StringBuilder result = new StringBuilder("O".repeat(n));

        while (!removed.isEmpty()) {
            result.setCharAt(removed.pop()[0], 'X');
        }

        answer = result.toString();

        return answer;
    }

}

/*
8 2
9
D 2
C
U 3
C
D 4
C
U 2
Z
Z
 */

// OOOOXOOO