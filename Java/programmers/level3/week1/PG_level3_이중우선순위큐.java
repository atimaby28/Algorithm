package level3.week1;

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class PG_level3_이중우선순위큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());

        String[] operations = new String[k];

        for (int i = 0; i < operations.length; i++) {
            operations[i] = br.readLine();
        }

        int[] result = solution(operations);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());

        for(String operation : operations) {

            String[] data = operation.split(" ");

            int num = Integer.parseInt(data[1]);

            if(data[0].equals("I")) {
                pqMin.offer(num);
                pqMax.offer(num);
            }

            if(pqMin.isEmpty() && pqMax.isEmpty()) {
                continue;
            }

            if(data[0].equals("D")) {
                if(num > 0) {
                    pqMin.remove(pqMax.poll());
                } else {
                    pqMax.remove(pqMin.poll());
                }
            }

        }

        if(!pqMin.isEmpty() && !pqMax.isEmpty()) {
            answer[0] = pqMax.poll();
            answer[1] = pqMin.poll();
        }

        return answer;
    }

}
