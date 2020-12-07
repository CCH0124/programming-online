[題目](https://www.hackerrank.com/challenges/2d-array/problem)
```java
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.*;
public class Solution {
    private static final int FILTER_SIZE  = 3;
    private static final int STRIDE_SIZE  = 1;
    private static final int SIZE = (6-3+1);
    private static final int FILTER_ARR [][] = {{1,1,1}, {0,1,0}, {1, 1, 1}};

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int result [][] = new int[SIZE][SIZE];
        /**
         * row_init 移動起點
         * row_jump 移動終點
         **/
        int row_init = 0;
        int row_jump = 2;
        int col_down = 0;
        while (col_down <= 3){
            
            for (int j = 0; j < FILTER_SIZE; j++) {
                int index = 0;
                for (int k = row_init; k <= row_jump; k++) {
                    result[col_down][row_init] += arr[j+col_down][k] * FILTER_ARR[j][index++];
                }
            }
            row_init++;
            row_jump++;

            if (row_jump > 5){
                col_down++;
                row_init = 0;
                row_jump = 2;
            }
        }
       
        return Arrays.asList(result).parallelStream()
                .flatMapToInt((Arrays::stream)).max().getAsInt();

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

```
