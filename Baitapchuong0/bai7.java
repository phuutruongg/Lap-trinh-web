package Baitapchuong0;
import java.util.Scanner;

public class bai7
{
    public static boolean ktsnt(int n){
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n%i == 0)
                return false;
                
        return n>1;
    }
    
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
	    int n = sc.nextInt();
		sc.close();
	    
	    //Cau a
	    int sum = 0;
	    System.out.println("Cau a.");
	    for (int i = 1; i <= n; i++){
	        sum += i;
	        System.out.print(i + " ");
	    }
	    System.out.println("\nTong = " + sum);
	    
	    //Cau b
	    sum = 0;
	    System.out.println("Cau b.");
	    for (int i = 2; i <= n; i+=2){
	        sum += i;
	        System.out.print(i + " ");
	    }
	    System.out.println("\nTong = " + sum);
	    
	    //Cau c
	    sum = 0;
	    System.out.println("Cau c.");
	    for (int i = 1; i <= n; i+=2){
	        sum += i;
	        System.out.print(i + " ");
	    }
	    System.out.println("\nTong = " + sum);
	    
	    //Cau d
	    sum = 0;
	    System.out.println("Cau d.");
	    for (int i = 2; i <= n; i+=1){
	        if (ktsnt(i)){
	            sum += i;
	            System.out.print(i + " ");
	        }
	    }
	    System.out.println("\nTong = " + sum);
	    
	    //Cau e
	    System.out.println("Cau e.");
	    
	    for (int i = 2; n > 0; i++)
	        if (ktsnt(i)){
	            System.out.print(i + " ");
	            n--;
	        }
	}
}