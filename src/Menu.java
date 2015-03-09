/**
 * Created by Janek Timmas on 9.03.2015.
 */
import java.util.Scanner;

public class Menu {
    public void menu() {
        System.out.println("Kirjutage MAA, et saada üldinfot kogu maa kohta.");
        System.out.println("Kirjutage KARI, et avada karjamaa menüü.");
        System.out.println("Kirjutage PÕLD, et avada põllumaa menüü.");
        System.out.println("Kirjutage HOTELL, et avada turismi menüü.");
        System.out.println("Kirjutage MAAKLER, et osta maad juurde.");
        System.out.println("Kirjutage HELP, et saada abi ja lugeda instruktsioone");
    }
    public void maaom(){
        System.out.println("sona");
        while (true) {
            Scanner sc = new Scanner(System.in);
            String rida = sc.nextLine();
            if (rida.equalsIgnoreCase("kari")) {
                System.out.println("Teil on hetkel " + Main.karjaMaa.getMaa() + " ha seda maad");
                break;
            }
        }
    }

}

