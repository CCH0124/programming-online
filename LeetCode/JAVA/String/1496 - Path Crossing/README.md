Given a string `path`, where `path[i] = 'N'`, `'S'`, `'E'` or `'W'`, each representing moving one unit north, south, east, or west, respectively. You start at the origin `(0, 0)` on a 2D plane and walk on the path specified by path.

Return True if the path crosses itself at any point, that is, if at any time you are on a location you've previously visited. Return False otherwise.

##### Example 1:
![](https://assets.leetcode.com/uploads/2020/06/10/screen-shot-2020-06-10-at-123929-pm.png)

```
Input: path = "NES"
Output: false 
Explanation: Notice that the path doesn't cross any point more than once.
```

##### Example 2:
![](https://assets.leetcode.com/uploads/2020/06/10/screen-shot-2020-06-10-at-123843-pm.png)

```
Input: path = "NESWW"
Output: true
Explanation: Notice that the path visits the origin twice.
```

##### Constraints:

- `1 <= path.length <= 10^4`
- `path` will only consist of characters in `{'N', 'S', 'E', 'W}`

## Code

```java
class Solution {
    public boolean isPathCrossing(String path) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('N', 1);
        map.put('S', -1);
        map.put('E', 1);
        map.put('W', -1);
        LinkedListCoordinate storePath = new LinkedListCoordinate();
        char[] dir = path.toCharArray();
        int x = 0;
        int y = 0;
        for (int i = 0; i < dir.length; i++) {

            if (dir[i] == 'N') {
                y = y + map.get('N');
            }
            if (dir[i] == 'S') {
                y = y + map.get('S');
            }
            if (dir[i] == 'E') {
                x = x + map.get('E');
            }
            if (dir[i] == 'W') {
                x = x + map.get('W');
            }
            if(storePath.add(new Coordinate(x, y))){
                return true;
            }
        }
        
        return false;
        
    }
}

class Coordinate {
    public int x;
    public int y;
    public Coordinate next;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinate2 [x=" + x + ", y=" + y + "]";
    }

}

class LinkedListCoordinate {
    private Coordinate head;

    public LinkedListCoordinate() {
        head = null;
        init();
    }

    public void init() {
        Coordinate init = new Coordinate(0, 0);
        init.next = head;
        head = init;
    }

    public Boolean add(Coordinate heroNode) {
        if (!uniq(heroNode)) {
            heroNode.next = head;
            head = heroNode;
        } else {
            return true;
        }
        return false;
    }

    public Boolean uniq(Coordinate heroNode) {
        Coordinate temp = head;
        while (temp != null) {
            if (heroNode.x == temp.x && heroNode.y == temp.y) {
                return true;
            } else {
                temp = temp.next;
            }
        }
        return false;

    }

    public void display() {
        Coordinate cur = head;
        while (cur != null) {
            System.out.println(cur);
            cur = cur.next;
        }
    }
}
```
