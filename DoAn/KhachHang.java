package DoAn;

import java.util.Scanner;

public class KhachHang {
    private long makh;
    private String ho;
    private String ten;
    private String dchi;
    private long sdt;
    private int namsinh;

    public KhachHang(){
        this.makh=0;
        this.ho="";
        this.ten="";
        this.dchi="";
        this.sdt=0;
        this.namsinh=0;
    }
    public KhachHang(long makh,String ho,String ten,String dchi,long sdt,int namsinh){
        this.makh=makh;
        this.ho=ho;
        this.ten=ten;
        this.dchi=dchi;
        this.sdt=sdt;
        this.namsinh=namsinh;
    }
    
    public void nhap(){
        @SuppressWarnings("resource")//Dòng bỏ qua cái sc vàng 
        Scanner sc = new Scanner(System.in);
        System.out.print("\nMa Khach Hang: ");
        makh = sc.nextLong();
        sc.nextLine();
        System.out.print("\nHo: ");
        sc.nextLine();
        System.out.print("\nTen: ");
        sc.nextLine();
        System.out.print("\nDia chi: ");
        sc.nextLine();
        System.out.print("\nSo dien thoai: ");
        sc.nextLong();
        System.out.print("\nNam sinh: ");
        sc.nextInt();
    }

    public void xuat(){
        System.out.printf("%-10d %-10s %-5s %-10s %-10d %-10d%n");
    }

    //----Hàm get/set----
    public long getMakh(){
        return makh;
    }
    public String getHo(){
        return ho;
    }
    public String getTen(){
        return ten;
    }
    public String getDiachi(){
        return dchi;
    }
    public long getSdt(){
        return sdt;
    }
    public int getNamsinh(){
        return namsinh;
    }

    public void setMakh(long makh_x){
        makh=makh_x;
    }
    public void setHo(String ho_x){
        ho=ho_x;
    }
    public void setTen(String ten_x){
        ten=ten_x;
    }
    public void setDiachi(String dchi_x){
        dchi=dchi_x;
    }
    public void setSdt(long sdt_x){
        sdt=sdt_x;
    }
    public void setNamsinh(int namsinh_x){
        namsinh=namsinh_x;
    }
}
