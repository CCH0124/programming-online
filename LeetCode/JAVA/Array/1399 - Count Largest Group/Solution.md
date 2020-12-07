Given an integer `n`. Each number from `1` to `n` is grouped according to the sum of its digits. 

Return how many groups have the largest size.

##### Example 1:
```
Input: n = 13
Output: 4
Explanation: There are 9 groups in total, they are grouped according sum of its digits of numbers from 1 to 13:
[1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9]. There are 4 groups with largest size.
```
##### Example 2:
```
Input: n = 2
Output: 2
Explanation: There are 2 groups [1], [2] of size 1.
```
##### Example 3:
```
Input: n = 15
Output: 6
```

##### Example 4:
```
Input: n = 24
Output: 5
```

##### Constraints:

- 1 <= n <= 10^4

## Solution
```java
class Solution {
    private int sum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    public int countLargestGroup(int n) {
        if (n < 10) return n;
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int i=1; i<=n; i++){
            hashmap.put(sum(i), hashmap.getOrDefault(sum(i), 0)+1);
        }
        int maxValue = Collections.max(hashmap.values());
        
        int c = 0;
        for (Integer i : hashmap.values()) {
            if( i == maxValue) {
                c++;
            }
        }
        return c;
    }
    
}
```

```java
class Solution {
    private int sum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    public int countLargestGroup(int n) {
        if (n < 10) return n;
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        int max = 0;
        for(int i=1; i<=n; i++){
            int val = hashmap.getOrDefault(sum(i), 0) + 1;
            hashmap.put(sum(i), val);
            max = Math.max(max, val);
        }
        // int maxValue = Collections.max(hashmap.values());
        
        int c = 0;
        for (Integer i : hashmap.values()) {
            if( i == max) {
                c++;
            }
        }
        return c;
    }
    
}
```

```java
class Solution {
    private int sum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    public int countLargestGroup(int n) {
        if (n < 10) return n;
        int [] arr = new int[36];
        int max = 0;
        int c = 0;
        for(int i=1; i<=n; i++){
            arr[sum(i)-1]++;
            max = Math.max(max, arr[sum(i)-1]);
                
        } 
        for (int i : arr) {
            if( i == max) {
                c++;
            }
        }
        return c;
    }
    
}
```
