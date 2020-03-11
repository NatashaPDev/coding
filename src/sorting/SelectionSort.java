package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SelectionSort {

    public static void main(String[] args) {

        FastReader reader = new FastReader();

        int size = reader.nextInt();

        int steps = reader.nextInt();

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = reader.nextInt();
        }

        sortByStep(array, steps);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private static void sortByStep(int[] array, int steps) {

        for (int i = 0; i < steps; i++) {

            int minimum = i;

            for (int j = i + 1; j < array.length; j++) {

                if (rightIsSmaller(array[minimum], array[j])) {
                    minimum = j;
                }
            }

            swap(minimum, i, array);
        }
    }

    private static void swap(int minimum, int i, int[] array) {

        int temp = array[minimum];
        array[minimum] = array[i];
        array[i] = temp;
    }

    private static boolean rightIsSmaller(int minimum, int i) {
        return i < minimum;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
