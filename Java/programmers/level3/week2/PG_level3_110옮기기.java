package level3.week2;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class PG_level3_110옮기기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        String[] s = new String[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < s.length; i++) {
            s[i] = st.nextToken();
        }

        String[] result = solution(s);

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    public static String[] solution(String[] s) {
        String[] results = new String[s.length];

        for (int i = 0; i < s.length; i++) {
            String x = s[i];
            Stack<Character> stack = new Stack<>();
            int count110 = 0;

            // "110" 추출
            for (char ch : x.toCharArray()) {
                stack.push(ch);
                if (stack.size() >= 3) {
                    char third = stack.pop();
                    char second = stack.pop();
                    char first = stack.pop();

                    if (first == '1' && second == '1' && third == '0') {
                        count110++;
                    } else {
                        stack.push(first);
                        stack.push(second);
                        stack.push(third);
                    }
                }
            }

            // 남은 문자열 재구성
            StringBuilder sb = new StringBuilder();

            int index = -1, size = stack.size() - 1;

            // '110'을 뽑아낸 문자열에 '0'이 있을 때 가장 뒤에 있는 0 다음에 110을 넣는 경우가 가장 작아진다
            while(!stack.isEmpty()) {
                char value = stack.pop();
                sb.insert(0, value);
                if(index == -1 && value == '0') {
                    index = size;
                }
                size--;
            }

            // '110'을 뽑아낸 문자열에 '0'이 없을 때 제일 앞에 110을 넣는 경우가 가장 작아진다
            int offset = index == -1 ? 0 : index + 1;

            while(count110-- > 0) {
                sb.insert(offset, "110");
            }

            results[i] = sb.toString();
        }

        return results;
    }
}
