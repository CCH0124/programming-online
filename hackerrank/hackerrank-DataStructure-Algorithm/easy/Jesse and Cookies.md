[Jesse and Cookies](https://www.hackerrank.com/challenges/jesse-and-cookies/problem)

```java
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;
public class Solution {

    /*
     * Complete the cookies function below.
     */
    static int cookies(int k, int[] A) {
        /*
         * Write your code here.
         */
        int count = 0;
        
        PriorityQueue<Integer> pQueue = new PriorityQueue<>() ;
        for (int i=0; i<A.length; i++){
            pQueue.add(A[i]);
        }
        if(pQueue.peek() >= k) {
            return count;
        }
        while (pQueue.peek() < k && pQueue.size() > 1){

            int a = pQueue.poll();
            int b = pQueue.poll();
        
            pQueue.add(( a + 2 * b));
            count++;
        }

        if (pQueue.peek() < k) {
            return -1;
        }
        
        

        return count;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0].trim());

        int k = Integer.parseInt(nk[1].trim());

        int[] A = new int[n];

        String[] AItems = scanner.nextLine().split(" ");

        for (int AItr = 0; AItr < n; AItr++) {
            int AItem = Integer.parseInt(AItems[AItr].trim());
            A[AItr] = AItem;
        }

        int result = cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
```