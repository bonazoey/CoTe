import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        StringBuilder sb = new StringBuilder();
        
        for (String s : a.split("")) {
            if (s.matches("[a-z]")) {
                sb.append(s.toUpperCase());
            } else {
                sb.append(s.toLowerCase());
            }
        }
        System.out.println(sb.toString());
    }
}