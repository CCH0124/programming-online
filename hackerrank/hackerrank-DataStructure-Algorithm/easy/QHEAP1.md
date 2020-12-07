[QHEAP1](https://www.hackerrank.com/challenges/qheap1/problem)

```java
import java.io.*;
import java.util.*;

public class Solution {
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public static void one(int val){
        minHeap.add(val);
    }
    public static void two(int val){
        minHeap.remove(val);
    }
    public static void getMin(){
        System.out.println(minHeap.peek());
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int item = sc.nextInt();
        while(item > 0){
            int action = sc.nextInt();
            switch(action){
                case 1:
                    one(sc.nextInt());
                    break;
                case 2:
                    two(sc.nextInt());
                    break;
                case 3:
                    getMin();
                    break;
            }
            item--;
        }
    }
}
```