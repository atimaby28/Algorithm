package level2.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_단체사진찍기 {

    public static int count = 0;
    public static boolean[] visited;
    public static final char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        String[] words = new String[n];

        for (int i = 0; i < words.length; i++) {
            st = new StringTokenizer(br.readLine());
            words[i] = st.nextToken();
        }

        int result = solution(n, words);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(int n, String[] data) {
        int answer = 0;

        visited = new boolean[friends.length];
        combination(data, "", 0);

        answer = count;

        return answer;
    }

    private static void combination(String[] data, String line, int depth) {
        if (depth == friends.length) {

            if (condition(data, line)) count++;

            return;
        }

        for (int i = 0; i < friends.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(data, line + friends[i], depth + 1);
                visited[i] = false;
            }
        }

    }

    private static boolean condition(String[] data, String line) {

        for (String datum : data) {
            int distance = Math.abs(line.indexOf(datum.charAt(0)) - line.indexOf(datum.charAt(2))) - 1;
            char sign = datum.charAt(3);
            int target = datum.charAt(4) - '0';

            if (sign == '>') {
                if (distance <= target) {
                    return false;
                }
            } else if (sign == '<') {
                if (distance >= target) {
                    return false;
                }
            } else {
                if (distance != target) {
                    return false;
                }
            }
        }
        return true;

    }

}

/*
2
N~F=0
R~T>2
 */