import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        int count = scanner.nextInt();
        System.out.println(word.repeat(count));
    }
}