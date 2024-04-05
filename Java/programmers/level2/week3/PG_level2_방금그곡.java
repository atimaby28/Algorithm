package level2.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_방금그곡 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        String m = br.readLine();

        int k = Integer.parseInt(br.readLine());

        String[] musicinfos = new String[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < musicinfos.length; i++) {
            musicinfos[i] = st.nextToken();
        }

        String result = solution(m, musicinfos);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(String m, String[] musicinfos) {
        String answer = "";
        return answer; 
    }
}
