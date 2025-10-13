package Baitapchuong0;
import java.util.Scanner;

public class bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nnhập 1 số nguyên= ");
        int a= sc.nextInt();
        sc.close();
        
        if(a == 0){
            System.out.print(a+" La so bang khong");
        }
        else if (a>0){
            System.out.print(a+" La so duong");
        }
        else{
            System.out.print(a+" La so am");
        }
    }
}    
