# Read from the file file.txt and output the tenth line to stdout.
awk 'NR==10 {print $0}' < file.txt

# NR：目前行號
# print：打印，$0 表示打印該全部訊息
