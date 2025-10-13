package Baitapchuong0;
import java.util.Scanner;

public class bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nnhập 1 số nguyên duong= ");
        int a = sc.nextInt();
        sc.close();

        if(a <= 1){
            System.out.print(a+" khong la so nguyen to\n");
        }
        for (int i=2;i<=Math.sqrt(a);i++){
            if(a%i == 0){
                System.out.print(a+" không là số nguyên tố.\n");
                break;
            }
            else{
                System.out.print(a+" la so nguyen to\n");
            }
        }
    }
}
