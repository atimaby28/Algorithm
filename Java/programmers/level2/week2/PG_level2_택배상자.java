package level2.week2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class PG_level2_택배상자 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int k = Integer.parseInt(br.readLine());

        int[] order = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < order.length; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(order);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(int[] order) {
        int answer = 0;

        Stack<Integer> assist = new Stack<>();
        Queue<Integer> conveyorBelt = new LinkedList<>();

        int cnt = 0;
        for (int i = 0; i < order.length; i++) {
            assist.add(i + 1);

            while (!assist.isEmpty()) {
                if (assist.peek() == order[cnt]) {
                    conveyorBelt.offer(assist.pop());
                    cnt++;
                } else break;

            }
        }

        answer = conveyorBelt.size();

        return answer;
    }

}

//5
//4 7 2 5 1

//10
//2 1 4 3 6 5 8 7 10 9