public class TestHCN
{
    public static void main(String args[])
    {
        HinhChuNhat hcn1 = new HinhChuNhat(); hcn1.xuat();
        HinhChuNhat hcn2 = new HinhChuNhat(2,4); hcn2.xuat();
        HinhChuNhat hcn3 = new HinhChuNhat(hcn2); hcn3.xuat();
        HinhChuNhat hcn4 = new HinhChuNhat();
        hcn4.nhap();
        hcn4.xuat();
    }
}