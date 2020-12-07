[題目](https://www.hackerrank.com/challenges/java-arraylist/problem)


```java
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> list = new ArrayList<>();
        int n = sc.nextInt();
        for (int i=0; i<n; i++){
            int quantity = sc.nextInt();
            List<Integer> store = new ArrayList<>(); // 當 quantity 為 0 時
            for(int j=0; j<quantity; j++){
                int val = sc.nextInt();
                store.add(val);
            }
            list.add(store);
        }
        int input = sc.nextInt();
        for (int i=0; i<input; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            x -= 1;
            y -= 1;
            if (list.get(x).size() > y ){
                System.out.println(list.get(x).get(y));
            } else {
                System.out.println("ERROR!");
            }
        }
    }
}
```