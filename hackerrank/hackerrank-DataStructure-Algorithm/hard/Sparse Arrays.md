[題目](https://www.hackerrank.com/challenges/sparse-arrays/problem)


```java
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries) {
        int result [] = new int[queries.length];
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<strings.length; i++){
            // System.out.println(strings[i]);
            if (map.containsKey(strings[i])){
                int val = map.get(strings[i]);
                val++;
                map.put(strings[i], val);
            } else {
                map.put(strings[i], map.getOrDefault(strings[i], 1));
            }
        }
        map.forEach((k, v) -> System.out.println(k + ": " + v));
        for (int i=0; i<queries.length; i++){
            if (map.containsKey(queries[i])){
                result[i] = map.get(queries[i]);
            } else {
                result[i] = 0;
            }
        }
        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] strings = new String[stringsCount];

        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = scanner.nextLine();
            strings[i] = stringsItem;
        }

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] queries = new String[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = scanner.nextLine();
            queries[i] = queriesItem;
        }

        int[] res = matchingStrings(strings, queries);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
```