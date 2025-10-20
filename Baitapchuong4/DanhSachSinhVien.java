package Baitapchuong4;

import java.util.Arrays;
import java.util.Scanner;

public class DanhSachSinhVien {
    private SinhVien[] ds;
    private int siso;

    //----Ham thiet lap----
    public DanhSachSinhVien() {
        this.ds = new SinhVien[0];
        this.siso = 0;
    }
    public DanhSachSinhVien(int siso) {
        this.siso = siso;
        this.ds = new SinhVien[siso];
    }
    public DanhSachSinhVien(DanhSachSinhVien a) {
        this.siso = a.siso;
        this.ds = new SinhVien[a.siso];
        for (int i = 0; i < a.siso; i++) {
            // Sao chép từng sinh viên (gọi hàm sao chép của SinhVienCQ hoặc SinhVien)
            this.ds[i] = a.ds[i];
        }
    }
    
    //----Ham nhap----
    public void nhapdssv(){
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong sinh vien: ");
        int n = sc.nextInt(); sc.nextLine();
        System.out.print("\nBan muon nhap sinh vien nao ? (1.CHINH QUY; 2.LIEN THONG): ");
        int chon = sc.nextInt();
        ds = new SinhVien[n];
        siso = n;
        for (int i=0;i<n;i++){
            if (chon == 1){
                ds[i]= new SinhVienCQ();
                ds[i].nhap();
            } else{
                ds[i]= new SinhVienLT();
                ds[i].nhap();
            }
        }
    }

    //----Ham xuat----
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

    //----Ham them sinh vien----
    public void themvaodanhsach() { //ko co tham so     
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        System.out.print("\nBan muon them sinh vien nao ? (1.CHINH QUY; 2.LIEN THONG): ");
        int chon = sc.nextInt();
        SinhVien sv;
        if (chon == 1) {
            sv = new SinhVienCQ();
        } else {
            sv = new SinhVienLT();
        }
        sv.nhap();

        ds = Arrays.copyOf(ds, siso + 1);
        ds[siso] = sv;
        siso++;
    }

    public void themvaodanhsach(SinhVien sv) { //co tham so 
        ds = Arrays.copyOf(ds, siso + 1);
        ds[siso] = sv;
        siso++;
    }
    

