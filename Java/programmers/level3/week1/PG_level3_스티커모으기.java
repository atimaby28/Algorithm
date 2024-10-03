package level3.week1;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level3_스티커모으기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());

        int[] sticker = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sticker.length; i++) {
            sticker[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(sticker);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(int[] sticker) {
        int answer = 0;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }

}
