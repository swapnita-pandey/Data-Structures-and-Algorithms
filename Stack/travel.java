import java.awt.*;
import java.util.*;
import java.io.*;
import java.util.ArrayList;

class travel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter: ");
        String s = sc.nextLine();
        s = s + " ";
        int initial = 0, c = 0;
        int n = sc.nextInt();
        int l = s.length();
        for (int i = 0; i < l; i++) {
            if (s.charAt(i) == ' ') {
                String s1 = s.substring(initial, i);
                System.out.println(s1);
                initial = i + 1;
                String temp = s1 + s1;
                int l1 = s1.length();
                String str = temp.substring(n, n + l1);
                System.out.println(str);
                if (str == s1)
                    c++;
            }
        }

        System.out.println(c);
    }
}
