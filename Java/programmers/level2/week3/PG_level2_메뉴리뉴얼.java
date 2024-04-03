package level2.week3;

import java.io.*;
import java.util.*;

public class PG_level2_메뉴리뉴얼 {

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

        // 2. 각 order를 기준으로 course.length만큼의 조합 만들기
        // 3. 가장 많은 조합을 answer에 저장한다.

        return answer;
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