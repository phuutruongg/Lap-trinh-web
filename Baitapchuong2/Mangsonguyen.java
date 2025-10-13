import java.util.Arrays;
import java.util.Scanner;

public class Mangsonguyen{
    private int n;
    private int[] a;

    public Mangsonguyen(){n=0;}
    public Mangsonguyen(int n) {this.n=n;}
    public Mangsonguyen(Mangsonguyen d){n=d.n;}

    public void nhap(){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("\nCó bao nhiêu số(n=?): ");
        n = sc.nextInt();
        
        a = new int[n];

        for (int i = 0; i < n; i++){
            System.out.print("\nSố nguyên thứ "+ i +": ");
            a[i] =sc.nextInt();
        }
        sc.close();
    }
    public void xuat(){
        for(int i=0;i<n;i++){
            System.out.print(" " + a[i]);
        }
    }
    //câu_a(Tổng số nguyên)
    public int tong(){
        int tong=0;
        for(int i=0;i<n;i++){
                tong += a[i];
            }
        return tong;
    }
    //câu_b(Tổng số chẵn)
    public int tongChan(){
        int tong=0;
        for(int i=0;i<n;i++){
            if(a[i]%2 == 0){
                tong += a[i];
            }
        }
        return tong;
    }
    //câu_c(Tổng số lẻ)
    public int tongLe(){
        int tong=0;
        for(int i=0;i<n;i++){
            if(a[i]%2 != 0){
                tong += a[i];
            }
        }
        return tong;
    }
    //câu_d(tổng số nguyên tố)
    public int checkSNT(int n) {
        if (n < 2) return 0;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return 0;
        }
        return 1;
    }
    public int tongSNT(){
        int tong=0;
        for(int i=0;i<n;i++){
            if(checkSNT(a[i]) == 1){
                tong += a[i];
            }
        }
        return tong;
    }
    //câu_e(thêm phần tử mới)
    public void themTai(int x, int index) {
        if (index < 0|| index > n) {
            System.out.print("Vị trí thêm không hợp lệ!");
            return;
        }

        //Tăng kích thước mảng lên 1 
        a = Arrays.copyOf(a, n + 1);

        //Dịch phải cái phần tử từ index trở đi sang phải 
        for (int i=n; i>index; i--) {
        a[i] = a[i - 1];
    }
    //Gán giá trị của vị trí index bằng giá trị x 
    a[index] = x;
    n++;
    }
    //câu_f(xóa phần tử)
    public void xoaTai(int index) {
        if (index < 0 || index >= n) {
            System.out.print("Vị trí xóa không hợp lệ!");
            return;
        }
        
        // Dịch trái từ vị trí cần xóa
        for (int i = index; i < n - 1; i++) {
        a[i] = a[i + 1];
        }

        // Giảm kích thước mảng đi 1
        a = Arrays.copyOf(a, a.length - 1);
        n--;
    }
    //câu_g(kiểm tra phần tử có tồn tại trong mảng)
    public void check(int x){
        int found = 0;
        for(int i=0; i<n; i++){
            if (a[i] == x){
                System.out.print(x + " Ton tai trong mang o vi tri " + i + "\n");
                found = 1;
                break;
            }
        }
        if (found == 0){
            System.out.print(x + "\nKhong ton tai trong mang.");
        }
    }
    public int getN(){
        return n;
    }
    public void setN(int nn){
        n=nn;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Mangsonguyen x = new Mangsonguyen();
        x.nhap();

        System.out.print("\nMang vua nhap:");
        x.xuat();

        System.out.print("\nTong cac phan tu: " + x.tong());
        System.out.print("\nTong cac so chan: " + x.tongChan());
        System.out.print("\nTong cac so le: " + x.tongLe());
        System.out.print("\nTong cac so nguyen to: " + x.tongSNT());
        
        System.out.print("\nNhap phan tu muon them: ");
        int value = sc.nextInt();
        System.out.print("Nhap vi tri muon them: ");
        int index = sc.nextInt();
        x.themTai(value, index);
        System.out.print("\nMang sau khi them:");
        x.xuat();

        System.out.print("\nNhap vi tri muon xoa: ");
        int vitri = sc.nextInt();
        sc.close();
        x.xoaTai(vitri);
        System.out.print("\nMang sau khi xoa:");
        x.xuat();

        System.out.print("\nNhap phan tu muon kiem tra: ");
        int checkValue = sc.nextInt();
        x.check(checkValue);
    }
}
