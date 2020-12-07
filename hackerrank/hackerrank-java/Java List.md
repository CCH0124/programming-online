[題目](https://www.hackerrank.com/challenges/java-list/problem)
```java
import java.io.*;
import java.util.*;

public class Solution {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        List<Integer> list = new ArrayList<>();
        int size = sc.nextInt();
        for (int i=0; i<size; i++){
            list.add(sc.nextInt());
        }
        int actions = sc.nextInt();

        while(actions > 0 ){
            String action = sc.next();
            if(action.equals("Insert")){
                int index = sc.nextInt();
                int value = sc.nextInt();
                list.add(index, value);
            }
            if(action.equals("Delete")){
                int index = sc.nextInt();
                list.remove(index);
            }
            actions--;
        }
        list.forEach((e) -> {
          System.out.print(e+" ");
        });
    }
}
```