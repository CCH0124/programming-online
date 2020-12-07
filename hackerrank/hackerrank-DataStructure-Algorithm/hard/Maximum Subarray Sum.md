[Maximum Subarray Sum](https://www.hackerrank.com/challenges/maximum-subarray-sum/problem)


```java
static long maximumSum(long[] a, long m) {
        long maxModSum = 0L;
        long max = 0L;
        TreeSet<Long> ts = new TreeSet<>();
        for (int i=0; i<a.length; i++){
            maxModSum = (maxModSum + a[i]) % m;
            Long close = ts.ceiling(maxModSum + 1);
            if(close == null) close = 0L;

            if(close > 0){
                max = Math.max(max, maxModSum - close + m);
            }

            max = Math.max(max, maxModSum);
            ts.add(maxModSum);
        }
        return max;
    }
```

`1 5 9, 5` 為範例
|TreeSet|maxModSum|Max|close|
|---|---|---|---|
|[1]|(0+1)%5=1|(0,1)=1|0L|
|[1]|(1+5)%5=1|(1,1)=1|0L|
|[1,9]|(1+9)%5=0|(1,(0-1+5))=4，(4,0)=4|1L|