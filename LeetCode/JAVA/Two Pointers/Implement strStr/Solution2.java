class Solution {
    public int strStr(String haystack, String needle) {
        int haystackLen = haystack.length();
        int needlelen = needle.length();
        int i;
        for(i=0; i<=haystackLen-needlelen; i++){
            if (haystack.substring(i, needlelen+i).equals(needle)) // equal 比較字串內容 
                return i;
        }
        return -1;  
    }
}
