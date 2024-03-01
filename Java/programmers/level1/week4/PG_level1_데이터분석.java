package level1.week4;

import java.io.*;
import java.util.*;

public class PG_level1_데이터분석 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[][] data = new int[p][q];

        for (int i = 0; i < data.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        String ext = st.nextToken();
        int val_ext = Integer.parseInt(st.nextToken());
        String sort_by = st.nextToken();

        int[][] result = solution(data, ext, val_ext, sort_by);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};

        HashMap<String, Integer> hsmap = new HashMap<>();

        hsmap.put("code", 0);
        hsmap.put("date", 1);
        hsmap.put("maximum", 2);
        hsmap.put("remain", 3);

        for (int i = 0; i < data.length; i++) {
            if(data[i][hsmap.get(ext)] < val_ext) {
                answer = Arrays.copyOf(answer, answer.length + 1);
                answer[answer.length - 1] = data[i];
            }
        }

        Arrays.sort(answer, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[hsmap.get(sort_by)] > o2[hsmap.get(sort_by)]) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        return answer;
    }

}
