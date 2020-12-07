class Solution {
    public String countAndSay(int n) {
        StringBuilder str = new StringBuilder("1"); // 第一個為1
        StringBuilder strCurrent = new StringBuilder();
        for(int i=1; i<n; i++){
            strCurrent = str; // 存放前一個的值
            str = new StringBuilder();
            int j = 0,count = 1; // count 拿來計數幾個 1 或幾個 2 等等
            while(j < strCurrent.length()-1){
                if(strCurrent.charAt(j) == strCurrent.charAt(j+1))
                    count++;
                else{
                    str.append(count).append(strCurrent.charAt(j));
                    count = 1;
                }
                j++;
            }
            str.append(count).append("1"); // 最後 1 個一定為 1 個 1
        }
        return str.toString();
    }
}
