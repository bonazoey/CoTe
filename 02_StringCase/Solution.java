import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        char[] chars = a.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            chars[i] = (c >= 'a' && c <= 'z')
                    ? (char) (c - 'a' + 'A')
                    : (char) (c - 'A' + 'a');
        }

        System.out.println(chars);
    }
}