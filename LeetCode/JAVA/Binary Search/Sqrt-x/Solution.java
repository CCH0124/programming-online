class Solution {
    public int mySqrt(int x) {
        Long left = 1L;
        Long right = (left + (long)x)/2; # 9 開根號是 3，16 是 4。所以把數字除 2 ，再用二元搜尋去實現。
        Long ans = 0L;
        while(left <= right){
            Long mid = (left + right)/2;
            Long pow = mid * mid;
            if(pow <= (long)x){
                left = mid + 1;
                ans = mid;
            }else{
                right = mid - 1;
            }
        }
        return ans.intValue();
    }
}
