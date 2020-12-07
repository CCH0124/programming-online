class Solution {
    public int climbStairs(int n) {
        List<Integer> list = new ArrayList<>();
        int result;
        list.add(1);
        list.add(2);
        if(n == 1) return 1;
        if(n == 2) return 2;
        for(int i=3; i<=n; i++){
            result = list.get(list.size() - 1) + list.get(list.size() - 2);
            list.add(result);
        }
        return list.get(n-1);
    }
}
