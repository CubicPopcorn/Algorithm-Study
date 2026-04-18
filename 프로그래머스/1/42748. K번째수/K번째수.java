import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] results = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            int startIndex = command[0] - 1;
            int endIndex = command[1] - 1;
            int pickedIndex = command[2] - 1;
            int[] slicedArray = Arrays.copyOfRange(array, startIndex, endIndex + 1);
            Arrays.sort(slicedArray);
            results[i] = slicedArray[pickedIndex];
        }
        return results;
    }
}