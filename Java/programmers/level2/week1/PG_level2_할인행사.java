package level2.week1;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PG_level2_할인행사 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int a = Integer.parseInt(br.readLine());

        String[] want = new String[a];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < want.length; i++) {
            want[i] = st.nextToken();
        }

        int b = Integer.parseInt(br.readLine());

        int[] number = new int[b];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < number.length; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        int c = Integer.parseInt(br.readLine());

        String[] discount = new String[c];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < discount.length; i++) {
            discount[i] = st.nextToken();
        }

        int result = solution(want, number, discount);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        HashMap<String, Integer> wantHash = new HashMap<>();
        HashMap<String, Integer> dayHash = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            wantHash.put(want[i], number[i]);
        }

        for (int i = 0; i < discount.length - 9; i++) {
            for (int j = i; j < i + 10; j++) {
                dayHash.put(discount[j], dayHash.getOrDefault(discount[j], 0) + 1);
            }

            boolean flag = false;
            for (int j = 0; j < want.length; j++) {
                if(wantHash.get(want[j]) <= dayHash.getOrDefault(want[j], -1)) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                answer++;
            }
            dayHash.clear();
        }
        return answer;
    }
}