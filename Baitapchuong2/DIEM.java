import java.util.Scanner;

public class DIEM {
    private int x;
    private int y;
    public DIEM() {x=0;y=0;}
    public DIEM(int x,int y) {this.x=x;this.y=y;}
    public DIEM(DIEM d){x=d.x;y=d.y;}
    public void nhap()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhap x= ");
        x=sc.nextInt();
        System.out.print("\nNhap y= ");
        y=sc.nextInt();
        sc.close();
    }
    public void xuat()
    {
        System.out.print("\n Hai diem x: " +x +" y: "+y);
    }
    public void move(int dx,int dy){
        x+=dx;
        y+=dy;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX( int xx){
        x=xx;
    }
    public void setY(int yy){
        y=yy;
    }
}
