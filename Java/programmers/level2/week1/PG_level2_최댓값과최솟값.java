package level2.week1;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class PG_level2_최댓값과최솟값 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        String result = solution(s);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(String s) {
        String answer = "";

        String[] strArr = s.split(" ");
        // Integer[] newArr = Stream.of(s).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        int[] nums = Stream.of(strArr).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(nums);

        answer = nums[0] + " " + nums[nums.length - 1];

        return answer;
    }

//    public static String solution(String s) {
//        String answer = "";
//
//        String[] str = s.split(" ");
//
//        Arrays.sort(str, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                int i1 = Integer.parseInt(o1);
//                int i2 = Integer.parseInt(o2);
//                if(i1 < 0 && i2 < 0) {
//                    if(i1 < i2) {
//                        return -1;
//                    } else {
//                        return  1;
//                    }
//                } else {
//                    if(i1 > i2) {
//                        return 1;
//                    } else {
//                        return  -1;
//                    }
//                }
//            }
//        });
//
//        answer = str[0] + " " + str[str.length - 1];
//
//        return answer;
//    }

}
