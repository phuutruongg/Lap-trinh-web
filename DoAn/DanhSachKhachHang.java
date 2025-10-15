package DoAn;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;


public class DanhSachKhachHang {
    private KhachHang[] kh;
    private int soluong;

    //----Ham thiet lap----
    public DanhSachKhachHang(){
        this.kh=new KhachHang[0];
        this.soluong=0;
    }
    
    //----Ham nhap----
    public void nhapkh(){
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong Khach hang: ");
        int n = sc.nextInt(); sc.nextLine();
        kh = new KhachHang[n];
        soluong = n;
        for (int i = 0; i < n; i++){
            System.out.println("Nhap khach hang thu " + (i + 1) + ":");
            kh[i] = new KhachHang();
            kh[i].nhap();
        }
    }

    //----Ham xuat----
    public void xuatkh(){
        if (soluong == 0) {
            System.out.println("Danh sach rong!");
            return;
        }
        System.out.println("----- DANH SACH KHACH HANG -----");
        for (int i = 0; i < soluong; i++) {
            kh[i].xuat();
            System.out.println("--------------------");
        }
    }

    //----Ham them khach hang----
    public void themvaodanhsach() {
        KhachHang khach = new KhachHang();
        khach.nhap();
        kh = Arrays.copyOf(kh, soluong + 1);
        kh[soluong] = khach;
        soluong++;
    }

    //----Ham xoa khach hang----
    public void xoakh(){
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma KH muon xoa: ");
        long maxoa = sc.nextLong();
        
        int vitri = -1;
        for (int i = 0; i < soluong; i++) {
            if (kh[i].getMakh() == maxoa) {
                vitri = i;
                break;
            }
        }
        if (vitri == -1) {
            System.out.println("Khong tim thay khach hang!");
            return;
        }
        for (int i = vitri; i < soluong - 1; i++) {
            kh[i] = kh[i + 1];
        }
        kh = Arrays.copyOf(kh, soluong - 1);
        soluong--;
        System.out.println("Xoa thanh cong!");
    }
    
    //----Ham sua khach hang----
    public void suasv() {
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma KH muon sua: ");
        long masua = sc.nextLong();
        int vitri = -1;
        for (int i = 0; i < soluong; i++) {
            if (kh[i].getMakh() == masua) {
                vitri = i;
                break;
            }
        }
        if (vitri == -1) {
            System.out.println("Khong tim thay khach hang!");
            return;
        }
        System.out.print("\nNhap ma khach hang moi: ");
        long makh = sc.nextLong();
        sc.nextLine();
        System.out.print("Nhap ho moi: ");
        String ho = sc.nextLine();
        System.out.print("Nhap ten moi: ");
        String ten = sc.nextLine();
        System.out.print("Nhap dia chi moi: ");
        String dchi = sc.nextLine();
        System.out.print("Nhap so dien thoai moi: ");
        long sdt = sc.nextLong();
        sc.nextLine();
        System.out.print("Nhap ngay sinh moi(dd/MM/yyyy): ");
        String ngaysinh = sc.nextLine();

        kh[vitri] = new KhachHang(makh,ho,ten,dchi,sdt,ngaysinh);

        System.out.println("Sua thong tin thanh cong!");
    }
    
    //--------CÁC HÀM TÌM-----------

    //----Ham tim khach hang theo makh----
    public void timTheoma() {
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma Khach Hang muon tim: ");
        int matim = sc.nextInt();
        for (int i = 0; i < soluong; i++) {
            if (kh[i].getMakh() == matim) {
                System.out.println("Tim thay khach hang:");
                kh[i].xuat();
                System.out.println("---------------------------");
            }
        }
        System.out.println("Khong tim thay Khach Hang!");
    }

    //----Ham tim khach hang theo Ten----
    public void timTheoten() {
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten (hoac ten mot phan) cua khach hang muon tim: ");
        String tentim = sc.nextLine().toLowerCase();

        for (int i = 0; i < soluong; i++) {
            if (kh[i].getTen().toLowerCase().contains(tentim)) {
                // dùng contains để tìm gần đúng
                System.out.println("Tim thay khach hang:");
                kh[i].xuat();
                System.out.println("---------------------------");
            }
        }
        System.out.println("Khong tim thay khach hang nao co ten phu hop!");
    }

    //----Ham tim khach hang theo ho----
    public void timTheoho() {
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ho (hoac ten mot phan) cua khach hang muon tim: ");
        String hotim = sc.nextLine().toLowerCase();

        for (int i = 0; i < soluong; i++) {
            if (kh[i].getTen().toLowerCase().contains(hotim)) {
                // dùng contains để tìm gần đúng
                System.out.println("Tim thay khach hang:");
                kh[i].xuat();
                System.out.println("---------------------------");
            }
        }
        System.out.println("Khong tim thay khach hang nao co ho phu hop!");
    }

