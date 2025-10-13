import java.util.Scanner;

public class testDIEM 
{
    public static void main(String args[])
    {
        DIEM d1=new DIEM(); d1.xuat();
        DIEM d2=new DIEM(7,9);d2.xuat();
        DIEM d3=new DIEM(d2); d3.xuat();
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhap u= ");
        int u=sc.nextInt();
        System.out.print("\nNhap v= ");
        int v=sc.nextInt();
        DIEM d4=new DIEM(u,v); d4.xuat();
        sc.close();
    }
}
