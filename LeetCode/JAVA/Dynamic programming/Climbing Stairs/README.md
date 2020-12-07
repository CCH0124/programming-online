## 思路

> 發現 5 階的方式，是第 4 階 + 第 3 階  
> 費是數列的感覺

## 解法

- 遞迴

執行時間過長，沒過。

```java
 public static int climbStairs(int n) {
         if( n == 1) return 1;
         if( n == 2) return 2;
         return climbStairs(n-1) + climbStairs(n-2);
 }

```

- 動態規劃

陣列儲存，效果不錯

## 參考資訊
![演算法](http://www.csie.ntnu.edu.tw/~u91029/DynamicProgramming.html)

