[題目](https://www.hackerrank.com/challenges/java-dequeue/problem)

```java
    import java.util.*;
    import java.util.stream.*;
    public class test {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            Deque<Integer> deque = new ArrayDeque<>();
            Set<Integer> set = new HashSet<>();
            int n = in.nextInt();
            int m = in.nextInt();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                deque.add(num);
                set.add(num);
                if (deque.size() == m){
                    int size = set.size();
                    max = Math.max(max, size);
                    int value = deque.removeFirst();
                    // 移動時 Set 需做改變
                    if (!deque.contains(value)){
                        set.remove(value);
                    }
                }

                if (max == m) {
                    break;
                }
            }
            System.out.println(max);
        }
    }
```