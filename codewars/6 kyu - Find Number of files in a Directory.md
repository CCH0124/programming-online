Your task is to write a script that finds the number of type 'f' files in a given directory (argument 1) to stdout. If there is no arguments, print "Nothing to find".

Examples:
```
run_shell        --> prints: "Nothing to find"
run_shell dir1         --> prints: "There are 5 files in /home/codewarrior/shell/dir1"
run_shell doesNotExist --> prints: "Directory not found"
```

## code

```shell
#!/bin/bash

if [ $1 ]; then
  if [ -d $1 ]; then # -d 判斷目錄
    echo "There are $(find $1 -type f | wc -l) files in $(pwd)/$1" # 用 find 設定搜尋類型(type) f (檔案)
                                                                   # wc 取得數量， -l 以統計換行的行數
  else
    echo "Directory not found"
  fi
else
  echo "Nothing to find"
fi
```
