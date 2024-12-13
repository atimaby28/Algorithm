package silver.one;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_11286_절댓값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        String result = solution(array);

        bw.write(result + "\n");

        bw.flush();

        br.close();
        bw.close();
    }

    private static String solution(int[] array) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (o1, o2) -> {
                 int abs1 = Math.abs(o1);
                 int abs2 = Math.abs(o2);

                 if (abs1 == abs2)
                     return o1 > o2 ? 1 : -1;
                 else
                    return Integer.compare(abs1, abs2);
                }
        );

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            if(array[i] != 0) {
                pq.offer(array[i]);
            } else if (array[i] == 0){
                if(pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            }
        }

        return sb.toString();
    }
}
