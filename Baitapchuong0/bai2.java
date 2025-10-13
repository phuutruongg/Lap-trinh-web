package Baitapchuong0;
import java.util.Scanner;

public class bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nnhập chiều dài Hình chữ nhật= ");
        float dai= sc.nextFloat();
        System.out.print("\nnhập chiều rộng Hình chữ nhật= ");
        float rong= sc.nextFloat();
        sc.close();

        System.out.print("\nchu vi: "+(dai+rong)*2 +
        "\ndiện tích: "+(dai*rong));
    }
}
