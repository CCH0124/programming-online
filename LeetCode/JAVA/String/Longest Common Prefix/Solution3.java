class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String first = strs[0];
        /*
        * regionMatches(arg0,arg1,arg2,arg3,arg4)
        * arg0：是否大小寫視同一樣
        * arg1：要比對的字串，從第幾個字元開始
        * arg2：被比對的字串
        * arg3：被比對的字串，從第幾個字元開始
        * arg4：位移。假設 arg3 從 2 字元開始，arg4 設 3，則從 2 字元開始到右移 3 位
        */
        for(int j=1; j<strs.length; j++){
            while(first.regionMatches(false,0,strs[j],0,first.length()) != true){
                first = first.substring(0,first.length()-1);
                if (first.isEmpty()) return "";
            }
            
        }
        return first;
        
    }
        
}
