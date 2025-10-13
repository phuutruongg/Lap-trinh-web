import java.util.Arrays;
import java.util.Scanner;

public class MangSinhVien {
    private long id_student;
    private String name;
    private String classes;
    private String sex;
    private String faculty;
    private long id_faculty;
    private long id_major;
    private String address;
    private int n;
    private MangSinhVien[] a;
    Scanner sc = new Scanner(System.in);
    public void nhap(){ 
 
        System.out.print("\nHow many student(n=?): ");
        n = sc.nextInt();
        a = new MangSinhVien[n];

        for (int i = 0; i < n; i++){
            a[i] = new MangSinhVien(); //Tạo mảng để lưu các số 
            System.out.print("\n----------------------------------------------------");
            System.out.print("\nStudent's ID: ");
            a[i].id_student=sc.nextLong();
            sc.nextLine(); // thêm dòng này để bỏ ký tự Enter khi nhập mssv
            System.out.print((i+1) + "\nStudent's infomation:");
            System.out.print("\nStudent's Name: ");
            a[i].name =sc.nextLine();
            System.out.print("\nStudent's class: ");
            a[i].classes=sc.nextLine();
            System.out.print("\nStudent's sex: ");
            a[i].sex=sc.nextLine();
            System.out.print("\nStudent's faculty: ");
            a[i].faculty=sc.nextLine();
            System.out.print("\nID of faculty: ");
            a[i].id_faculty=sc.nextLong();
            System.out.print("\nID of major: ");
            a[i].id_major=sc.nextLong();
            sc.nextLine(); // thêm dòng này để bỏ ký tự Enter khi nhập
            System.out.print("\nStudent's address: ");
            a[i].address=sc.nextLine();
        }
    }

    public void xuat(){
        for (int i=0 ; i<n ; i++){
            System.out.print("\n----------------------------------------------------");
            System.out.print("\nStudent's infomation:"+
            "\nStudent's ID: "+ a[i].id_student +
            "\nStudent's Name: "+ a[i].name +
            "\nStudent's class: "+ a[i].classes + 
            "\nStudent's sex: "+ a[i].sex + 
            "\nStudent's faculty: "+ a[i].faculty +
            "\nID of faculty: "+a[i].id_faculty + 
            "\nID of major: "+ a[i].id_major + 
            "\nStudent's address: "+ a[i].address +"\n");
        }
        System.out.print("Total student in the list: " + n);

    }

    public void themTai(MangSinhVien x, int index) {
        if (index < 0) {
            System.out.print("Invalid position for adding!");
            return;
        }
        //Tăng kích thước mảng lên 1 
        a = Arrays.copyOf(a, n + 1);

        //Dịch phải cái phần tử từ index trở đi sang phải 
        for (int i=n; i>index; i--) {
        a[i] = a[i - 1];
        }
        //Gán giá trị của vị trí index bằng giá trị x 
        a[index] = x;
        n++;
    }

    public void xoa(int index){
        if (index < 0 || index >= n) {
            System.out.print("Invalid position for deleting!");
            return;
        }
        
        // Dịch trái từ vị trí cần xóa
        for (int i = index; i < n - 1; i++) {
            a[i] = a[i + 1];
        }
    
        // Giảm kích thước mảng đi 1
        a = Arrays.copyOf(a, a.length - 1);
        n--;
    }

    public void check(MangSinhVien x){
        int found = 0;
        for(int i=0; i<n; i++){
            if (a[i].name.equals(x.name)){
                System.out.print(x.name + "\nThe student is in the list at position " + i);
                found = 1;
                break;
            }
        }
        if (found == 0){
            System.out.print(x.name + "\nThe student is NOT in the list!");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MangSinhVien x = new MangSinhVien();
        x.nhap();
        
        //Thêm phần tử
        MangSinhVien y = new MangSinhVien();

        System.out.print("\nEnter student information to add: ");
        System.out.print("\nStudent's ID: ");
        y.id_student = sc.nextLong();
        sc.nextLine();
        System.out.print("\nStudent's name: ");
        y.name = sc.nextLine();
        System.out.print("\nStudent's class: ");
        y.classes = sc.nextLine();
        System.out.print("\nStudent's sex: ");
        y.sex=sc.nextLine();
        System.out.print("\nStudent's faculty: ");
        y.faculty=sc.nextLine();
        System.out.print("\nID of faculty: ");
        y.id_faculty=sc.nextLong();
        System.out.print("\nID of major: ");
        y.id_major=sc.nextLong();
        sc.nextLine();
        System.out.print("\nStudent's address: ");
        y.address=sc.nextLine();

        System.out.print("\nThe number of the position u want to add: ");
        int index = sc.nextInt();
        sc.nextLine();
        x.themTai(y, index);

        // Xóa phần tử
        System.out.print("\nThe numer of the position u want to delete: ");
        int vitri = sc.nextInt();
        sc.nextLine();
        x.xoa(vitri);

        //xuất mảng lại sau khi đã thay đổi 
        System.out.print("\nThe list afer changes:");
        x.xuat();

        // Kiểm tra phần tử có tồn tại không
        System.out.print("\nEnter student information to check: ");
        String z = sc.nextLine();
        MangSinhVien tmp = new MangSinhVien();
        tmp.name = z;
        x.check(tmp);
        sc.close();
    }
}