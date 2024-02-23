package level1.week3;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PG_level1_폰켓몬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int p = Integer.parseInt(br.readLine());

        int[] nums = new int[p];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(nums);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int[] nums) {
        int answer = 0;

        HashMap<Integer, Integer> hsmap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hsmap.put(nums[i], hsmap.getOrDefault(nums[i], 0) + 1);
        }

        if(hsmap.size() >= nums.length / 2) {
            answer = nums.length / 2;
        } else if(hsmap.size() < nums.length / 2){
            answer = hsmap.size();
        }

        return answer;
    }
}
