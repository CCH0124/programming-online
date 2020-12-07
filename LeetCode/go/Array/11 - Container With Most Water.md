Given n non-negative integers `a1, a2, ..., an` , where each represents a point at coordinate `(i, ai)`. n vertical lines are drawn such that the two endpoints of line `i` is at `(i, ai)` and `(i, 0)`. Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

Example:
```
Input: [1,8,6,2,5,4,8,3,7]
Output: 49
```

## Code
```go
func maxArea(height []int) int {
    left := 0
    right := (len(height) - 1)
    result := 0

    for left < right {
        var y, area int
        x :=  right - left // 左到右的間隔
        if height[left] > height[right] {
            y = height[right]
		        right -- // 往左一格
        } else {
            y = height[left]
            left++ // 往右一格
        }
        
        area = x * y
        if result < area {
            result = area 
        }
    }
    return result
}
```
