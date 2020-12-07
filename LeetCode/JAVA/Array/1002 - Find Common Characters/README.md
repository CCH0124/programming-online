Given an array `A` of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.

You may return the answer in any order.

##### Example 1:
```
Input: ["bella","label","roller"]
Output: ["e","l","l"]
```
##### Example 2:
```
Input: ["cool","lock","cook"]
Output: ["c","o"]
```

##### Note:

1. `1 <= A.length <= 100`
2. `1 <= A[i].length <= 100`
3. `A[i][j] is a lowercase letter`

## Code
```java
class Solution {
    public List<String> commonChars(String[] A) {
        ConcurrentHashMap <Character, Integer> map = new ConcurrentHashMap <>();
        Map <Character, Integer> temp = new HashMap <>();
        List<String> list = new ArrayList<>();
        for (char val : A[0].toCharArray()) {
			    map.put(val, map.getOrDefault(val, 0) + 1); // 以第一個做為基準
		    }
        // 從第 1 個元素開始與基準進行比較
        for(int i=1; i<A.length; i++){
            for (char val : A[i].toCharArray()) {
                temp.put(val, temp.getOrDefault(val, 0) + 1);
		    }
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if(temp.containsKey(entry.getKey())) {
                    if(entry.getValue() >= temp.get(entry.getKey())) { // 如果基準的一個字符數量小於目前元素的相同字符數量，則必須遞減。原因為因為共同的字符出現減少
                        map.put(entry.getKey(), temp.get(entry.getKey()));
                    }
                } else {
                    map.remove(entry.getKey());  
                }
            }
            temp.clear();
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            for(int i=0; i<entry.getValue(); i++){
                list.add(entry.getKey().toString());
            }
        }
        return list;
        
    }
}
```
