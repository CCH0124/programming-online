[題目](https://www.hackerrank.com/challenges/java-stack/problem)

```java
import java.util.*;
class Solution{

 public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
        HashMap<String, String> map = new HashMap<>();
        map.put("}", "{");
        map.put(")", "(");
        map.put("]", "[");
        
		while (sc.hasNext()) {
			String input=sc.next();
            //Complete the code
            int i = 0;
            boolean is = true;
            Stack<String> stack = new Stack<>();
            while(i<input.length()){
                String v = input.substring(i, i+1);
                if (v.equals("{") || v.equals("(") || v.equals("[")){
                    stack.push(v);
                } else {
                    if(stack.empty()){
                        is = !is;
                        break;
                    }
                    if(stack.peek().equals(map.get(v))){
                        stack.pop();
                    }
                    
                }
                i++;
            }
            if (stack.empty() && is){
                System.out.println(true);
            } else {
                System.out.println(false);
            }
		}	
	}
}

```