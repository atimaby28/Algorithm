package level3.week2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class PG_level3_스타수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        int result = solution(a);

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    public static int solution(int[] a) {
        int answer = 0;

        if (a.length < 2) {
            return 0; // 스타 수열을 만들 수 없음
        }

        // 각 숫자의 등장 횟수를 계산
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : a) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }


        // 각 숫자를 중심으로 스타 수열 길이 계산
        for (int num : counter.keySet()) {
            if (counter.get(num) <= answer) {
                continue; // 현재 최대 길이를 넘을 가능성이 없으면 스킵
            }

            int length = 0; // 현재 숫자를 중심으로 하는 스타 수열 길이

            for (int i = 0; i < a.length - 1; i++) {
                // 조건을 만족하는 쌍을 찾음
                if ((a[i] == num || a[i + 1] == num) && a[i] != a[i + 1]) {
                    length++; // 유효한 쌍 발견
                    i++; // 다음 쌍으로 건너뜀
                }
            }

            answer = Math.max(answer, length); // 최댓값 갱신
        }

        return answer * 2;
    }
}
/*
10
0 3 3 0 7 2 0 2 2 0
 */