package TryPractice;
import java.util.*;
public class StrongNumber {

    public int factorial( int num){
        int fact=1;
        for(int i=1;i<=num;i++){
            num*=i;
        }
        return num;
    }
    public boolean isStrong(int n){
        int sum=0;
        int original=n;
        while(n>0){

            int digit=n%10;
            sum+=factorial(digit);
            n/=10;

        }
       return original== sum;
    }

    public static void main(String arg[]){
        Scanner scanner=new Scanner(System.in);
        StrongNumber strongNumber=new StrongNumber();
        System.out.println("Enter Number to check Strong or Not?");
        int num=Integer.parseInt(scanner.nextLine());
        if(strongNumber.isStrong(num)){
            System.out.println(num + " is a Strong Number.");
        }else{
            System.out.println(num + " is not Strong Number.");
        }
    }

}
