package level1.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level1_소수만들기 {

    public static  int ans = 0;
    public static  boolean[] isSelected;
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
        int answer = -1;

        isSelected = new boolean[nums.length];
        combination(nums, 0, 3);

        return answer;
    }

    private static void combination(int[] nums, int i, int r) {
        if(r == 0){
            int sum = 0;
            for (int j = 0; j < isSelected.length; j++) {
                if(isSelected[j] == true) {
                    sum += nums[j];
                }
            }

            if(isPrime(sum)) {
                ans++;
            }

            return;
        }

        for (int j = i; j < nums.length; j++) {
            isSelected[j] = true;
            combination(nums, j + 1, r - 1);
            isSelected[j] = false;
        }

    }

    private static boolean isPrime(int sum) {
        for (int i = 2; i < sum; i++) {
            if(sum % i == 0) {
                return  false;
            }
        }
        return  true;
    }

//    public static Boolean isPrime(int num){
//        int cnt = 0;
//        for(int i = 1; i <= (int)Math.sqrt(num); i ++){
//            if(num % i == 0) cnt += 1;
//        }
//        return cnt == 1;
//    }

}
