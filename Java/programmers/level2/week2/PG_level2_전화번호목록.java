package level2.week2;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
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

        HashMap<String, Boolean> hashMap = new HashMap<>();

        Arrays.sort(phone_book, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length()) {
                    return 1;
                } else if(o1.length() < o2.length()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });


        for (int i = 0; i < phone_book.length; i++) {
            int size = phone_book[i].length();
            for (int j = i; j < phone_book.length; j++) {
                String key = phone_book[j].substring(0, size);
                if(hashMap.containsKey(key)) {
                    answer = false;
                    break;
                } else {
                    hashMap.put(key, true);
                }
            }
            hashMap.clear();
        }

        return answer;
    }
}
