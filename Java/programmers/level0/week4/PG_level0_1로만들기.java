package level0.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_1로만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[] num_list = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num_list.length; i++) {
            num_list[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(num_list);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int[] num_list) {
        int answer = 0;

        for (int i = 0; i < num_list.length; i++) {
            int temp = num_list[i];
            while (temp > 1) {
                if(temp % 2 != 0) {
                    temp -= 1;
                    temp /= 2;
                } else {
                    temp /= 2;
                }
                answer++;
            }
        }
        return answer;
    }

//    int 타입이라 1을 뺄 필요가 없음.
//    public int solution(int[] num_list) {
//        int answer = 0;
//        for(int i = 0;num_list.length>i;i++){
//            while(num_list[i]!=1){
//                num_list[i]/=2;
//                answer++;
//            }
//        }
//        return answer;
//    }

}
