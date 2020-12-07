class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0; // max 為 0，遇到負數會不妥，所以設成 int 最小值
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) // 如果為負數倒不如放棄重新計算
                sum = nums[i];
            else
                sum += nums[i]; // 繼續累加
            max = Math.max(sum, max);
        }
        return max;
    }
}
