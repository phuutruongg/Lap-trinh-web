import java.util.Scanner;
 
public class HinhChuNhat
{
    private float dai;
    private float rong;
    public HinhChuNhat() {dai=0;rong=0;}
    public HinhChuNhat(int dai,int rong) {this.dai = dai; this.rong = rong;}
    public HinhChuNhat(HinhChuNhat a) {dai=a.dai; rong=a.rong;}
    public void nhap() {}
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhap dai");
        dai=sc.nextFloat();
        System.out.print("\nNhap rong");
        rong=sc.nextFloat();
        sc.close();
    }
    public void xuat()
    {
        System.out.print("\n Hinh chu nhat dai:" +dai+"rong:"+rong+
        "chu vi:"+chuvi()+"dien tich:"+dientich());
    }
    public float chuvi()
    {
        return (dai+rong)*2;
    }
    public float dientich()
    {
        return dai*rong;
    }
    public float getDAI(){
        return dai;
    }
    public float getRONG(){
        return rong;
    }
    public void setDAI(float daidai){
        dai=daidai;
    }
    public void setRONG(float rongrong){
        rong=rongrong;
    }
}