public class testHT {
    public static void main(String[] args) {
        HinhTron ht1 = new HinhTron(); ht1.xuat();
        HinhTron ht2 = new HinhTron(5); ht2.xuat();
        HinhTron ht3 = new HinhTron(ht2); ht3.xuat();
        HinhTron ht4 = new HinhTron();
        ht4.nhap();
        ht4.xuat();
    }
}
