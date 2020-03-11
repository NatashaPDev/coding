import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class TakeWalk {

    private static final HashSet<Character> VOWEL_SET = new HashSet<>(
            Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));

    public static void main(String[] args) {

        FastReader reader = new FastReader();

        int testCount = reader.nextInt();

        for (int i = 0; i < testCount; i++) {

            String string = reader.nextLine();

            int vowelCount = countVowels(string);

            System.out.println(vowelCount);
        }
    }

    private static int countVowels(String string) {

        int vowelCount = 0;

        char[] chars = string.toCharArray();

        for (char character : chars) {

            if (VOWEL_SET.contains(character)) {
                vowelCount++;
            }
        }

        return vowelCount;
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
