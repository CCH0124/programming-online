class Solution {
    public int reverse(int x) {
        Long xtemp = Long.parseLong(String.valueOf(x)); // 轉 Long
        String temp = String.valueOf(xtemp); // 轉 String
        String s;
        // 有負號
        if(xtemp < 0){
            s  = new StringBuffer(temp.substring(1, temp.length())).reverse().toString(); // substring 抓取負號之後，反轉，回傳 char，在轉字串
            String reversestring = "-"+s; // 增加 - （負號）
            if (Long.parseLong(s) > Integer.MAX_VALUE)　// 反轉的字串轉 Long 判斷有無超出 int 界線
                return 0;
            else
                return Integer.parseInt(reversestring);
        }else{  
        // 無負號
            s = new StringBuffer(temp).reverse().toString();
            if (Long.parseLong(s) > Integer.MAX_VALUE)
                return 0;
            else
                return Integer.parseInt(s);
        }
    }
}
