A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.

Given a tree of `n` nodes labelled from `0` to `n - 1`, and an array of `n - 1` edges where `edges[i] = [a_i, b_i]` indicates that there is an undirected edge between the two nodes `a_i` and `b_i` in the tree, you can choose any node of the tree as the root. When you select a node `x` as the root, the result tree has height `h`. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).

Return a list of all MHTs' root labels. You can return the answer in any order.

The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

##### Example 1:
![](https://assets.leetcode.com/uploads/2020/09/01/e1.jpg)
```
Input: n = 4, edges = [[1,0],[1,2],[1,3]]
Output: [1]
Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.
```
##### Example 2:
![](https://assets.leetcode.com/uploads/2020/09/01/e2.jpg)
```
Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
Output: [3,4]
```
##### Example 3:
```
Input: n = 1, edges = []
Output: [0]
```
##### Example 4:
```
Input: n = 2, edges = [[0,1]]
Output: [0,1]
``` 

##### Constraints:

- `1 <= n <= 2 * 104`
- `edges.length == n - 1`
- `0 <= a_i, b_i < n`
- `a_i != b_i`
- All the pairs (`a_i`, `b_i`) are distinct.
- The given input is guaranteed to be a tree and there will be no repeated edges.


## Code

```java
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();

        if (n == 1) {
            res.add(0);
            return res;
        }
        int [] degree = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<n; i++){
            map.put(i, new ArrayList<>());
        }
        for (int [] edge : edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        
        for(int i=0; i<n; i++){
            if (degree[i] == 1){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i=0; i<size; i++){
                int curr = queue.poll();
                list.add(curr);
                for(int x: map.get(curr)){
                    degree[x]--;
                    if (degree[x] == 1){
                        queue.add(x);
                    }
                }
            }
            res = list;
        }
        
        return res;
        
    }
}

// [[3,0],[3,1],[3,2],[3,4],[5,4]]
/**
        degree      map             queue
    [0,0,0,1,0,0]   <3,[0]>
    [1,0,0,1,0,0]   <0,[3]>
    [0,0,0,2,0,0]   <3,[0,1]>
    [1,1,0,2,0,0]   <1,[3]>
    [1,1,0,3,0,0]   <3,[0,1,2]>
    [1,1,1,1,0,0]   <2,[3]>
    [1,1,1,4,0,0]   <3,[0,1,2,4]>
    [1,1,1,4,1,0]   <4,[3]>
    [1,1,1,4,1,1]   <5,[4]>
    [1,1,1,4,2,1]   <4,[3,5]>        
                                    [0,1,2,5]
=======================================================
    curr    list     x                  degree          queue
    0       0        <0,[3]>            [1,1,1,3,2,1]   [1,2,5]
    1       0,1      <1,[3]>            [1,1,1,2,2,1]   [2,5]
    2       0,1,2    <2,[3]>            [1,1,1,1,2,1]   [5,3]
    5       0,1,2,5  <5,[4]>            [1,1,1,1,1,1]   [3,4]
    3       3        <3,[0,1,2,4]>      [1,1,1,1,1,1],  [4]
                                        [0,0,0,1,0,1]
    4       3,4      <4,[3,5]>          [0,0,0,0,0,0],  []
    
    
**/
```
