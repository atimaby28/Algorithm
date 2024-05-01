package level2.week1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level2_구명보트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());

        int[] people = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < people.length; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        int limit = Integer.parseInt(br.readLine());

        int result = solution(people, limit);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;

        //무게 순으로 정렬
        Arrays.sort(people);

        int minIdx = 0; //가장 가벼운 사람 위치
        int maxIdx = people.length - 1; //가장 무거운 사람 위치

        while(maxIdx >= minIdx) {
            if(people[maxIdx] + people[minIdx] <= limit) {
                answer++;
                maxIdx--;
                minIdx++;
            }
            else {
                answer++;
                maxIdx--;
            }
        }

        return answer;
    }
}