    //----Ham tim khach hang theo sdt----
    public void timTheosdt() {
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so dien thoai Khach Hang muon tim: ");
        int sdttim = sc.nextInt();
        for (int i = 0; i < soluong; i++) {
            if (kh[i].getMakh() == sdttim) {
                System.out.println("Tim thay khach hang:");
                kh[i].xuat();
                System.out.println("---------------------------");
            }
        }
        System.out.println("Khong tim thay Khach Hang!");
    }

    //---------CÁC HÀM THỐNG KÊ----------

    //----hàm thống kê khách hàng theo tuổi----
    public void thongKeTheoNhomTuoi() {
        int duoi20 = 0;
        int tu20den29 = 0;
        int tren30 = 0;
    
        for (int i = 0; i < soluong; i++) {
            int tuoi = kh[i].age();  // Gọi hàm age() của từng sinh viên
    
            if (tuoi < 20) {
                duoi20++;
            } else if (tuoi < 30) {
                tu20den29++;
            } else {
                tren30++;
            }
        }
    
        System.out.println("----- Thong ke theo nhom tuoi -----");
        System.out.println("Duoi 20 tuoi: " + duoi20 + " sinh vien");
        System.out.println("Tu 20 den 29 tuoi: " + tu20den29 + " sinh vien");
        System.out.println("Tu 30 tuoi tro len: " + tren30 + " sinh vien");
    }

    //----Hàm thống kê theo Họ----
    public void thongKeTheoHo() {
        String[] cacHo = new String[0]; // Mảng chứa các họ khác nhau
        int[] demHo = new int[0];       // Mảng chứa số lượng tương ứng
    
        for (int i = 0; i < soluong; i++) {
            String ho = kh[i].getHo().trim(); // Lấy họ của khách hàng
            boolean daCo = false;
    
            for (int j = 0; j < cacHo.length; j++) {
                if (cacHo[j].equalsIgnoreCase(ho)) {
                    demHo[j]++;
                    daCo = true;
                    break;
                }
            }
    
            if (!daCo) { // Nếu họ này chưa có trong mảng
                cacHo = Arrays.copyOf(cacHo, cacHo.length + 1);
                demHo = Arrays.copyOf(demHo, demHo.length + 1);
                cacHo[cacHo.length - 1] = ho;
                demHo[demHo.length - 1] = 1;
            }
        }
    
        // In kết quả
        System.out.println("----- Thong ke theo Ho -----");
        for (int i = 0; i < cacHo.length; i++) {
            System.out.println(cacHo[i] + ": " + demHo[i] + " khach hang");
        }
    }
    
    //----Hàm thống kê theo Tên----
    public void thongKeTheoTen() {
        String[] cacTen = new String[0]; // Mảng chứa các tên khác nhau
        int[] demTen = new int[0];       // Mảng chứa số lượng tương ứng
    
        for (int i = 0; i < soluong; i++) {
            String ten = kh[i].getTen().trim(); // Lấy ten của khách hàng
            boolean daCo = false;
    
            for (int j = 0; j < cacTen.length; j++) {
                if (cacTen[j].equalsIgnoreCase(ten)) {
                    demTen[j]++;
                    daCo = true;
                    break;
                }
            }
    
            if (!daCo) { // Nếu tên này chưa có trong mảng
                cacTen = Arrays.copyOf(cacTen, cacTen.length + 1);
                demTen = Arrays.copyOf(demTen, demTen.length + 1);
                cacTen[cacTen.length - 1] = ten;
                demTen[demTen.length - 1] = 1;
            }
        }
    
        // In kết quả
        System.out.println("----- Thong ke theo Ho -----");
        for (int i = 0; i < cacTen.length; i++) {
            System.out.println(cacTen[i] + ": " + demTen[i] + " khach hang");
        }
    }

    //----thống kê khách hàng có sinh nhật trong tháng này----
    public void thongKeSinhNhatTrongThangHienTai() {
        int thangHienTai = LocalDate.now().getMonthValue(); // Lấy tháng hiện tại (1–12)
        int dem = 0;

        System.out.println("----- Danh sach khach hang co sinh nhat trong thang " + thangHienTai + " -----");

        for (int i = 0; i < soluong; i++) {
            // Lấy chuỗi ngày sinh, tách ra phần tháng
            String[] parts = kh[i].getNgaysinh().split("/");

            // Kiểm tra chuỗi có đúng định dạng dd/MM/yyyy không
            if (parts.length == 3) {
                try {
                    int thangSinh = Integer.parseInt(parts[1]);
                    if (thangSinh == thangHienTai) {
                        kh[i].xuat(); // in ra thông tin khách hàng
                        dem++;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Loi dinh dang ngay sinh cua khach hang thu " + (i + 1));
                }
            } else {
                System.out.println("Ngay sinh cua khach hang thu " + (i + 1) + " khong dung dinh dang dd/MM/yyyy!");
            }
        }

        if (dem == 0) {
            System.out.println("Khong co khach hang nao co sinh nhat trong thang nay.");
        } else {
            System.out.println("Tong cong co " + dem + " khach hang co sinh nhat trong thang nay.");
        }
    }
    
}
