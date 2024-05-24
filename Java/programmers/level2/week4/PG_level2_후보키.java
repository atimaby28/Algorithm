package level2.week4;

import java.io.*;
import java.util.*;

public class PG_level2_후보키 {

    public static List<Integer> key = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        String[][] relation = new String[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                relation[i][j] = st.nextToken();
            }
        }

        int result = solution(relation);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }
    public static int solution(String[][] relation) {
        int row = relation.length;
        int col = relation[0].length;

        for (int k = 1; k < (1 << col); k++) {
            if (!ckMinimality(k)) continue;

            Set<String> set = new HashSet<>();
            for (int i = 0; i < row; i++) {
                StringBuilder key = new StringBuilder();

                for (int j = 0; j < col; j++) {
                    if (((1 << j) & k) > 0) key.append(relation[i][j]).append('/');
                }

                if (!set.add(key.toString())) break;
            }
            if (set.size() == row) key.add(k);
        }
        return key.size();
    }

    public static boolean ckMinimality(int i) {
        for (int k : key)
            if ((k & i) == k) return false;
        return true;
    }

}

/*
6 4
100 ryan music 2
200 apeach math 2
300 tube computer 3
400 con computer 4
500 muzi music 3
600 apeach music 2
 */
