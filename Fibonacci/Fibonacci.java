import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter range : ");
            int range = sc.nextInt();

            int[] series = new int[range];
            series[0] = 0;
            series[1] = 1;
            for (int i = 2; i < range; i++)
                series[i] = series[i - 2] + series[i - 1];

            for (int i : series)
                System.out.print(i + " ");
        }
    }
}
