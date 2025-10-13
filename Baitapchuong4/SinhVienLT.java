package Baitapchuong4;

import java.util.Scanner;

public class SinhVienLT extends SinhVien{
    //----Thuộc tính----
    private int namTN;
    private String Nganh;

    //----Hàm Thiết Lập----
    public SinhVienLT(){
        this.namTN=0;
        this.Nganh="";
    }
    public SinhVienLT(long mssv, String ho,String ten,String ngaysinh,String gioitinh,int namTN,String Nganh){
        super(mssv,ho,ten,ngaysinh,gioitinh);
        this.namTN=namTN;
        this.Nganh=Nganh;
    }
    public SinhVienLT(SinhVienLT a){
        super(a.getMssv(), a.getHo(), a.getTen(), a.getNgaysinh(), a.getGioitinh());
        namTN=a.namTN;
        Nganh=a.Nganh;
    }

    @Override public void nhap(){
        Scanner sc = new Scanner(System.in);
        super.nhap();
        System.out.print("Nhap nam Tot Nghiep: ");
        namTN = sc.nextInt();
        sc.nextLine();
        System.out.print("\nNhap Nganh: ");
        Nganh = sc.nextLine();
        sc.close();
    }
    @Override public void xuat(){
        super.xuat();
        System.out.print("\nNam Tot Nghiep: "+ namTN);
        System.out.print("\nNganh hoc: "+Nganh);
    }

    //----Ham get----
    public int getNamtn(){
        return namTN;
    }
    public String getNganh(){
        return Nganh;
    }

    //----Ham set----
    public void setNamtn(int namTN_1){
        namTN = namTN_1;
    }
    public void setNganh(String Nganh_1){
        Nganh = Nganh_1;
    }
}
