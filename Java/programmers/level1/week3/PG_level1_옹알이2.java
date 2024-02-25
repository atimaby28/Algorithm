package level1.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level1_옹알이2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        String[] babbling = new String[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < babbling.length; i++) {
            babbling[i] = st.nextToken();
        }

        int result = solution(babbling);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(String[] babbling) {
        int answer = 0;

        String[] bap_List = {"aya", "ye", "woo", "ma"};
        String[] bac_List = {"ayaaya", "yeye", "woowoo", "mama"};

        for (int i = 0; i < babbling.length; i++) {
            for (int j = 0; j < bac_List.length; j++) {
                if(babbling[i].contains(bac_List[j])) {
                    babbling[i] = babbling[i].replaceAll(bac_List[j], "X");
                } else {
                    babbling[i] = babbling[i].replaceAll(bap_List[j], "*");
                }
            }
        }

        for (int i = 0; i < babbling.length; i++) {
            babbling[i] = babbling[i].replaceAll("[\\*]", "");
        }

        for (String str : babbling) {
            System.out.println(str);
            if(str.isEmpty()) {
                answer++;
            }
        }

        return answer;
    }

}
