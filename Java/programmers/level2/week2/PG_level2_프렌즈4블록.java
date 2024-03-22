package level2.week2;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class PG_level2_프렌즈4블록 {

    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());
        String[] board = new String[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < board.length; i++) {
            board[i] = st.nextToken();
        }

        int result = solution(m, n, board);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }


    public static int solution(int m, int n, String[] board) {
        int answer = 0;

        HashMap<Character, int[]> hashMap = new HashMap<>();

        for (char i = 'A'; i <= 'Z'; i++) {
            hashMap.put(i, new int[n]);
        }

        int[] check = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i].charAt(j);
                hashMap.get(c)[j]++;
            }
        }

        System.out.println(hashMap);

        for (char i = 'A'; i <= 'Z'; i++) {
            int sum = 0;

            for (int j = 0; j < hashMap.get(i).length - 1; j++) {
                if(hashMap.get(i)[j] >= 2 && hashMap.get(i)[j + 1] >= 2) {
                    
                }
            }
            for (int z : hashMap.get(i)) {
                if(z >= 2) {
                    sum += z;
                }
                System.out.print(z + " ");
            }
            System.out.println();
        }

        System.out.println();

        return answer;
    }

}
