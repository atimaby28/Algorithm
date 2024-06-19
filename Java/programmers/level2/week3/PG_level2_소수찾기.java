package level2.week3;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PG_level2_소수찾기 {
    public static Set<Integer> erathosSet = new HashSet<>();
    public static Set<Integer> permuSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String numbers = br.readLine();

        int result = solution(numbers);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

//    public static int solution(String numbers) {
//        int answer = 0;
//
//        char[] numArr = numbers.toCharArray();
//
//        Arrays.sort(numArr);
//
//        String number = "";
//        for (int i = numArr.length - 1; i >= 0; i--) {
//            number += numArr[i];
//        }
//
//        int intNumber = Integer.parseInt(number);
//
//        boolean[] isPrime = erastos(intNumber);
//
//        for (int i = 2; i < isPrime.length; i++) {
//            if (!isPrime[i]) {
//                erathosSet.add(i);
//            }
//        }
//
//        char[] output = new char[numArr.length];
//
//        for (int r = 1; r <= numArr.length; r++) {
//            permutation(numArr, output, new boolean[numArr.length], 0, numArr.length, r);
//        }
//
//
//        System.out.println(erathosSet);
//        System.out.println(permuSet);
//
//        erathosSet.retainAll(permuSet);
//
//        answer = erathosSet.size();
//
//        return answer;
//    }
//
//    private static boolean[] erastos(int number) {
//
//        boolean[] isPrime = new boolean[number + 1];
//
//        isPrime[0] = isPrime[1] = true;
//
//        if (number < 2) {
//            return isPrime;
//        }
//
//        for (int i = 2; i < Math.sqrt(number); i++) {
//            if (isPrime[i]) {
//                continue;
//            }
//
//            for (int j = i * i; j < isPrime.length; j += i) {
//                isPrime[j] = true;
//            }
//        }
//        return isPrime;
//    }
//
//    static void permutation(char[] arr, char[] output, boolean[] visited, int depth, int n, int r) {
//        if (depth == r) {
//            String permuNum = "";
//            for (int i = 0; i < r; i++) {
//                permuNum += output[i];
//            }
//
//            permuSet.add(Integer.parseInt(permuNum));
//
//            return;
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (visited[i] != true) {
//                visited[i] = true;
//                output[depth] = arr[i];
//                permutation(arr, output, visited, depth + 1, n, r);
//                visited[i] = false;
//            }
//        }
//    }

    public static int solution(String numbers) {
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);

        System.out.println(set);

        int count = 0;
        while (set.iterator().hasNext()) {
            int a = set.iterator().next();
            set.remove(a);
            if (a == 2) count++;
            if (a % 2 != 0 && isPrime(a)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;
        for (int i = 3; i <= (int) Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        //if (n == 0) System.out.println(prefix);
        if (!prefix.equals("")) set.add(Integer.parseInt(prefix));
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), set);

    }

}
