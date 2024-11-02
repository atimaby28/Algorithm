package percompow;

public class PerComPow {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        boolean[] visited = new boolean[array.length];

        System.out.println("========================= Permutation =========================");
        permutation(array, new int[array.length], visited, 0);

        System.out.println("========================= Combination =========================");
        int r = 3;
        combination(array, new int[r], 0, 0, r);

        System.out.println("========================= Powerset =========================");
        powerset(array, new int[array.length], 0, 0);
    }

    private static void permutation(int[] array, int[] result, boolean[] visited, int depth) {
        if(depth == array.length) {
            for (int i = 0; i < result.length; i++) {
                if(visited[i]) System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < array.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[depth] = array[i];
                permutation(array, result, visited, depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void combination(int[] array, int[] result, int index, int depth, int r) {
        if(depth == r) {
            for (int e : result) System.out.print(e + " ");
            System.out.println();
            return;
        }

        for (int i = index; i < array.length; i++) {
            result[depth] = array[i];
            combination(array, result, i + 1, depth + 1, r);
        }
    }

    private static void powerset(int[] array, int[] result, int index, int depth) {

        System.out.print("{ ");
        for (int i = 0; i < depth; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println("}");

        for (int i = index; i < array.length; i++) {
            result[depth] = array[i];
            powerset(array, result, i + 1, depth + 1);
        }
    }

}
