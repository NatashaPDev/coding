package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SuffixSort {

    public static void main(String[] args) {

        FastReader reader = new FastReader();

        String string = reader.next();

        int k = reader.nextInt();

        String[] suffices = getSuffices(string);

        String[] sortedSuffices = radixSort(suffices);

        System.out.println(sortedSuffices[k - 1]);
    }

    private static String[] radixSort(String[] strings) {

        int maxLength = 0;

        for (String string : strings) {

            if (string.length() > maxLength) {
                maxLength = string.length();
            }
        }

        int letterPosition = maxLength - 1;

        while (letterPosition >= 0) {

            strings = countingSort(strings, letterPosition);

            letterPosition--;
        }

        return strings;
    }

    private static String[] countingSort(String[] strings, int letterPosition) {

        int[] frequencies = new int[Character.MAX_VALUE];

        for (String string : strings) {

            char letter = getLetterByPosition(letterPosition, string);

            frequencies[letter]++;
        }

        int sum = 0;

        for (int i = 0; i < frequencies.length; i++) {

            sum += frequencies[i];

            frequencies[i] = sum;
        }

        String[] output = new String[strings.length];

        for (int i = strings.length - 1; i >= 0 ; i--) {

            String string = strings[i];

            char letter = getLetterByPosition(letterPosition, string);

            int index = frequencies[letter] - 1;

            output[index] = string;

            frequencies[letter]--;
        }

        return output;
    }

    private static char getLetterByPosition(int letterPosition, String string) {

        if (string.length() - 1 < letterPosition) {
            return 0;
        }

        char[] letters = string.toCharArray();

        return letters[letterPosition];
    }

    private static String[] getSuffices(String string) {

        String[] suffices = new String[string.length()];

        for (int i = 0; i < suffices.length; i++) {

            suffices[i] = string.substring(i);
        }

        return suffices;
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