    //----Ham xoa sinh vien----
    public void xoasv() { //ko co tham so 
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma SV muon xoa: ");
        long maxoa = sc.nextLong();
        
        int vitri = -1;
        for (int i = 0; i < siso; i++) {
            if (ds[i].getMssv() == maxoa) {
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

    public void xoasv(long maxoa) { //co tham so 
        int vitri = -1;
        for (int i = 0; i < siso; i++) {
            if (ds[i].getMssv() == maxoa) {
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
    
    //----Ham sua sinh vien----
    public void suasv() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma SV muon sua: ");
        long masua = sc.nextLong();
        sc.nextLine(); // Bỏ dòng trống sau nextLong
    
        int vitri = -1;
        for (int i = 0; i < siso; i++) {
            if (ds[i].getMssv() == masua) {
                vitri = i;
                break;
            }
        }
    
        if (vitri == -1) {
            System.out.println("Khong tim thay sinh vien!");
            return;
        }
    
        // Nhập lại thông tin mới
        System.out.print("Nhap ho moi: ");
        String ho = sc.nextLine();
        System.out.print("Nhap ten moi: ");
        String ten = sc.nextLine();
        System.out.print("Nhap ngay sinh moi: ");
        String ngaysinh = sc.nextLine();
        System.out.print("Nhap gioi tinh moi: ");
        String gioitinh = sc.nextLine();
    
        // Gán lại thông tin (giữ nguyên kiểu SinhVienCQ hoặc LT)
        ds[vitri].setHo(ho);
        ds[vitri].setTen(ten);
        ds[vitri].setNgaysinh(ngaysinh);
        ds[vitri].setGioitinh(gioitinh);
    
        // Nếu là sinh viên chính quy thì cho sửa thêm điểm rèn luyện
        if (ds[vitri] instanceof SinhVienCQ) {
            System.out.print("Nhap diem ren luyen moi: ");
            int drl = sc.nextInt();
            ((SinhVienCQ) ds[vitri]).setDrl(drl);
        }
    
        // Nếu là sinh viên liên thông thì cho sửa thêm năm tốt nghiệp và ngành 
        if (ds[vitri] instanceof SinhVienLT) {
            System.out.print("Nhap nam tot nghiep moi: ");
            int namTN = sc.nextInt();
            ((SinhVienLT) ds[vitri]).setNamtn(namTN);
            System.out.print("Nhap nganh moi: ");
            String Nganh = sc.nextLine();
            ((SinhVienLT) ds[vitri]).setNganh(Nganh);
        }
    
        System.out.println("Sua thong tin thanh cong!");
    }
    
    //----Hàm Tìm----
    public void tim() {// ko có tham số 
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma SV muon tim: ");
        long matim = sc.nextLong();
        for (int i = 0; i < siso; i++) {
            if (ds[i].getMssv() == matim) {
                ds[i].xuat();
                return;
            }
        }
        System.out.println("Khong tim thay sinh vien!");
    }
    public void tim(long matim) {//có tham số 
        for (int i = 0; i < siso; i++) {
            if (ds[i].getMssv() == matim) {
                ds[i].xuat();
                return;
            }
        }
        System.out.println("Khong tim thay sinh vien!");
    }

    //----Hàm tìm theo Họ(trả về danh sách tìm thấy)----
    public SinhVien[] timTheoHo() {// ko có tham số
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ho (hoac ten mot phan) muon tim: ");
        String hotim = sc.nextLine().toLowerCase();
    
        SinhVien[] ketqua = new SinhVien[0]; // mảng rỗng ban đầu
        int dem = 0;
    
        for (int i = 0; i < siso; i++) {
            if (ds[i].getHo().toLowerCase().contains(hotim)) {
                // mở rộng mảng thêm 1 phần tử
                ketqua = Arrays.copyOf(ketqua, dem + 1);
                ketqua[dem] = ds[i];
                dem++;
            }
        }
    
        if (dem == 0) {
            System.out.println("Khong tim thay sinh vien nao co ho phu hop!");
        } else {
            System.out.println("Cac sinh vien tim thay:");
            for (int i = 0; i < dem; i++) {
                ketqua[i].xuat();
                System.out.println("---------------------------");
            }
        }
    
        return ketqua; // trả về mảng kết quả
    }
    public SinhVien[] timTheoHo(String hotim) {//có tham số
        
        SinhVien[] ketqua = new SinhVien[0]; // mảng rỗng ban đầu
        int dem = 0;
    
        for (int i = 0; i < siso; i++) {
            if (ds[i].getHo().toLowerCase().contains(hotim)) {
                // mở rộng mảng thêm 1 phần tử
                ketqua = Arrays.copyOf(ketqua, dem + 1);
                ketqua[dem] = ds[i];
                dem++;
            }
        }
    
        if (dem == 0) {
            System.out.println("Khong tim thay sinh vien nao co ho phu hop!");
        } else {
            System.out.println("Cac sinh vien tim thay:");
            for (int i = 0; i < dem; i++) {
                ketqua[i].xuat();
                System.out.println("---------------------------");
            }
        }
    
        return ketqua; // trả về mảng kết quả
    }

    //----Hàm tìm theo Tên(trả về danh sách tìm thấy)----
    public SinhVien[] timTheoTen() {// ko có tham số
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ho (hoac ten mot phan) muon tim: ");
        String tentim = sc.nextLine().toLowerCase();
    
        SinhVien[] ketqua = new SinhVien[0]; // mảng rỗng ban đầu
        int dem = 0;
    
        for (int i = 0; i < siso; i++) {
            if (ds[i].getTen().toLowerCase().contains(tentim)) {
                // mở rộng mảng thêm 1 phần tử
                ketqua = Arrays.copyOf(ketqua, dem + 1);
                ketqua[dem] = ds[i];
                dem++;
            }
        }
    
        if (dem == 0) {
            System.out.println("Khong tim thay sinh vien nao co ho phu hop!");
        } else {
            System.out.println("Cac sinh vien tim thay:");
            for (int i = 0; i < dem; i++) {
                ketqua[i].xuat();
                System.out.println("---------------------------");
            }
        }
    
        return ketqua; // trả về mảng kết quả
    }
    public SinhVien[] timTheoTen(String tentim) {//có tham số
        
        SinhVien[] ketqua = new SinhVien[0]; // mảng rỗng ban đầu
        int dem = 0;
    
        for (int i = 0; i < siso; i++) {
            if (ds[i].getTen().toLowerCase().contains(tentim)) {
                // mở rộng mảng thêm 1 phần tử
                ketqua = Arrays.copyOf(ketqua, dem + 1);
                ketqua[dem] = ds[i];
                dem++;
            }
        }
    
        if (dem == 0) {
            System.out.println("Khong tim thay sinh vien nao co ho phu hop!");
        } else {
            System.out.println("Cac sinh vien tim thay:");
            for (int i = 0; i < dem; i++) {
                ketqua[i].xuat();
                System.out.println("---------------------------");
            }
        }
    
        return ketqua; // trả về mảng kết quả
    }

    //----Hàm tìm theo ĐRL(trả về danh sách tìm thấy)----
    public SinhVien[] timTheoDrl() {// ko có tham số
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ho (hoac ten mot phan) muon tim: ");
        int drltim = sc.nextInt();
    
        SinhVien[] ketqua = new SinhVien[0]; // mảng rỗng ban đầu
        int dem = 0;
    
        for (int i = 0; i < siso; i++) {
            // Kiểm tra xem sinh viên này có phải là sinh viên CQ không
            if (ds[i] instanceof SinhVienCQ) {
                SinhVienCQ sv = (SinhVienCQ) ds[i]; // ép kiểu để dùng getDrl()
                if (sv.getDrl() == drltim) {
                    ketqua = Arrays.copyOf(ketqua, dem + 1);
                    ketqua[dem] = sv;
                    dem++;
                }
            }
        }
    
        if (dem == 0) {
            System.out.println("Khong tim thay sinh vien nao co ho phu hop!");
        } else {
            System.out.println("Cac sinh vien tim thay:");
            for (int i = 0; i < dem; i++) {
                ketqua[i].xuat();
                System.out.println("---------------------------");
            }
        }
    
        return ketqua; // trả về mảng kết quả
    }

    public SinhVien[] timTheoDrl(int drltim) {//có tham số
    
        SinhVien[] ketqua = new SinhVien[0]; // mảng rỗng ban đầu
        int dem = 0;
    
        for (int i = 0; i < siso; i++) {
            // Kiểm tra xem sinh viên này có phải là sinh viên CQ không
            if (ds[i] instanceof SinhVienCQ) {
                SinhVienCQ sv = (SinhVienCQ) ds[i]; // ép kiểu để dùng getDrl()
                if (sv.getDrl() == drltim) {
                    ketqua = Arrays.copyOf(ketqua, dem + 1);
                    ketqua[dem] = sv;
                    dem++;
                }
            }
        }
    
        if (dem == 0) {
            System.out.println("Khong tim thay sinh vien nao co ho phu hop!");
        } else {
            System.out.println("Cac sinh vien tim thay:");
            for (int i = 0; i < dem; i++) {
                ketqua[i].xuat();
                System.out.println("---------------------------");
            }
        }
    
        return ketqua; // trả về mảng kết quả
    }

    //----Hàm tìm theo năm tốt nghiệp(trả về danh sách)----
    public SinhVien[] timTheoNamTN() {// ko có tham số
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ho (hoac ten mot phan) muon tim: ");
        int namTNtim = sc.nextInt();
    
        SinhVien[] ketqua = new SinhVien[0]; // mảng rỗng ban đầu
        int dem = 0;
    
        for (int i = 0; i < siso; i++) {
            // Kiểm tra xem sinh viên này có phải là sinh viên CQ không
            if (ds[i] instanceof SinhVienLT) {
                SinhVienLT sv = (SinhVienLT) ds[i]; // ép kiểu để dùng getDrl()
                if (sv.getNamtn() == namTNtim) {
                    ketqua = Arrays.copyOf(ketqua, dem + 1);
                    ketqua[dem] = sv;
                    dem++;
                }
            }
        }
    
        if (dem == 0) {
            System.out.println("Khong tim thay sinh vien nao co ho phu hop!");
        } else {
            System.out.println("Cac sinh vien tim thay:");
            for (int i = 0; i < dem; i++) {
                ketqua[i].xuat();
                System.out.println("---------------------------");
            }
        }
    
        return ketqua; // trả về mảng kết quả
    }
    public SinhVien[] timTheoNamTN(int namTNtim) {//có tham số
    
        SinhVien[] ketqua = new SinhVien[0]; // mảng rỗng ban đầu
        int dem = 0;
    
        for (int i = 0; i < siso; i++) {
            // Kiểm tra xem sinh viên này có phải là sinh viên LT không
            if (ds[i] instanceof SinhVienLT) {
                SinhVienLT sv = (SinhVienLT) ds[i]; // ép kiểu để dùng get()
                if (sv.getNamtn() == namTNtim) {
                    ketqua = Arrays.copyOf(ketqua, dem + 1);
                    ketqua[dem] = sv;
                    dem++;
                }
            }
        }
    
        if (dem == 0) {
            System.out.println("Khong tim thay sinh vien nao co ho phu hop!");
        } else {
            System.out.println("Cac sinh vien tim thay:");
            for (int i = 0; i < dem; i++) {
                ketqua[i].xuat();
                System.out.println("---------------------------");
            }
        }
    
        return ketqua; // trả về mảng kết quả
    }

    //----Hàm thống kê theo giới tính----
    public void thongKeGioiTinh() {
        int nam = 0, nu = 0;

        for (int i = 0; i < siso; i++) {
            if (ds[i].getGioitinh().equalsIgnoreCase("Nam")) {// kiểu này viết chữ hoa chữ thường điều được
                nam++;
            } else if (ds[i].getGioitinh().equalsIgnoreCase("Nu")) {
                nu++;
            }
    }

    System.out.println("Thong ke gioi tinh:");
    System.out.println("Nam: " + nam);
    System.out.println("Nu: " + nu);
    }

    //----Hàm thống kê theo tuổi----
    public void thongKeTheoNhomTuoi() {
        int duoi18 = 0;
        int tu18den23 = 0;
        int tren23 = 0;
    
        for (int i = 0; i < siso; i++) {
            int tuoi = ds[i].age();  // Gọi hàm age() của từng sinh viên
    
            if (tuoi < 18) {
                duoi18++;
            } else if (tuoi < 30) {
                tu18den23++;
            } else {
                tren23++;
            }
        }
    
        System.out.println("----- Thong ke theo nhom tuoi -----");
        System.out.println("Duoi 18 tuoi: " + duoi18 + " sinh vien");
        System.out.println("Tu 18 den 23 tuoi: " + tu18den23 + " sinh vien");
        System.out.println("Tu 30 tuoi tro len: " + tren23 + " sinh vien");
    }
    
    //----Hàm thống kê theo xếp loại drl----
    public void thongKeTheoDrl() {
        int duoi50 = 0;
        int tu50den80 = 0;
        int tren80 = 0;
    
        for (int i = 0; i < siso; i++) {
            // Kiểm tra xem sinh viên này có phải là sinh viên CQ không
            if (ds[i] instanceof SinhVienCQ){
                SinhVienCQ sv = (SinhVienCQ) ds[i];
                if (sv.getDrl() < 50) {
                    duoi50++;
                } else if (sv.getDrl() < 80) {
                    tu50den80++;
                } else {
                    tren80++;
                }
            }
        }
    
        System.out.println("----- Thong ke theo xep loai diem ren luyen -----");
        System.out.println("Duoi 50 diem: " + duoi50 + " sinh vien");
        System.out.println("Tu 50 den 80 diem: " + tu50den80 + " sinh vien");
        System.out.println("Tu 80 diem tro len: " + tren80 + " sinh vien");
    }
    public void menu() {
        nhapdssv(); // nhập danh sách ban đầu (nếu bạn muốn)

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
            System.out.println("8. Tim theo nam Tot nghiep");
            System.out.println("9. Tim theo Diem Ren Luyen");
            System.out.println("10. Thong ke gioi tinh");
            System.out.println("11. Thong ke theo nhom tuoi");
            System.out.println("12.Thong ke theo Diem Ren Luyen");
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
            case 8: timTheoDrl(); break;
            case 9: timTheoNamTN(); break;
            case 10: thongKeGioiTinh(); break;
            case 11: thongKeTheoNhomTuoi(); break;
            case 12: thongKeTheoDrl(); break;
            case 0: System.out.println("Thoat!"); break;
            default: System.out.println("Lua chon khong hop le!");
        }
    } while (chon != 0);
    }
}
