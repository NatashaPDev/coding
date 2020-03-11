package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ModuloSort {

    public static void main(String[] args) {

        FastReader reader = new FastReader();

        int elementCount = reader.nextInt();

        int moduloNumber  = reader.nextInt();

        int[] array = new int[elementCount];

        for (int i = 0; i < elementCount; i++) {
            array[i] = reader.nextInt();
        }

        int[] sortedArray = sortByModulo(array, moduloNumber);

        for (int i = 0; i < sortedArray.length; i++) {
            System.out.print(sortedArray[i] + " ");
        }
    }

    private static int[] sortByModulo(int[] array, int moduloNumber) {

        TreeMap<Integer, List<Integer>> numbersByModulo = new TreeMap<>();

        for (int i = 0; i < array.length; i++) {

            numbersByModulo
                    .computeIfAbsent(array[i] % moduloNumber, k -> new ArrayList<>())
                    .add(array[i]);

        }

        int[] sortedArray = new int[array.length];

        int index = 0;

        for (List<Integer> value : numbersByModulo.values()) {

            for (Integer number : value) {

                sortedArray[index] = number;

                index++;
            }
        }

        return sortedArray;
    }

    private static class FastReader {
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
