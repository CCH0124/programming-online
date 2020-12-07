[Extra Long Factorials](https://www.hackerrank.com/challenges/extra-long-factorials/problem)


```java
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.*;
import java.math.BigInteger;
public class Solution {

    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {
        String res = "";
        if (n < 20) {
            res = BigInteger.valueOf(
                    LongStream.range(1, n + 1)
                    .reduce((previous, current) -> previous * current).getAsLong()
            ).toString();
        } 
        if (n >= 20){
            BigInteger result =  BigInteger.valueOf(
                    LongStream.range(1, 20)
                    .reduce((previous, current) -> previous * current).getAsLong()
            );
            res = result.multiply(
                Stream.iterate(BigInteger.valueOf(20), i -> i.add(BigInteger.ONE))
                .limit(n - 19)
                .reduce((previous, current) -> previous.multiply(current)).get()
            ).toString();
        }
        System.out.println(res);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}

```