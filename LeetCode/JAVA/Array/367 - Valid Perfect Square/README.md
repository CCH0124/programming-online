Given a **positive** integer *num*, write a function which returns True if num is a perfect square else False.

Follow up: Do not use any built-in library function such as `sqrt`.

 

##### Example 1:
```
Input: num = 16
Output: true
```
##### Example 2:
```
Input: num = 14
Output: false
```

##### Constraints:

`1 <= num <= 2^31 - 1`

## Code
發現，平方數有規則。
```
1 4 9 16 25 ...
3 5 7 9  16 ... # 規則
```
```java
class Solution {
   public boolean isPerfectSquare(int num) {
      int i; 
	    for(i=1; num>0; i+=2){
		    num-=i; 
	    }
	    if(num==0) {
		    return true;
      }else{
		    return false;
      }
   }
}
```
