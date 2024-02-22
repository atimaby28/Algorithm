package level1.week3;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PG_level1_추억점수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int m = Integer.parseInt(br.readLine());

        String[] name = new String[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < name.length; i++) {
            name[i] = st.nextToken();
        }

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] yearning = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < yearning.length; i++) {
            yearning[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        String[][] photo = new String[p][q];

        for (int i = 0; i < photo.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < photo[i].length; j++) {
                photo[i][j] = st.nextToken();
            }

        }

        int[] result = solution(name, yearning, photo);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }
    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        HashMap<String, Integer> hsmap = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            hsmap.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            int sum = 0;
            for (int j = 0; j < photo[i].length; j++) {
                sum += hsmap.getOrDefault(photo[i][j], 0);
            }
            answer[i] = sum;
        }

        return answer;
    }

}
