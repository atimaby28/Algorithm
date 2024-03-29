package level0.week4;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class PG_level0_커피심부름 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int k = Integer.parseInt(br.readLine());

        String[] order = new String[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < order.length; i++) {
            order[i] = st.nextToken();
        }

        int result = solution(order);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(String[] order) {
        int answer = 0;

        for (int i = 0; i < order.length; i++) {
            if (order[i].contains("cafelatte")) {
                answer += 5000;
            } else {
                answer += 4500;
            }
        }


        return answer;
    }

}
