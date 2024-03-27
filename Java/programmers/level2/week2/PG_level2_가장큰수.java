package level2.week2;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class PG_level2_가장큰수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int k = Integer.parseInt(br.readLine());

        int[] numbers = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        String result = solution(numbers);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(int[] numbers) {
        String answer = "";

        String[] strArr = new String[numbers.length];

        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(0) > o2.charAt(0)) {
                    return -1;
                } else if (o1.charAt(0) < o2.charAt(0)){
                    return 1;
                } else {
                    if(o1.length() >= 2 && o2.length() == 1) {
                        return o2.charAt(0) - o1.charAt(1);
                    } else if(o1.length() == 1 && o2.length() >= 2) {
                        return o2.charAt(1) - o1.charAt(0);
                    } else if(o1.length() >= 3 && o2.length() == 2) {
                        return o2.charAt(1) - o1.charAt(2);
                    } else if(o1.length() == 2 && o2.length() >= 3) {
                        return o2.charAt(2) - o1.charAt(1);
                    } else if(o1.length() >= 4 && o2.length() == 3) {
                        return o2.charAt(2) - o1.charAt(3);
                    } else if(o1.length() == 3 && o2.length() >= 4) {
                        return o2.charAt(3) - o1.charAt(2);
                    } else {
                        if(o2.length() == 2 && o1.length() == 2) {
                            return o2.charAt(1) - o1.charAt(1);
                        } else {
                            return o2.charAt(2) - o1.charAt(2);
                        }
                    }
                }
            }
        });

        for (String str : strArr) {
            answer += str;
        }

        return answer;
    }

}

//
//else {
//        if(o2.length() == 2 && o1.length() == 2) {
//        return o1.charAt(1) - o2.charAt(1);
//                        } else {
//                                if(o1.charAt(1) == o2.charAt(1)) {
//        return o1.charAt(2) - o2.charAt(2);
//                            } else {
//                                    return o2.charAt(1) - o1.charAt(1);
//                            }
//                                    }
//                                    }