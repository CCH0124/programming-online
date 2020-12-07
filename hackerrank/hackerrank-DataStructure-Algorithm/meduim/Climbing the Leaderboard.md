[Climbing the Leaderboard](https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem)

```java
public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    // Write your code here
        List<Integer> ranker = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>(ranked);
        int max = set.size();
        // 60 75 80 90 100
        //50 65 77 90 102
        for (int i=0; i<player.size(); i++){
            int val = player.get(i);
            Integer index = set.ceiling(val);
            
            if (val < set.first()){
                ranker.add(set.size()+1);    
            } else if(val >= set.last()){
                ranker.add(1);    
            } else {
                if (val == index){
                    ranker.add(max - set.headSet(index).size());
                } else {
                    ranker.add(max - set.headSet(index).size()+1);    
                }
                
            }
            
        }
        return ranker;
    }
```

```java
public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    // Write your code here
        List<Integer> ranker = new ArrayList<>();
        ranked = ranked.stream().distinct().collect(Collectors.toList());
        // ranked.stream().forEach(System.out::println);
        // 100 90 80 75 60 
        // 50 65 77 90 102
        
        int start = ranked.size()-1;
        for(int i=0; i<player.size(); i++){
            int val = player.get(i);
            if (val < ranked.get(ranked.size()-1)){
                System.out.println("1 "+val);
                ranker.add(ranked.size()+1);
                start--;
                continue;
            } 
            if (val >= ranked.get(0)){
                System.out.println("2 "+val);
                ranker.add(1);
                continue;
            }
            
            if (ranked.contains(val)){
                System.out.println("3 "+val);
                int index = ranked.indexOf(val)+1;
                ranker.add(index);
                start = index-1;
                continue;
            }
            
            while(ranked.get(start) < val){
                start--;
            }
            ranker.add(start+2);
        }
        
        return ranker;
    }
```

使用 BinarySearch

```java
private static int binarySearch(List<Integer> ranked, int key) {

        int low = 0;
        int hight = ranked.size() - 1;

        while (low <= hight) {
            int mid = low + (hight - low) / 2;
            if (ranked.get(mid) == key) {
                return mid;
            } else if (ranked.get(mid) < key && key < ranked.get(mid-1)) {
                return mid;
            } else if (ranked.get(mid) > key && key >= ranked.get(mid+1)) {
                return mid + 1;
            } else if (ranked.get(mid) < key) {
                hight = mid - 1;
            } else if (ranked.get(mid) > key) {
                low = mid + 1;
            }
        }
        return -1;
    }
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    // Write your code here
        List<Integer> res = new ArrayList<>();
        ranked = ranked.stream().distinct().collect(Collectors.toList());
        for (int val : player){
            if (val > ranked.get(0)) {
                res.add(1);
            } else if (val < ranked.get(ranked.size() - 1)) {
                res.add(ranked.size() + 1);
            } else {
                int index = binarySearch(ranked, val);
                res.add(index+1);

            }    
        }  
        
        
        return res;
    }
```