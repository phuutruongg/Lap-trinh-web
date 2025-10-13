package Baitapchuong0;
import java.util.Scanner;

public class bai8 {
    private int n;
    private int[] a;
    //hàm_nhập
    public void nhap(){
        Scanner sc = new Scanner(System.in);

        System.out.print("\nco ba nhieu so N(n=?)= ");
        n = sc.nextInt();
        sc.close();
        
        a = new int[n]; // tạo mảng để lưu các số

        for (int i = 0; i < n; i++) {
            System.out.print("\nNhập số thứ " + (i+1) + ": ");
            a[i] = sc.nextInt();
        }
    }
    //câu_a
    public int Sum(){
        int tong=0;
        for(int i=0;i<n;i++){
                tong += a[i];
            }
        return tong;
    }
    //câu_b
    public int Sum_b(){
        int tong=0;
        for(int i=0;i<n;i++){
            if(a[i]%2 == 0){
                tong += a[i];
            }
        }
        return tong;
    }
    //câu_c
    public int Sum_c(){
        int tong=0;
        for(int i=0;i<n;i++){
            if(a[i]%2 != 0){
                tong += a[i];
            }
        }
        return tong;
    }
    //câu_d
    public int SNT(int n) {
        if (n < 2) return 0;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return 0;
        }
        return 1;
    }
    public int Sum_d(){
        int tong=0;
        for(int i=0;i<n;i++){
            if(SNT(a[i]) == 1){
                tong += a[i];
            }
        }
        return tong;
    }
    //câu_e
    public void themTai(int x, int index) {
        if (index < 0 || index > n) {
            System.out.print("Vị trí thêm không hợp lệ!");
            return;
        }
        int[] b = new int[n + 1];
        for (int i = 0, j = 0; i < b.length; i++) {
            if (i == index) {
                b[i] = x;  // chèn phần tử mới
            } else {
                b[i] = a[j++];
            }
        }
        a = b;
        n++;
    }
    //câu_f
    public void xoa(int index) {
        if (index < 0 || index >= n) {
            System.out.print("Vị trí xóa không hợp lệ!");
            return;
        }
        int[] b = new int[n - 1];
        for (int i = 0, j = 0; i < n; i++) {
            if (i != index) {
                b[j++] = a[i];
            }
        }
        a = b;
        n--;
    }
    //câu_g
    public void check(int x){
        int found = 0;
        for(int i=0; i<n; i++){
            if (a[i] == x){
                System.out.print(x + "\nTon tai trong mang o vi tri " + i);
                found = 1;
                break;
            }
        }
        if (found == 0){
            System.out.print(x + "\nKhong ton tai trong mang.");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        bai8 x = new bai8();
        x.nhap();

        System.out.println("\nTổng các số tự nhiên = " + x.Sum());
        System.out.println("\nTổng các số tự nhiên chẵn = " + x.Sum_b());
        System.out.println("\nTổng các số tự nhiên lẻ = " + x.Sum_c());
        System.out.println("\nTổng các số nguyên tố = " + x.Sum_d());
        System.out.print("\nNhập số muốn thêm: ");
        
        int y = sc.nextInt();
        System.out.print("\nNhập vị trí muốn thêm vào: ");
        int index = sc.nextInt();
        x.themTai(y, index);

        // Xóa phần tử
        System.out.print("\nNhập vị trí muốn xóa: ");
        int vitri = sc.nextInt();
        x.xoa(vitri);

        // Kiểm tra phần tử có tồn tại không
        System.out.print("\nNhập số muốn kiểm tra: ");
        int z = sc.nextInt();
        sc.close();
        x.check(z);

        // In lại mảng sau khi thay đổi
        System.out.println("\nMảng sau khi chỉnh sửa:");
        for (int i = 0; i < x.n; i++) {
        System.out.print(x.a[i] + " ");
    }
    }
}
