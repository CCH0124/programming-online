[題目](https://www.hackerrank.com/challenges/java-negative-subarray/problem)


```java
import java.io.*;
import java.util.*;
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();

        int count = 0;
        for(int i=0; i<arr.length; i++){
            int sum = 0;
            for (int j=i; j<arr.length; j++){
                sum += arr[j];
                if (sum < 0){
                    count++;
                }
            }
        }
        System.out.print(count);
        
    }
}
```