package Baitapchuong0;
import java.util.Scanner;

public class bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nnhập bán kính hình tròn= ");
        float r= sc.nextFloat();
        sc.close();

        System.out.print("\nchu vi: "+(Math.PI*r)+
        "\ndiện tích: "+(Math.PI*r*r));
    }
}
