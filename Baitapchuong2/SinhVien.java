import java.util.Scanner;

class SinhVien {
    private String maSV;
    private String Ho;
    private String Ten;
    private int namsinh;
    private String gioitinh;
    private String lop;

    public SinhVien() {
        this.maSV = "";
        this.Ho = "";
        this.lop = "";
        this.Ten="";
        this.namsinh=0;
        this.gioitinh="";
    }

    public SinhVien(String maSV, String Ho, String lop,String Ten,int namsinh,String gioitinh) {
        this.maSV = maSV;
        this.Ho = Ho;
        this.lop = lop;
        this.Ten=Ten;
        this.namsinh=namsinh;
        this.gioitinh=gioitinh;
    }

    public void nhap() {
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma sinh vien: ");
        maSV = sc.nextLine();
        System.out.print("Nhap Ho: ");
        Ho = sc.nextLine();
        System.out.print("Nhap Ten: ");
        Ten = sc.nextLine();
        System.out.print("Nhap lop: ");
        lop = sc.nextLine();
        System.out.print("Nhap nam sinh: ");
        namsinh = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhap gioi tinh: ");
        gioitinh = sc.nextLine();
    }

    public void xuat() {
        System.out.println("Ma SV: " + maSV);
        System.out.println("Ho ten: " + Ho + " " + Ten);
        System.out.println("Lop: " + lop);
        System.out.println("Ngay sinh: " + namsinh);
        System.out.println("gioitinh: " + gioitinh);
    }

    public String getMaSV() {
        return maSV;
    }
    public String getHo(){
        return Ho;
    }
    public String getTen(){
        return Ten;
    }
    public String getGioiTinh(){
        return gioitinh;
    }
    public int getnamsinh(){
        return namsinh;
    }
}