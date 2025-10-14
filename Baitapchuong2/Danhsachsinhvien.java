import java.time.Year;
import java.util.Arrays;
import java.util.Scanner;

public class Danhsachsinhvien {
    private SinhVien[] ds;
    private int siso;

    public Danhsachsinhvien() {
        this.ds = new SinhVien[0];
        this.siso = 0;
    }

    public void nhapds() {
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong sinh vien: ");
        int n = sc.nextInt(); sc.nextLine();
        ds = new SinhVien[n];
        siso = n;
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap sinh vien thu " + (i + 1) + ":");
            ds[i] = new SinhVien();
            ds[i].nhap();
        }
    }

    public void xuatds() {
        if (siso == 0) {
            System.out.println("Danh sach rong!");
            return;
        }
        System.out.println("----- DANH SACH SINH VIEN -----");
        for (int i = 0; i < siso; i++) {
            ds[i].xuat();
            System.out.println("--------------------");
        }
    }

    public void themvaodanhsach() {
        SinhVien sv = new SinhVien();
        sv.nhap();
        ds = Arrays.copyOf(ds, siso + 1);
        ds[siso] = sv;
        siso++;
    }

    public void xoasv() {
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma SV muon xoa: ");
        String maxoa = sc.nextLine();
        
        int vitri = -1;
        for (int i = 0; i < siso; i++) {
            if (ds[i].getMaSV().equals(maxoa)) {
                vitri = i;
                break;
            }
        }
        if (vitri == -1) {
            System.out.println("Khong tim thay sinh vien!");
            return;
        }
        for (int i = vitri; i < siso - 1; i++) {
            ds[i] = ds[i + 1];
        }
        ds = Arrays.copyOf(ds, siso - 1);
        siso--;
        System.out.println("Xoa thanh cong!");
    }

    public void suasv() {
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma SV muon sua: ");
        String masua = sc.nextLine();
        int vitri = -1;
        for (int i = 0; i < siso; i++) {
            if (ds[i].getMaSV().equals(masua)) {
                vitri = i;
                break;
            }
        }
        if (vitri == -1) {
            System.out.println("Khong tim thay sinh vien!");
            return;
        }

        System.out.print("Nhap ho moi: ");
        String Ho = sc.nextLine();
        System.out.print("Nhap ten moi: ");
        String Ten = sc.nextLine();
        System.out.print("Nhap lop moi: ");
        String lop = sc.nextLine();
        System.out.print("Nhap nam sinh moi: ");
        int namsinh = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhap gioi tinh moi: ");
        String gioitinh = sc.nextLine();

        ds[vitri] = new SinhVien(masua, Ho, lop, Ten, namsinh, gioitinh);

        System.out.println("Sua thong tin thanh cong!");
}

    public void tim() {
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma SV muon tim: ");
        String matim = sc.nextLine();
        for (int i = 0; i < siso; i++) {
            if (ds[i].getMaSV().equals(matim)) {
                ds[i].xuat();
                return;
            }
        }
        System.out.println("Khong tim thay sinh vien!");
    }

    public void timTheoHo() {
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ho (hoac ten mot phan) muon tim: ");
        String hotim = sc.nextLine().toLowerCase();

        for (int i = 0; i < siso; i++) {
            if (ds[i].getHo().toLowerCase().contains(hotim)) {  
                // dùng contains để tìm gần đúng
                System.out.println("Tim thay sinh vien:");
                ds[i].xuat();
                System.out.println("---------------------------");
            }
        }
        
    System.out.println("Khong tim thay sinh vien nao co ho phu hop!");
    }

    public void timTheoTen() {
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten (hoac ten mot phan) muon tim: ");
        String tentim = sc.nextLine().toLowerCase();

        for (int i = 0; i < siso; i++) {
            if (ds[i].getTen().toLowerCase().contains(tentim)) {
                // dùng contains để tìm gần đúng
                System.out.println("Tim thay sinh vien:");
                ds[i].xuat();
                System.out.println("---------------------------");
            }
        }
        System.out.println("Khong tim thay sinh vien nao co ho phu hop!");
    }

    public void thongKeGioiTinh() {
        int nam = 0, nu = 0;

        for (int i = 0; i < siso; i++) {
            if (ds[i].getGioiTinh().equalsIgnoreCase("Nam")) {// kiểu này viết chữ hoa chữ thường điều được
                nam++;
            } else if (ds[i].getGioiTinh().equalsIgnoreCase("Nu")) {
                nu++;
            }
    }

    System.out.println("Thong ke gioi tinh:");
    System.out.println("Nam: " + nam);
    System.out.println("Nu: " + nu);
    }

    public void thongKeTheoNhomTuoi() {
        int namHienTai = Year.now().getValue();

        int duoi20 = 0;
        int duoi30 = 0;
        int tren30 = 0;

        for (int i = 0; i < siso; i++) {
            int tuoi = namHienTai - ds[i].getnamsinh();
            if (tuoi < 20) {
                duoi20++;
            } else if (tuoi < 30) {
                duoi30++;
            } else {
                tren30++;
            }
        }

    System.out.println("Thong ke theo nhom tuoi:");
    System.out.println("Duoi 20: " + duoi20 + " sinh vien");
    System.out.println("Tu 20 den 29: " + duoi30 + " sinh vien");
    System.out.println("Tu 30 tro len: " + tren30 + " sinh vien");
    }

    public void menu() {
        nhapds(); // nhập danh sách ban đầu (nếu bạn muốn)

        int chon;
        do {
            @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
            Scanner sc = new Scanner(System.in);
            System.out.println("\n---- MENU ----");
            System.out.println("1. Xuat danh sach");
            System.out.println("2. Them sinh vien");
            System.out.println("3. Xoa sinh vien");
            System.out.println("4. Tim sinh vien");
            System.out.println("5. Sua Sinh vien");
            System.out.println("6. Tim theo Ho");
            System.out.println("7. Tim theo Ten");
            System.out.println("8. Thong ke gioi tinh");
            System.out.println("9. Thong ke theo nhom tuoi");
            System.out.println("0. Thoat");
            System.out.print("Lua chon: ");
            chon = sc.nextInt();
            sc.nextLine();
            
        switch (chon) {
            case 1: xuatds(); break;
            case 2: themvaodanhsach(); break;
            case 3: xoasv(); break;
            case 4: tim(); break;
            case 5: suasv(); break;
            case 6: timTheoHo(); break;
            case 7: timTheoTen(); break;
            case 8: thongKeGioiTinh(); break;
            case 9: thongKeTheoNhomTuoi(); break;
            case 0: System.out.println("Thoat!"); break;
            default: System.out.println("Lua chon khong hop le!");
        }
    } while (chon != 0);
    }

}
