package TryPractice;

class Example {
    static int number;

    static {
        System.out.println("Static block executed");
        number = 100;
    }

    public static void showNumber() {
        System.out.println("Number: " + number);
    }
}

