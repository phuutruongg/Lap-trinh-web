import java.util.Scanner;

public class HocVien {
    private long id;
    private String name;
    private String classes;
    private float point1;
    private float point2;
    private float point3;
    
    public HocVien() {
        id=123; 
        name = "Truong Thuan Phu"; 
        classes= "DCT124C1"; 
        point1 = 8; 
        point2 = 9; 
        point3= 10;
    }
    public HocVien(long id, String name, String classes, float point1, float point2, float point3) { 
        this.id = id; 
        this.name = name; 
        this.classes = classes; 
        this.point1 = point1; 
        this.point2 = point2; 
        this.point3 = point3;
    }
    public HocVien(HocVien a){
        id = a.id; 
        name = a.name; 
        classes = a.classes; 
        point1 = a.point1; 
        point2 = a.point2; 
        point3 = a.point3;
    }

    public void nhap()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("\n----------------------------------------------------");
        System.out.print("\nStudent's ID: ");
        id=sc.nextLong();
        sc.nextLine(); // thêm dòng này để bỏ ký tự Enter khi nhập mssv
        System.out.print("\nStudent's Name: ");
        name=sc.nextLine();
        System.out.print("\nStudent's class: ");
        classes=sc.nextLine();
        System.out.print("\nStudent's point subject 1: ");
        point1= sc.nextFloat();
        System.out.print("\nStudent's point subject 2: ");
        point2= sc.nextFloat();
        System.out.print("\nStudent's point subject 3: ");
        point3= sc.nextFloat();
        sc.close();
    }

    public void xuat()
    {
        System.out.print("\n----------------------------------------------------");
        System.out.print("\nStudent's infomation:"+
        "\nStudent's ID: "+id +
        "\nStudent's Name: "+name +
        "\nStudent's class: "+classes +
        "\nStudent's point subject 1: "+point1 +
        "\nStudent's point subject 2: "+point2 +
        "\nStudent's point subject 3: "+point3 +
        "\nStudent's average of 3 subjects point: "+avgpoint() + 
        "\nStudent rank: "+ rank() +"\n");

    }

    public float avgpoint()
    {
        return (point1+point2+point3)/3;
    }
    public String rank(){
        float dtb = avgpoint();
        if(dtb >= 8){
            return "Gioi";
        }
        else if(dtb >= 6.5){
            return "kha";
        }
        else if(dtb >= 5){
            return "trung binh";
        }
        else{
            return "yeu";
        }
    }
    public long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getClasses(){
        return classes;
    }
    public float getPoint1(){
        return point1;
    }
    public float getPoint2(){
        return point2;
    }
    public float getPoint3(){
        return point3;
    }
    public void setId(long idid){
        id=idid;
    }
    public void setName(String namename){
        name=namename;
    }
    public void setClasses(String classesclasses){
        classes=classesclasses;
    }
    public void setPoint1(int point1point1){
        point1=point1point1;
    }
    public void setPoint2(int point2point2){
        point2=point2point2;
    }
    public void setPoint3(int point3point3){
        point3=point3point3;
    }
}
