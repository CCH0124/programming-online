[題目](https://www.hackerrank.com/challenges/arrays-ds/problem)

##### Sample Input 
```
4
1 4 3 2
```
##### Sample Output 
```
2 3 4 1
```


```java
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the reverseArray function below.
    static int[] reverseArray(int[] a) {
        int [] arr = new int[a.length];
        for(int i=a.length-1; i>=0; i--){
            arr[a.length-1-i] = a[i];
        }
        return arr;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[arrCount];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] res = reverseArray(arr);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

```
JAVA8 方式

```java
// Complete the reverseArray function below.
    static int[] reverseArray(int[] a) {
        return IntStream.rangeClosed(1, a.length)
                .map(i -> a[a.length - i])
                .toArray();
    }
```
go 語言不能夠 `var b [len(a)]int32` 宣告

```go
package main

import (
    "bufio"
    "fmt"
    "io"
    "os"
    "strconv"
    "strings"
)

// Complete the reverseArray function below.
func reverseArray(a []int32) []int32 {
    b := make([]int32, len(a))
    for i:=len(a)-1; i>=0; i-- {
        b[len(a)-1-i] = a[i]
    }
    return b
}

func main() {
    reader := bufio.NewReaderSize(os.Stdin, 1024 * 1024)

    stdout, err := os.Create(os.Getenv("OUTPUT_PATH"))
    checkError(err)

    defer stdout.Close()

    writer := bufio.NewWriterSize(stdout, 1024 * 1024)

    arrCount, err := strconv.ParseInt(readLine(reader), 10, 64)
    checkError(err)

    arrTemp := strings.Split(readLine(reader), " ")

    var arr []int32

    for i := 0; i < int(arrCount); i++ {
        arrItemTemp, err := strconv.ParseInt(arrTemp[i], 10, 64)
        checkError(err)
        arrItem := int32(arrItemTemp)
        arr = append(arr, arrItem)
    }

    res := reverseArray(arr)

    for i, resItem := range res {
        fmt.Fprintf(writer, "%d", resItem)

        if i != len(res) - 1 {
            fmt.Fprintf(writer, " ")
        }
    }

    fmt.Fprintf(writer, "\n")

    writer.Flush()
}

func readLine(reader *bufio.Reader) string {
    str, _, err := reader.ReadLine()
    if err == io.EOF {
        return ""
    }

    return strings.TrimRight(string(str), "\r\n")
}

func checkError(err error) {
    if err != nil {
        panic(err)
    }
}
```


作法 2，相對於上面少了一個陣列空間做存放。
```java
static int[] reverseArray(int[] a) {
        int i = 0;
        int j = a.length - 1;
        while(i<j){
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
        return a;
    }
```
```go
// Complete the reverseArray function below.
func reverseArray(a []int32) []int32 {
    var i = 0
    var j = len(a) - 1
    for i<j {
        temp := a[i]
        a[i] = a[j]
        a[j] = temp
        i++
        j--
    }
    return a
}
```