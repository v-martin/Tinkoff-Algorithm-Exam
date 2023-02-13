import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class taskThree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(str.split(" ")[0]);
        int m = Integer.parseInt(str.split(" ")[1]);
        int k = Integer.parseInt(str.split(" ")[2]);
        int[] scopes = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int swapsCount = 0;
        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < m; i++) {
            str = br.readLine();
            int first = Integer.parseInt(str.split(" ")[0]) - 1;
            int second = Integer.parseInt(str.split(" ")[1]) - 1;
            if (scopes[first] != scopes[second] && !(set.contains(first) && set.contains(second))) {
                    set.add(first);
                    set.add(second);
                    swapsCount++;
            }
        }

        System.out.println(swapsCount);
    }
}
