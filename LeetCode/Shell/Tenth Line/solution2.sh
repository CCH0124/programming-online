# Read from the file file.txt and output the tenth line to stdout.
 sed -n 10p < file.txt
 
# -n：只有經過 sed 特殊處理的那一行(或者動作)才會被列出來
# p：列印，亦即將某個選擇的資料印出
