import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        StringBuilder result = new StringBuilder(string.length());
        for (char c : string.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                result.appendCodePoint(c - 'a' + 'A');
            } else {
                result.appendCodePoint(c - 'A' + 'a');
            }
        }
        System.out.println(result);
    }
}