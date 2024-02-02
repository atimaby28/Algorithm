package level0.week5;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_왼쪽오른쪽 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        String[] str_list = new String[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < str_list.length; i++) {
            str_list[i] = st.nextToken();
        }

        String[] result = solution(str_list);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String[] solution(String[] str_list) {
        String[] answer = {};

        int idx = 0;
        boolean flag = false;

        for (int i = 0; i < str_list.length; i++) {
            if (str_list[i].equals("l")) {
                idx = i;
                break;
            } else if (str_list[i].equals("r")) {
                idx = i;
                flag = true;
                break;
            }
        }

        if (flag) {
            answer = new String[str_list.length - idx - 1];

            for (int i = 0; i < answer.length; i++) {
                answer[i] = str_list[idx + 1 + i];
            }
        } else {
            answer = new String[idx];
            for (int i = 0; i < idx; i++) {
                answer[i] = str_list[i];
            }
        }

        return answer;
    }

//    public String[] solution(String[] str_list) {
//
//        for (int i = 0; i < str_list.length; i++) {
//
//            if ("l".equals(str_list[i])) {
//                return Arrays.copyOfRange(str_list, 0, i);
//            } else if ("r".equals(str_list[i])) {
//                return Arrays.copyOfRange(str_list, i + 1, str_list.length);
//            }
//        }
//
//        return new String[0];
//    }

}
