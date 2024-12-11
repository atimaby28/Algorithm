package silver.two;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_12891_DNA비밀번호 {

    final static char[] dnaSerial = {'A', 'C', 'G', 'T'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        String str = new String(br.readLine());

        int[] dnaSample = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < dnaSample.length; i++) {
            dnaSample[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(s, p, str, dnaSample);

        bw.write(result + "\n");

        bw.flush();

        br.close();
        bw.close();
    }

    private static int solution(int s, int p, String str, int[] dnaSample) {
        int answer = 0;

        // 각 문자의 등장 횟수를 추적할 배열
        int[] counts = new int[4]; // [A, C, G, T]

        // DNA 문자열에서 각 문자의 인덱스
        int A = 0, C = 1, G = 2, T = 3;

        // 처음 P_len 길이 부분문자열을 설정
        for (int i = 0; i < p; i++) {
            char ch = str.charAt(i);
            if (ch == 'A') counts[A]++;
            else if (ch == 'C') counts[C]++;
            else if (ch == 'G') counts[G]++;
            else if (ch == 'T') counts[T]++;
        }

        if(isValid(counts, dnaSample))
            answer++;

        for (int i = p; i < s; i++) {

            char newChar = str.charAt(i);
            if (newChar == 'A') counts[A]++;
            else if (newChar == 'C') counts[C]++;
            else if (newChar == 'G') counts[G]++;
            else if (newChar == 'T') counts[T]++;

            // 이전 문자 제거
            char oldChar = str.charAt(i - p);
            if (oldChar == 'A') counts[A]--;
            else if (oldChar == 'C') counts[C]--;
            else if (oldChar == 'G') counts[G]--;
            else if (oldChar == 'T') counts[T]--;

            if(isValid(counts, dnaSample))
                answer++;
        }

        return answer;
    }

    private static boolean isValid(int[] counts, int[] dnaSample) {

        for (int i = 0; i < counts.length; i++) {
            if(counts[i] < dnaSample[i])
                return false;
        }

        return true;
    }
}
