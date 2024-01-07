package exhaust_recursion;

import java.util.Arrays;

public class PerComPow {
    public static int[] num = {1, 2, 3};   // num={1,2,3,4}
    public static int N = 2;              // N=2, N=3
    public static int sCount = 0;

    private static void makePermutation(int toSelect, int[] selected, boolean[] visited) {
        if (toSelect == N) {
            System.out.println(Arrays.toString(selected));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[toSelect] = num[i];
                makePermutation(toSelect + 1, selected, visited);
                visited[i] = false;
            }
        }
    }

    //--------------------------------------------------------------------------------------
    private static void makeCombination(int toSelect, int[] selected, int startIdx) {
        if (toSelect == N) {
            System.out.println(Arrays.toString(selected));
            return;
        }
        for (int i = startIdx; i < num.length; i++) {
            selected[toSelect] = num[i];
            makeCombination(toSelect + 1, selected, i + 1);
        }
    }

    //--------------------------------------------------------------------------------------
    private static void powerSet(int cnt, boolean[] isSelected) {
        if (cnt == N) {
            sCount++;
            System.out.print("{");
            for (int i = 0; i < N; i++) {
                if (isSelected[i]) {
                    System.out.print(num[i] + " ");
                }
            }
            System.out.print("},");
            return;
        }

        isSelected[cnt] = false;
        powerSet(cnt + 1, isSelected);

        isSelected[cnt] = true;
        powerSet(cnt + 1, isSelected);
    }

    public static void main(String[] args) {
        System.out.println("-----순열-----");
        makePermutation(0, new int[N], new boolean[num.length]);

        System.out.println("-----조합-----");
        makeCombination(0, new int[N], 0);

        System.out.println("-----멱집합-----");
        powerSet(0, new boolean[N]);
        System.out.println("\n집합의 총 갯수: " + sCount);
    }
}
