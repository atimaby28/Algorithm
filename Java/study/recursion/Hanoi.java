package recursion;

public class Hanoi {

    public static void main(String[] args) {
        hanoi(3, 1, 2, 3);
    }

    private static void hanoi(int n, int start, int temp, int dest) {

        if(n == 0) return;
        // 자신의 위쪽의 n-1개 원판 들어내기 : 임시 기둥으로 옮기기
        hanoi(n-1, start, dest, temp);
        // 자신의 n번째 원판 옮기기 : 목적기둥
        System.out.println(n + ":" + start + ">" + dest);
        // 들어냈던 임시기둥의 n-1개 원판 자신위에 쌓기 : 목적기둥으로 옮기기
        hanoi(n-1, temp, start, dest);
    }

}
