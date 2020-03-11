package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeingMonitor {

    public static void main(String[] args) {

        FastReader reader = new FastReader();

        int testCaseCount = reader.nextInt();

        for (int i = 0; i < testCaseCount; i++) {

            int studentCount = reader.nextInt();

            int[] studentHeights = new int[studentCount];

            for (int j = 0; j < studentCount; j++) {

                studentHeights[j] = reader.nextInt();
            }

            int maxDifference = getMaxDifference(studentHeights);

            if (maxDifference == 0) {
                System.out.println("-1");
            } else {
                System.out.println(maxDifference);
            }
        }
    }

    private static int getMaxDifference(int[] studentHeights) {

        int max = 0;

        for (int i = 0; i < studentHeights.length; i++) {
            if (studentHeights[i] > max) {
                max = studentHeights[i];
            }
        }

        int[] frequencies = new int[max + 1];

        for (int i = 0; i < studentHeights.length; i++) {
            frequencies[studentHeights[i]]++;
        }

        int maxDifference = 0;
        int minFrequency = Integer.MAX_VALUE;

        for (int i = 0; i < frequencies.length; i++) {

            if (frequencies[i] != 0) {

                int currentFrequency = frequencies[i];

                int currentDifference = currentFrequency - minFrequency;

                if (currentDifference > maxDifference) {
                    maxDifference = currentDifference;
                }

                minFrequency = Math.min(minFrequency, currentFrequency);
            }
        }

        return maxDifference;
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
