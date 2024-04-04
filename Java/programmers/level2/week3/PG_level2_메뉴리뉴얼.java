package level2.week3;

import java.io.*;
import java.util.*;

public class PG_level2_메뉴리뉴얼 {

    static List<String> answerList = new ArrayList<>();
    static Map<String, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int p = Integer.parseInt(br.readLine());
        String[] orders = new String[p];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < orders.length; i++) {
            orders[i] = st.nextToken();
        }

        int q = Integer.parseInt(br.readLine());
        int[] course = new int[q];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < course.length; i++) {
            course[i] = Integer.parseInt(st.nextToken());
        }

        String[] result = solution(orders, course);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        // 1. 각 order 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        // 2. 각 order를 기준으로 courseLength만큼의 조합 만들기
        for (int courseLength : course) {
            for (String order : orders) {
                combination("", order, courseLength);
            }
            // 3. 가장 많은 조합을 answer에 저장한다.
            if(!hashMap.isEmpty()) {
                List<Integer> countList = new ArrayList<>(hashMap.values());
                int max = Collections.max(countList);

                if(max > 1) {
                    for (String key : hashMap.keySet()) {
                        if(hashMap.get(key) == max) {
                            answerList.add(key);
                        }
                    }
                }
                hashMap.clear();
            }
        }

        Collections.sort(answerList);
        answer = new String[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    private static void combination(String order, String others, int count) {
        // 탈출조건
        if(count == 0) {
            hashMap.put(order, hashMap.getOrDefault(order, 0) + 1);
            return;
        }

        // 수행 동작 : 0부터 length까지 조합
        for (int i = 0; i < others.length(); i++) {
            combination(order + others.charAt(i), others.substring(i + 1), count - 1);
        }
    }


}

//6
//ABCFG AC CDE ACDE BCFG ACDEH
//3
//        2 3 4

//7
//ABCDE AB CD ADE XYZ XYZ ACD
//3
//        2 3 5