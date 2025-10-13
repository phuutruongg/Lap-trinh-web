import java.util.Scanner;

public class Mangchuoi {
    private String s;

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap chuoi s: ");
        s = sc.nextLine();
        sc.close();
    }

    // a. Độ dài của s
    public void doDai() {
        System.out.println("a) Do dai cua s = " + s.length());
    }

    // b. Xóa bỏ khoảng trắng thừa
    public String xoaKhoangTrang() {
        String sTrimmed = s.trim().replaceAll("\\s+", " ");
        System.out.println("b) Chuoi sau khi bo khoang trang thua: \"" + sTrimmed + "\"");
        return sTrimmed;
    }

    // c. Đếm số từ và xuất mỗi từ trên 1 dòng
    public void demTu(String str) {
        String[] words = str.split(" ");
        System.out.println("c) So tu trong s = " + words.length);
        System.out.println("Cac tu la:");
        for (String w : words) {
            System.out.println(w);
        }
    }

    // d. In k ký tự bên trái và k ký tự bên phải
    public void kyTuTraiPhai(String str) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nd) Nhap so tu nhien k: ");
        int k = sc.nextInt();
        if (k > str.length()) k = str.length();

        String left = str.substring(0, k);
        String right = str.substring(str.length() - k);
        System.out.println(k + " ky tu ben trai: " + left);
        System.out.println(k + " ky tu ben phai: " + right);
        sc.close();
    }

    // e. Xuất n ký tự từ vị trí k
    public void kyTuCon(String str) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\ne) Nhap vi tri k: ");
        int k2 = sc.nextInt();
        System.out.print("Nhap so ky tu n: ");
        int n = sc.nextInt();

        if (k2 < 0) k2 = 0;
        if (k2 + n > str.length()) {
            n = str.length() - k2;
        }
        String sub = str.substring(k2, k2 + n);
        System.out.println("Chuoi con tu vi tri " + k2 + " dai " + n + " = " + sub);
        sc.close();
    }
    public static void main(String[] args) {
        Mangchuoi c = new Mangchuoi();
        c.nhap();
        c.doDai();
        String s2 = c.xoaKhoangTrang();
        c.demTu(s2);
        c.kyTuTraiPhai(s2);
        c.kyTuCon(s2);
    }
}