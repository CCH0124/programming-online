Your task is to add up letters to one letter.

The script will be given a string of letters, each character being a letter to add.

## Notes:
- Letters will always be lowercase.
- Letters can overflow (see second to last example of the description)
- If no letters are given, the function should return `'z'`

## Examples:

```shell
run_shell(args: ['abc']) = "f"
run_shell(args: ['ab']) = "c"
run_shell(args: ['z']) = "z"
run_shell(args: ['za']) = "a"
run_shell(args: ['ycb']) = "d" # notice the letters overflowing
run_shell(args: ['']) = "z"
```

##  Code
```shell
declare -A map # 宣告 map，用來對應 'a': 1, 'b': 2
x=96
for i in {a..z};
do
        n=$(echo -n "$i" | od -An -tuC)
        map["$i"]=$((n-x))
done

letters=$1

test -z $letters && echo "z" && exit 0;

num=0
for i in $(seq 1 ${#letters});
do
        char=${letters:i-1:1}
        value=${map[$char]}
        num=$(($num+$value))
done

for i in {a..z};
do
        value=${map[$i]}
        if [ "0" -eq "$(($num%26))" ]
        then
                echo "z"
                exit 0
        fi
        if [ "$value" -eq "$(($num%26))" ]
        then
                echo $i
        fi
done
```
