package level2.week1;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class PG_level2_연속부분수열합의개수 {

    public static boolean isSelected[];
    public static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[] elements = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < elements.length; i++) {
            elements[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(elements);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(int[] elements) {
        int answer = 0;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int sum = 0;
                for (int k = j; k < i + (j + 1); k++) {
                    sum += elements[k % elements.length];
                }
                set.add(sum);
            }
        }

        answer = set.size();

        return answer;
    }

}
