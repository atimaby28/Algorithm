package level3.week1;

import java.io.*;
import java.util.*;

public class PG_level3_보석쇼핑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());

        String[] gems = new String[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < gems.length; i++) {
            gems[i] = st.nextToken();
        }

        int[] result = solution(gems);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int[] solution(String[] gems) {
        // 모든 보석의 종류를 저장
        Set<String> gemTypes = new HashSet<>(Arrays.asList(gems));
        int totalGemTypes = gemTypes.size();

        // 슬라이딩 윈도우와 보석 개수 추적을 위한 맵 초기화
        Map<String, Integer> gemCount = new HashMap<>();
        int start = 0, end = 0;

        // 결과값 초기화 (시작 번호, 끝 번호, 길이)
        int[] result = {0, gems.length - 1};
        int minLength = gems.length;

        while (end < gems.length) {
            // 현재 보석 추가
            gemCount.put(gems[end], gemCount.getOrDefault(gems[end], 0) + 1);
            end++;

            // 모든 종류의 보석이 포함된 경우
            while (gemCount.size() == totalGemTypes) {
                // 구간 길이 계산
                int currentLength = end - start;
                if (currentLength < minLength) {
                    minLength = currentLength;
                    result[0] = start;
                    result[1] = end - 1;
                }

                // 구간의 시작점 보석 제거
                String startGem = gems[start];
                gemCount.put(startGem, gemCount.get(startGem) - 1);
                if (gemCount.get(startGem) == 0) {
                    gemCount.remove(startGem);
                }
                start++;
            }
        }

        // 1-based indexing으로 변환
        return new int[]{result[0] + 1, result[1] + 1};
    }

}
/*
8
DIA RUBY RUBY DIA DIA EMERALD SAPPHIRE DIA
 */