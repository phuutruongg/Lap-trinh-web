import java.util.Scanner;

public class SoNguyen {
    private int n; // chỉ 1 thuộc tính duy nhất

    public SoNguyen() {n=0;}
    public SoNguyen(int n) {this.n=n;}
    public SoNguyen(SoNguyen d){n=d.n;}
    // nhập n từ bàn phím
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n = ");
        n = sc.nextInt();
        sc.close();
    }

    // kiểm tra số nguyên tố
    private boolean checkSNT(int x) {
        if (x < 2) return false;
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    // a. dãy 1..n và tổng
    public void tong() {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
            System.out.print(i + " ");
        }
        System.out.println("\nTổng = " + sum);
    }

    // b. dãy chẵn
    public void tongchan() {
        int sum = 0;
        for (int i = 2; i <= n; i += 2) {
            sum += i;
            System.out.print(i + " ");
        }
        System.out.println("\nTổng = " + sum);
    }

    // c. dãy lẻ
    public void tongle() {
        int sum = 0;
        for (int i = 1; i <= n; i += 2) {
            sum += i;
            System.out.print(i + " ");
        }
        System.out.println("\nTổng = " + sum);
    }

    // d. dãy số nguyên tố <= n
    public void tongSNT() {
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            if (checkSNT(i)) {
                sum += i;
                System.out.print(i + " ");
            }
        }
        System.out.println("\nTổng = " + sum);
    }

    // e. in ra n số nguyên tố đầu tiên
    public void xuat() {
        int count = 0, i = 2;
        while (count < n) {
            if (checkSNT(i)) {
                System.out.print(i + " ");
                count++;
            }
            i++;
        }
        System.out.println();
    }
    public int getN(){
        return n;
    }
    public void setN(int nn){
        n=nn;
    }
    public static void main(String[] args) {
        SoNguyen bai = new SoNguyen();
        bai.nhap();
        bai.tong();
        bai.tongchan();
        bai.tongle();
        bai.tongSNT();
        bai.xuat();
    }
}
