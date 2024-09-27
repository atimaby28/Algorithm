package level3.week1;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PG_level3_숫자게임 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int p = Integer.parseInt(br.readLine());

        int[] A = new int[p];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int q = Integer.parseInt(br.readLine());

        int[] B = new int[q];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B.length; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(A, B);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(int[] A, int[] B) {
        int answer = -1;

        PriorityQueue<Integer> aQueue = new PriorityQueue<>();
        PriorityQueue<Integer> bQueue = new PriorityQueue<>();

        for(int i = 0; i < A.length; i++) {
            aQueue.offer(A[i]);
            bQueue.offer(B[i]);
        }

        while(!bQueue.isEmpty()) {
            if(aQueue.peek() >= bQueue.peek()) {
                bQueue.poll();
            } else {
                aQueue.poll();
                bQueue.poll();
            }
        }

        answer = A.length - aQueue.size();

        return answer;
    }

//    public int solution(int[] A, int[] B) {
//        int answer = 0;
//
//        Arrays.sort(A);
//        Arrays.sort(B);
//
//        for (int i = A.length - 1, j = B.length - 1; i >= 0; i--) {
//            if(A[i] < B[j]) {
//                answer++;
//                j--;
//            }
//        }
//
//        return answer;
//    }


}
