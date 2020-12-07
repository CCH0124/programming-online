[題目](https://www.hackerrank.com/challenges/equal-stacks/problem)

```java
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
    // Write your code here
        int h1Sum = h1.stream().mapToInt(Integer::intValue).sum();
        int h2Sum = h2.stream().mapToInt(Integer::intValue).sum();
        int h3Sum = h3.stream().mapToInt(Integer::intValue).sum();

        int min = Math.min(h1Sum, Math.min(h2Sum,h3Sum));
        while(h1Sum != h2Sum || h2Sum != h3Sum){
            if (h1.size() == 0 || h2.size() == 0 || h3.size() == 0){
                return 0;
            }
            if (h3Sum > min){
                h3Sum -= h3.remove(0);
            }
            min = Math.min(h1Sum, Math.min(h2Sum,h3Sum));
            if (h2Sum > min){
                h2Sum -= h2.remove(0);
            }
            min = Math.min(h1Sum, Math.min(h2Sum,h3Sum));
            if (h1Sum > min){
                h1Sum -= h1.remove(0);
            }
            min = Math.min(h1Sum, Math.min(h2Sum,h3Sum));
        }
        return min;
    
    } 
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

```