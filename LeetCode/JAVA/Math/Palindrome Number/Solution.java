class Solution {
    public boolean isPalindrome(int x) {
        String s = new StringBuffer(String.valueOf(x)).reverse().toString(); # 轉字串>反轉>轉字串
        if(String.valueOf(x).equals(s))
            return true;
        else 
            return false;
    }
}
