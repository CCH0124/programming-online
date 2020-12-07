class Solution {
    public String longestCommonPrefix(String[] strs) {
       if (strs.length == 0) return ""; // 為空，資策有這個...
        String first = strs[0]; // 把第0個元素當作比對的前綴
        for(int j=1; j<strs.length; j++){ // 忽略掉第0個元素，不用自己比自己
            while(strs[j].indexOf(first) != 0 ){ // Not match return -1，All match return 0
                first = first.substring(0,first.length()-1); // 當前綴尚未比對到，則把比對的字元減少
                if(first.isEmpty()) return "";
            }
        }
        return first;
    }
}
