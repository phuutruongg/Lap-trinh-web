package Baitapchuong0;
import java.util.Scanner;

public class bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nnhập 1 số nguyên= ");
        int a= sc.nextInt();
        sc.close();
        
        if(a%2 == 0){
            System.out.print(a+" La so chan");
        }
        else{
            System.out.print(a+" La so le");
        }
    }
}
