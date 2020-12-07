class Solution {
    public String longestCommonPrefix(String[] strs) {
       if (strs.length == 0) return "";
        String first = strs[0];
        for(int j=1; j<strs.length; j++){
            while(strs[j].startsWith(first) != true ){ // 比對開頭
                first = first.substring(0,first.length()-1);
                if(first.isEmpty()) return "";
            }
        }
        return first;
    }
}
