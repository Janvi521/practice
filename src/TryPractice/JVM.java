package TryPractice;

public class JVM {

    public static void main(String arg[]){
        JVM obj =new JVM();
        obj=null;
        System.gc();
        System.out.println("okay I will send the frequest");
    }

    public void finalize() throws Throwable {
        System.out.println("🧹 Object is being garbage collected!");
    }
}
