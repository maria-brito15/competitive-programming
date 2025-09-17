import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int m = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                char newChar = (char) ('A' + (c - 'A' - m + 26) % 26);
                sb.append(newChar);
            }

            System.out.println(sb.toString());
        }
    }
}
