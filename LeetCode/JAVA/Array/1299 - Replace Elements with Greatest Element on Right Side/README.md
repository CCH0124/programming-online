Given an array `arr`, replace every element in that array with the greatest element among the elements to its right, and replace the last element with `-1`.

After doing so, return the array.

##### Example 1:
```
Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]
```

##### Constraints:

- `1 <= arr.length <= 10^4`
- `1 <= arr[i] <= 10^5`

## Code
```java
class Solution {
    public int[] replaceElements(int[] arr) {
        int len = arr.length-1;
        int max = arr[len];
        for(int i=len-1; i>=0; i--){
            int temp = arr[i];
            arr[i] = max;
            if( temp > max){
                max = temp;
                
            }
        }
        arr[len] = -1;
        return arr;
    }
}
```
