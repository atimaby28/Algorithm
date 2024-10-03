package level3.week1;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level3_불량사용자 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        String[] user_id = new String[p];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < user_id.length; i++) {
            user_id[i] = st.nextToken();
        }

        String[] banned_id = new String[q];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < banned_id.length; i++) {
            banned_id[i] = st.nextToken();
        }

        int result = solution(user_id, banned_id);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;



        return answer;
    }

}
