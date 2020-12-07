[Find the Running Median](https://www.hackerrank.com/challenges/find-the-running-median/problem)


```java
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the runningMedian function below.
     */

    static double[] runningMedian(int[] a) {
        /*
         * Write your code here.
         */
        // max heap
        PriorityQueue<Integer> max = new PriorityQueue<Integer>(Collections.reverseOrder());
        // min heap
        PriorityQueue<Integer> min = new PriorityQueue<Integer>();
        double [] med = new double[a.length];
        int index = 0;
        int len = 0;
        double median = 0.0;
        while(len < a.length){
            int val = a[len];
            // 判別該樹差是否有等於 1 的情況
            if(min.size() == max.size()){
                if (val < median){
                    max.add(val);
                    median = max.peek();
                    med[index] = median;
                    index += 1;
                } else {
                    min.add(val);
                    median = min.peek();
                    med[index] = median;
                    index += 1;
                }
            } else if (max.size() > min.size()) {
                if(val < median) {
                    min.add(max.remove());
                    max.add(val);
                } else {
                    min.add(val);
                }
                median = (double)(max.peek() + min.peek())/2;
                med[index] = median;
                index += 1;
            } else {
                if(val > median) {
                    max.add(min.remove());
                    min.add(val);
                } else {
                    max.add(val);
                }
                median = (double)(max.peek() + min.peek())/2;
                med[index] = median;
                index += 1;
            }
            len++;
        }        
        return med;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(scanner.nextLine().trim());

        int[] a = new int[aCount];

        for (int aItr = 0; aItr < aCount; aItr++) {
            int aItem = Integer.parseInt(scanner.nextLine().trim());
            a[aItr] = aItem;
        }

        double[] result = runningMedian(a);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}

```

主要是參考第三個參考資料寫的，自己嘗試理解。

## 參考資料
- [1](https://5xruby.tw/posts/find-the-running-median/)
- [2](https://www.baeldung.com/java-stream-integers-median-using-heap)
- [3](https://www.thecsblog.com/hackerrank-find-the-running-median/)