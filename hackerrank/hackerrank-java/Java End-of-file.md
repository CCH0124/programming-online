[題目](https://www.hackerrank.com/challenges/java-end-of-file/problem)

```java
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        final Scanner sc = new Scanner(System.in);
        int line = 0;
        while (sc.hasNext()) {
            final String s = sc.nextLine();
            line++;
            System.out.printf("%d %s%n", line, s);
        }
    }
}
```