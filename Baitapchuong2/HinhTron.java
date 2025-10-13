import java.util.Scanner;

public class HinhTron 
{
    private double r;
    public HinhTron() {r=0;}
    public HinhTron(int r) {this.r = r;}
    public HinhTron(HinhTron a) {r = a.r;}
    public void nhap()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhap ban kinh= ");
        r=sc.nextDouble();
        sc.close();
    }
    public void xuat()
    {
        System.out.print("\n Hinh tron ban kinh:" +r+
        " chu vi:"+chuvi()+" dien tich:"+dientich());
    }
    public double chuvi()
    {
        return Math.PI * r;
    }
    public double dientich()
    {
        return Math.PI *r*r;
    }
    public double getR(){
        return r;
    }
    public void setR(double rr){
        r=rr;
    }
}