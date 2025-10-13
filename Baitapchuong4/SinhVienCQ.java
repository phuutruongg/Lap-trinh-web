package Baitapchuong4;

import java.util.Scanner;

public class SinhVienCQ extends SinhVien {
    //----Thuộc tính----
    private int drl;

    //----Hàm Thiết Lập----
    public SinhVienCQ(){
        this.drl=0;
    }
    public SinhVienCQ(long mssv, String ho,String ten,String ngaysinh,String gioitinh,int drl){
        super(mssv,ho,ten,ngaysinh,gioitinh);
        this.drl=drl;
    }
    public SinhVienCQ(SinhVienCQ a){
        super(a.getMssv(), a.getHo(), a.getTen(), a.getNgaysinh(), a.getGioitinh());
        drl=a.drl;

    }
    //----Hàm Nhập(override)----
    @Override public void nhap() {
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        super.nhap();
        System.out.print("Nhap diem ren luyen: ");
        drl = sc.nextInt();
    }
    //-----Hàm Xuất(override)----
    @Override public void xuat(){
        super.xuat();
        System.out.print("\nDiem ren luyen: "+ drl);
    }
    
    //-----Ham get----
    public int getDrl(){
        return drl;
    }

    //----Ham set----
    public void setDrl(int drl_1){
        drl= drl_1;
    }
}
