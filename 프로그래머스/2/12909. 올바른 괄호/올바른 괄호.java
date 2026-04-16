class Solution {
    boolean solution(String s) {
        int openedBrackets = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(' -> openedBrackets++;
                case ')' -> {
                    openedBrackets--;
                    if (openedBrackets < 0) return false;
                }
            }
        }
        return openedBrackets == 0;
    }
}