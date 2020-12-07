When you divide the successive powers of `10` by `13` you get the following remainders of the integer divisions:

`1, 10, 9, 12, 3, 4`.

Then the whole pattern repeats.

Hence the following method: Multiply the right most digit of the number with the left most number in the sequence shown above, the second right most digit to the second left most digit of the number in the sequence. The cycle goes on and you sum all these products. Repeat this process until the sequence of sums is stationary.

...........................................................................

Example: What is the remainder when `1234567` is divided by `13`?

`7×1 + 6×10 + 5×9 + 4×12 + 3×3 + 2×4 + 1×1 = 178`

We repeat the process with `178`:

`8x1 + 7x10 + 1x9 = 87`

and again with `87`:

`7x1 + 8x10 = 87`

...........................................................................

From now on the sequence is stationary and the remainder of 1234567 by 13 is the same as the remainder of 87 by 13: 9

Call thirt the function which processes this sequence of operations on an integer n (>=0). thirt will return the stationary number.

thirt(1234567) calculates 178, then 87, then 87 and returns 87.

thirt(321) calculates 48, 48 and returns 48


```shell
#!/bin/bash
#set -x
declare -a arry
declare -a arry1
arry=(1 10 9 12 3 4)

divBy13() {
        local num=$1
        num=$( echo $num | rev)
        toArray $num
}


toArray() {
        local num=$1
        let len=${#num}-1
        unset arry1
        for i in $(seq 0 $len)
        do
                arry1[$i]=${num:$i:1}
        done
}
result() {
        local arrayLen=${#arry[@]}
        local array1Len=${#arry1[@]}
        local sum=0

        for j in $(seq 0 $array1Len)
        do
                if [ $array1Len -gt $j ]; then
                        c=$(echo "($j+1)%$arrayLen-1" | bc)
                        if [ $c -eq -1 ]; then
                                let c=$arrayLen-1
                        fi
                #echo "$sum+${arry1[$j]}*${arry[$c]}"
                        sum=$( echo "$sum+${arry1[$j]}*${arry[$c]}" | bc)
                fi
        done               
        echo $sum
}

temp1=$1
temp=0
t=0
until [ $t -eq 1 ]
do
        divBy13 $temp1
        temp=$(result)
        if [ $temp -eq $temp1 ]; then
                t=1
                echo $temp1
        else
                temp1=$temp
                t=0
        fi
done
```
