[題目](https://www.hackerrank.com/challenges/maximum-element/problem)

```java
import java.io.*;
import java.util.*;

public class Solution {
    private  static Stack<Integer> stack = new Stack<>();
    private  static List<Integer> max = new ArrayList<>();
    public static void one(int val){
        stack.push(val);
        if (max.size() == 0 || max.get(max.size()-1) <= val ){
            max.add(val);
        }
    }
    
    public static void two(){
        int val = stack.pop();
        if (max.get(max.size()-1) == val){
            max.remove(max.size()-1);
        }
    }

    public static void getMax(){
        System.out.println(max.get(max.size()-1));
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int item = sc.nextInt();
        for (int i=0; i<item; i++){
            int query = sc.nextInt();
            
            switch(query) {
                case 1:
                    one(sc.nextInt());
                    break;
                case 2:
                    two();
                    break;
                case 3:
                    getMax();
                    break;
                default:
                    System.out.println(query + "value Error."); 
            }
        }
    }
}
```