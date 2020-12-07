Complete the solution so that it returns a formatted string. The return value should equal "Value is VALUE" where value is a 5 digit padded number.

Example:
```
solution(5) // should return "Value is 00005"
```

## code
```shell
# Make it green, than make it clean :)
# echo "Value is 00005"
printf "Value is %05d\n" $1
# echo "Value is 0000$1"
```
