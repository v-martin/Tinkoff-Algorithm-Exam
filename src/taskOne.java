import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class taskOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] str = input.split("");
        Queue<String> queue = new LinkedList<String>();
        String[] arr = {};
        Set<String> set = new HashSet<String>();
        int n = input.length();
        int lastIndex = 9;
        try {
            arr = input.substring(0, 10).split("");
            for (int i = 0; i < 10; i++) {
                queue.add(arr[i]);
            }
        } catch (Throwable e) {
            System.out.println("NO");
        }
        for (int i = 9; i < n-1; i++) {
            Collections.addAll(set, arr);
            long questionMarkCount = Arrays.stream(arr).filter(e -> e.equals("?")).count();
            int size = set.size();
            if (size + questionMarkCount > 10) {
                System.out.println("YES");
                lastIndex = i;
                break;
            }
            queue.add(str[i+1]);
            queue.remove();
            arr = queue.toArray(new String[0]);
            set.clear();
            lastIndex = i + 1;
        }

        if (lastIndex == n-1) {
            Collections.addAll(set, arr);
            long questionMarkCount = Arrays.stream(arr).filter(e -> e.equals("?")).count();
            int size = set.size();
            if (size + questionMarkCount > 10) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}