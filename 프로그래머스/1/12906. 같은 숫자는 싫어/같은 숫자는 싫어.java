import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> result = new ArrayList<>();
        for (int item : arr) {
            if (result.isEmpty() || item != result.get(result.size() - 1)){
                result.add(item);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}