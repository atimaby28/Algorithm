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
        int[] answer = new int[2];

        Set<String> gemSet = new HashSet<>();

        Map<String, Integer> gemMap = new HashMap<>();
        int gemType = new HashSet<>(Arrays.asList(gems)).size();

        int start = 0;
        int gemLength = Integer.MAX_VALUE;

        for (int end = 0; end < gems.length; end++) {
//            gemMap.put(gems[end], gemMap.getOrDefault(gems[end], 0) + 1);
            gemSet.add(gems[end]);

            while(true) {

                if(gemSet.contains(gems[start])) {
                    start++;
                } else break;
            }

//            while(gemMap.get(gems[start]) > 1) {
//                gemMap.put(gems[start], gemMap.get(gems[start]) - 1);
//                start++;
//            }

            if(gemType == gemMap.size() && gemLength > end - start) {
                gemLength = end - start;
                answer[0] = start + 1;
                answer[1] = end + 1;
            }
        }

        return answer;
    }

}
/*
8
DIA RUBY RUBY DIA DIA EMERALD SAPPHIRE DIA
 */