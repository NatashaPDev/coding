package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NiceStrings {

    public static void main(String[] args) {

        FastReader reader = new FastReader();

        int stringsCount = reader.nextInt();

        String[] strings = new String[stringsCount];

        for (int i = 0; i < stringsCount; i++) {
            strings[i] = reader.next();
        }

        String[] sortedStrings = insertionSort(strings);
    }

    private static String[] insertionSort(String[] strings) {

        String[] stringsCopy = Arrays.copyOf(strings, strings.length);

        int currentNotSortedStringIndex = 1;

        System.out.println(0);

        while (currentNotSortedStringIndex < stringsCopy.length) {

            String currentStringToSort = stringsCopy[currentNotSortedStringIndex];

            int indexToCompare = currentNotSortedStringIndex - 1;

            while (indexToCompare >= 0) {

                if (rightStringLexicographicallySmallerOrEqual(stringsCopy[indexToCompare], currentStringToSort)) {

                    swap(indexToCompare + 1, indexToCompare, stringsCopy);

                    indexToCompare--;

                } else {
                    break;
                }


            }

            System.out.println(indexToCompare + 1);

            currentNotSortedStringIndex++;
        }

        return stringsCopy;
    }

    private static void swap(int currentNotSortedStringIndex, int indexToCompare, String[] strings) {

        String temp = strings[indexToCompare];

        strings[indexToCompare] = strings[currentNotSortedStringIndex];
        strings[currentNotSortedStringIndex] = temp;
    }

    private static boolean rightStringLexicographicallySmallerOrEqual(String leftString, String rightString) {

        return rightString.compareTo(leftString) <= 0;
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
