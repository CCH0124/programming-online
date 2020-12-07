cat words.txt | tr -s ' ' '\n' | sort | uniq -c | sort -nr | awk '{print $2,$1}'

# tr 
-s 將空白取代成 '\n'
# sort 
排序
# uniq 
-c 計數
# sort -nr
-n 數字排序
-r 反向排序
