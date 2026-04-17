import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> participated = new HashMap<>();
        for (String name : participant) {
            participated.put(name, participated.getOrDefault(name, 0) + 1);
        }

        for (String name : completion) {
            int remaining = participated.get(name) - 1;
            if (remaining <= 0) {
                participated.remove(name);
            } else {
                participated.put(name, remaining);
            }
        }
        return participated.keySet().iterator().next();
    }
}