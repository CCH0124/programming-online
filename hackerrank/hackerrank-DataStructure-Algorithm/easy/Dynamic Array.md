[題目](https://www.hackerrank.com/challenges/dynamic-array/problem)


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
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */
    private static List<List<Integer>> seqList = new ArrayList<>();
    private static int lastAnswer = 0;
    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
    // Write your code here
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<n; i++){
            seqList.add(new ArrayList<Integer>());
        }

        for(int i=0; i<queries.size(); i++){
            List<Integer> list = queries.get(i);
            int type = list.get(0);
            if(type == 1){
                appendValue(list.get(1), list.get(2), n);
            } else {
                printValue(list.get(1), list.get(2), n);
                result.add(lastAnswer);
            }
        }
        return result;

    }
    public static void appendValue(int x, int y, int n){
        int index = findSequence(x, lastAnswer, n);
        seqList.get(index).add(y);
    }
    public static void printValue(int x, int y, int n){
        int index = findSequence(x, lastAnswer, n);
        List<Integer> seq = seqList.get(index);
        lastAnswer = seq.get(y % seq.size());
    }
    private static int findSequence(int x, int lastAnswer, int n){
        return (x^lastAnswer)%n;
    }
}   

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.dynamicArray(n, queries);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

```