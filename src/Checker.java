/**
 * Created by Janek Timmas on 8.03.2015.
 * Eraldi lõime, mis kontrollib, kas kasutaja on enterit vajutanud või soovib lahkuda.
 */
import java.util.Scanner;

public class Checker implements Runnable {
    Scanner sc = new Scanner(System.in);
    @Override
    public void run() {
        while(true){
            String test = sc.nextLine();
            if (test.equals("")){
                Main.setPressed(true);
            }
            else if (test.equals("exit")){
                Main.setEnd(true);
                break;
            }
        }
    }
}
