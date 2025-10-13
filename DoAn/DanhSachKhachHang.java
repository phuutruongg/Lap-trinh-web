package DoAn;

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
    System.out.print("Nhap nam sinh moi: ");
    int namsinh = sc.nextInt();

    kh[vitri] = new KhachHang(makh,ho,ten,dchi,sdt,namsinh);

    System.out.println("Sua thong tin thanh cong!");
}
}
