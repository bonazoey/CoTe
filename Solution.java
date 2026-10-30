import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        set.add(a);
        set.add(b);
        set.add(c);
        
        if (set.size() == 1) {
            return ((a + b + c) * (Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2)) * (Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3)));
        } else if (set.size() == 2) {
            return ((a + b + c) * (Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2)));
        } else {
            return a + b + c;
        }
    }
}