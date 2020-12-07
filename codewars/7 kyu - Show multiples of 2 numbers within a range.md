Print all numbers up to `3rd` parameter which are multiple of both `1st` and `2nd` parameter.

Python, Javascript, Java versions: return results in a list/array

NOTICE:

Do NOT worry about checking zeros or negative values.
To find out if 3rd parameter (the upper limit) is inclusive or not, check the tests, it differs in each translation

## code
1.
```shell
#!/bin/bash
set -u
declare -a arr=()
for i in $(seq 1 $3)
do
  arg1=$(echo "$i%$1" | bc)
  arg2=$(echo "$i%$2" | bc)
  if [ $arg1 -eq 0 -a $arg2 -eq 0 ]; then
#     arr+=($i)
    printf "$i\n"
  fi
done

# echo ${arr[@]}  
```
2.
取 arg1 和 arg2 公倍數
```shell
step=$(echo "$1*$2" | bc)
seq $step $step $3
```
