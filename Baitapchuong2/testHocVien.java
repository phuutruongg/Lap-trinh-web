public class testHocVien {
    public static void main(String[] args) {
        HocVien sv1= new HocVien(); sv1.xuat();
        HocVien sv2 = new HocVien(456 , "Nguyen Van Teo`" , "DCT124C1" , 8 , 9 ,10); sv2.xuat();
        HocVien sv3 = new HocVien(sv2); sv3.xuat();
        HocVien sv4= new HocVien();
        sv4.nhap();
        sv4.xuat();

        sv2.setClasses("10a12");
        System.out.print(sv2.getPoint1());
        sv2.xuat();
    }
}
