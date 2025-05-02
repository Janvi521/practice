package TryPractice;

public class DemoCommandLineAr {


    public static void main(String args[]){

        int num1, num2;
        //check number of entered parameters.
        if (args.length > 0) {
            try {
                //You need to parse string values to integer
                num1 = Integer.parseInt(args[0]);
                num2 = Integer.parseInt(args[1]);
                System.out.println(args.length);

                System.out.println("Sum of numbers (Passed as Args) = ");
                System.out.println(num1 + num2);
            } catch (NumberFormatException e) {
                //Catch exception if any.
                System.err.println("Arguments must be integers.");
            }
        }
    }
}
