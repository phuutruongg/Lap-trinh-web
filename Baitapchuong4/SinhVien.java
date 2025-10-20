package Baitapchuong4;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


abstract public class SinhVien {
    //----Thuộc Tính----
    private long mssv;
    private String ho;
    private String ten;
    private String ngaysinh;
    private String gioitinh;

    //----Các Hàm Thiết Lập----
    public SinhVien() {
        this.mssv = 0;
        this.ho = "";
        this.ten="";
        this.ngaysinh="";
        this.gioitinh="";
    }
    
    public SinhVien(long mssv, String ho,String ten,String ngaysinh,String gioitinh) {
        this.mssv = mssv;
        this.ho = ho;
        this.ten=ten;
        this.ngaysinh=ngaysinh;
        this.gioitinh=gioitinh;
    }
    public SinhVien(SinhVien a){
        mssv=a.mssv;
        ho=a.ho;
        ten=a.ten;
        ngaysinh=a.ngaysinh;
        gioitinh=a.gioitinh;
    }

    //----Hàm Nhập----
    public void nhap() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap Ma sinh vien: ");
        mssv = sc.nextLong();
        sc.nextLine();
        System.out.print("Nhap Ho: ");
        ho = sc.nextLine();
        System.out.print("Nhap Ten: ");
        ten = sc.nextLine();
        System.out.print("Nhap Ngay sinh (dd/MM/yyyy): ");
        ngaysinh = sc.nextLine();
        System.out.print("Nhap Gioi tinh: ");
        gioitinh = sc.nextLine();
    }

    //----Hàm Xuất----
    public void xuat() {
        System.out.printf("%-10d %-10s %-5s %-10s %-10s %-10d",
            mssv, ho, ten, gioitinh, ngaysinh,age());
    }

    //----Hàm Tính Tuổi----
    public int age(){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate = LocalDate.parse(ngaysinh, df);
        LocalDate today = LocalDate.now();
        return Period.between(birthDate, today).getYears();
    }

    //----Hàm Get----
    public long getMssv() {
        return mssv;
    }
    public String getHo(){
        return ho;
    }
    public String getTen(){
        return ten;
    }
    public String getGioitinh(){
        return gioitinh;
    }
    public String getNgaysinh(){
        return ngaysinh;
    }

    //----Hàm Set----
    public void setMssv(long mssv_1){
        mssv = mssv_1;
    }
    public void setHo(String ho_1){
        ho = ho_1;
    }
    public void setTen(String ten_1){
        ten = ten_1;
    }
    public void setGioitinh(String gioitinh_1){
        gioitinh = gioitinh_1;
    }
    public void setNgaysinh(String ngaysinh_1){
        ngaysinh = ngaysinh_1;
    }
}
