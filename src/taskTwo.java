import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class taskTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        String str = "";
        int max = -1;
        int index = 0;

        for (int i = 0; i < n; i++) {
            str = br.readLine();
            String tempType = str.split(" ")[1];
            if (tempType.equals("-")) {
               arr1[i] = Integer.parseInt(str.split(" ")[0]);
               arr2[i] = -1;
            }
            else {
                arr1[i] = Integer.parseInt(str.split(" ")[0]);
                arr2[i] = 1;
            }
        }

        if (Arrays.stream(arr2).sum() == n) {
            System.out.println("inf");
            System.exit(0);
        }

        for (int i = 0; i < n - 1; i++) {
            if (arr2[i] == -1 && arr2[i+1] == 1) {
                index = i;
                break;
            }
        }

        for (int i = index + 1; i < n; i++) {
            max += arr1[i];
        }

        System.out.println(max);
    }
}
