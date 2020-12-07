[題目](https://www.hackerrank.com/challenges/java-loops/problem)

```java
import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int temp = a;
            for(int j=0; j<n; j++){
                int q = (int)Math.pow(2, j);
                int num = q*b;
                temp += num;
                System.out.print(temp+" ");
            }
            System.out.println();
        }
        in.close();
    }
}
```


```java
import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int temp = a;
            int q = 1;
            for(int j=0; j<n; j++){
                int num = q*b;
                temp += num;
                System.out.print(temp+" ");
                q = q << 1;
            }
            System.out.println();
        }
        in.close();
    }
}
```