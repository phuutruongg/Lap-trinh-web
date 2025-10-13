package Baitapchuong0;
import java.util.Scanner;

public class bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("\nnhap a= ");
        int a = sc.nextInt();
        System.out.print("\nnhap b= ");
        int b = sc.nextInt();
        sc.close();

        System.out.print("\ntổng: "+(a+b) +
        "\nhiệu: "+(a-b) +
        "\ntích: "+(a*b) +
        "\nthương: "+(a/b));
    }
}
