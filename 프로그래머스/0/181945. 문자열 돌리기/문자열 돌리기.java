import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        for (char c : string.toCharArray()) {
            System.out.println(c);
        }
    }
}