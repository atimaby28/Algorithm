package platinum.five;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BJ_11003_최솟값찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        String result = solution(nums, l);

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    private static String solution(int[] nums, int l) {
        
        Deque<Node> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            Node node = new Node(i, nums[i]);

            while (!deque.isEmpty() && deque.getLast().value > node.value) {
                deque.pollLast();
            }

            deque.offer(node);

            if (deque.getFirst().index <= i - l) {
                deque.pollFirst();
            }

            sb.append(deque.getFirst().value).append(" ");

        }

        return sb.toString();
    }

    static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

}
