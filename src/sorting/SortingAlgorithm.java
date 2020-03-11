package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SortingAlgorithm {

    public static void main(String[] args) {

        FastReader reader = new FastReader();

        int size = reader.nextInt();

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = reader.nextInt();
        }

        radixSort(array);
    }

    private static int[] radixSort(int[] array) {

        int chunkIndex = 1;

        int[] weights = new int[array.length];

        while (calculateWeights(array, weights, chunkIndex)) {

            array = countingSort(array, weights);

            for (int number : array) {

                System.out.print(number + " ");
            }

            System.out.println();

            chunkIndex++;
        }

        return array;
    }

    private static int[] countingSort(int[] originalArray, int[] weights) {

        int[] array = new int[originalArray.length];

        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int weight : weights) {

            if (weight > max) {
                max = weight;
            }

            if (weight < min) {
                min = weight;
            }
        }

        int[] frequencies = new int[max - min + 1];

        for (int i = 0; i < weights.length; i++) {
            frequencies[weights[i] - min]++;
        }

        int sum = 0;

        for (int i = 0; i < frequencies.length; i++) {

            sum += frequencies[i];

            frequencies[i] = sum;
        }

        for (int i = array.length - 1; i >= 0; i--) {

            int weight = weights[i];

            int index = frequencies[weight - min] - 1;

            array[index] = originalArray[i];

            frequencies[weight - min]--;
        }

        return array;
    }

    private static boolean calculateWeights(int[] array, int[] weights, int chunkIndex) {

        boolean hasNonZeroWeight = false;

        for (int i = 0; i < array.length; i++) {

            weights[i] = (array[i] % (int) Math.pow(10, 5 * chunkIndex))
                    / (int) Math.pow(10, 5 * (chunkIndex - 1));

            if (weights[i] != 0) {
                hasNonZeroWeight = true;
            }
        }

        return hasNonZeroWeight;
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
