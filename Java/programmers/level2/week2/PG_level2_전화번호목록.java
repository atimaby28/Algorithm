package level2.week2;

import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PG_level2_전화번호목록 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int k = Integer.parseInt(br.readLine());
        String[] phone_book = new String[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < phone_book.length; i++) {
            phone_book[i] = st.nextToken();
        }

        boolean result = solution(phone_book);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 1; j < phone_book[i].length(); j++) {
                if(map.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }

        return answer;
    }
}
