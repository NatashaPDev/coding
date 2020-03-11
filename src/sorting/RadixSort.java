package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RadixSort {

    public static void main(String[] args) {

        FastReader reader = new FastReader();

        int size = reader.nextInt();

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = reader.nextInt();
        }

        radix(array);
    }

    private static void radix(int[] array) {

        OptionalInt maxNumber = Arrays.stream(array)
                .max();

        if (!maxNumber.isPresent()) {
            return;
        }

        TreeMap<Integer, List<Integer>> frequencies = new TreeMap<>();

        int bit = 10;

        int maxDigit = 0;

        int division;

        do {

            division = maxNumber.getAsInt() / bit;

            maxDigit++;

            bit *= 10;

        } while (division > 0);

        for (int i = 0; i < maxDigit; i++) {

            for (int f = 0; f < 10; f++) {
                frequencies.put(f, new ArrayList<>());
            }

            for (int j = 0; j < array.length; j++) {

                int modulo = array[j]
                        / (int) Math.pow(10, i)
                        % 10;

                List<Integer> numbers = frequencies.get(modulo);

                numbers.add(array[j]);
            }

            int index = 0;

            for (List<Integer> numbers : frequencies.values()) {

                for (Integer number : numbers) {

                    array[index] = number;

                    System.out.print(array[index] + " ");

                    index++;
                }
            }

            System.out.println();
        }
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
