package TryPractice;
import java.util.*;
public class Demo1 {
    public static void main(String ar[]){
        Scanner scanner=new Scanner(System.in);
        D objc= new D();
        //objc.show();
        //objc.show();
        //objc.showD();
        System.out.println("enter number to find strong or not");
         int n=Integer.parseInt(scanner.nextLine());
         int no=0;
         int temp;
//         int pap;
//         for(int i=10;i<=(n*10);i*=10) {
//             //temp = n % i;//3
//             pap = n / i; //12
//             no++;
//         }
        //System.out.println(no);
        int multi;
        int multino;
        int plus;
         for(int i=10;i<=n;i*=10){
             temp=1;
             temp = n % i;//3
             multi=1;
             multi=temp;
             for(int j=temp-1;j>=1;j--){

                 multi*=j;
             }
             plus=multi;

             System.out.println("multi"+multi);

             System.out.println("temp"+temp);

         }
       // objc.showC();
             }
}
