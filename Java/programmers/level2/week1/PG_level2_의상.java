package level2.week1;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PG_level2_의상 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        String[][] clothes = new String[p][q];

        for (int i = 0; i < clothes.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < clothes[0].length; j++) {
                clothes[i][j] = st.nextToken();
            }
        }

        int result = solution(clothes);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(String[][] clothes) {
        int answer = 0;

        HashMap<String, Integer> hsmap = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            hsmap.put(clothes[i][1], hsmap.getOrDefault(clothes[i][1], 0) + 1);
        }

        if(hsmap.size() == 1) {
            answer = hsmap.get(clothes[0][1]);
        } else {
            for (int val : hsmap.values()) {
                answer *= combina(val, 0) + combina(val, 1);
            }
        }

        return answer;
    }

    private static int combina(int n, int r) {
        if(r == 0 || n == r) return  1;
        return combina(n-1, r-1) + combina(n-1, r);
    }

}
