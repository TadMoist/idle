/**
 * Created by Johanna Järvsoo on 9.03.2015.
 */
import java.util.Scanner;

public class Menu {

    public static void menu() {
        System.out.println("Kirjutage MAA, et saada üldinfot kogu maa kohta.");
        System.out.println("Kirjutage KARI, et avada karjamaa menüü.");
        System.out.println("Kirjutage PÕLD, et avada põllumaa menüü.");
        System.out.println("Kirjutage HOTELL, et avada turismi menüü.");
        System.out.println("Kirjutage MAAKLER, et osta maad juurde.");
        System.out.println("Kirjutage HELP, et saada abi ja lugeda instruktsioone");
        System.out.println("Kirjutage EXIT, et minna tagasi mängima.");
    }

    public static void maaom(){
        Maa meeles = Main.tühiMaa;
        while (true) {
            Scanner sc = new Scanner(System.in);
            String rida = sc.nextLine();
            if (rida.equalsIgnoreCase("exit")){
                break;
            }
            else if (rida.equalsIgnoreCase("tagasi")){
                menu();
            }
            else if (rida.contains("ostan")){
                String[] temp = rida.split(" ");
                Ostud.tühimaaOst(Integer.parseInt(temp[1]));
                inf();
            }
            else if (rida.toLowerCase().contains("muudan")){
                String[] temp = rida.split(" ");
                if (meeles == Main.karjaMaa){
                    Ostud.karjamaaOst(Integer.parseInt(temp[1]));
                }
                else if (meeles == Main.põlluMaa){
                    Ostud.põllumaaOst(Integer.parseInt(temp[1]));
                }
                else if (meeles == Main.hotellMaa){
                    Ostud.hotelliOst(Integer.parseInt(temp[1]));
                }
                inf();
            } else if (rida.equalsIgnoreCase("maa")){
                inf();
            }
            else if(rida.equalsIgnoreCase("info")){
                System.out.println("INFO");
                System.out.println("Tere tulemast!");
                System.out.println("Te mängite hetkel idle mängu. Tegemist on mänguga, mis mängib ennast ise.");
                System.out.println("Mängu eesmärgiks on kogda võimalikult palju raha ja ehitada võimalikult suur linn.");
                System.out.println("Teie saate eesmärkide täitmisele kaasa aidata olemasoleva maa-ala suurendamise ja erineva rakendamisega.");
                System.out.println("Kirjutage EXIT, et minna tagasi mängima.");
                System.out.println("Kirjutage TAGASI, et minna tagasi menüüssee.");
                System.out.println("Ilusat mängu!");
            }
            else if(rida.equalsIgnoreCase("maakler")){
                System.out.println("MAAKLER");
                System.out.println("Teil on hetkel " + Main.getRaha() + " eurot.");
                System.out.println("Ühe hektari suuruse maatüki ostmine maksab " + Main.tühiMaa.cost() + "eurot.");
                System.out.println("Kirjutage OSTAN + HA ARV, et osta üks ha tühja maad.");
                System.out.println("Kirjutage EXIT, et minna tagasi mängima.");
                System.out.println("Kirjutage TAGASI, et minna tagasi menüüssee.");
            }
            else if (rida.equalsIgnoreCase("kari")){
                System.out.println("KARJAMAA");
                tekst(Main.karjaMaa);
                meeles = Main.karjaMaa;
            }
            else if (rida.equalsIgnoreCase("põld")){
                System.out.println("PÕLLUMAA");
                tekst(Main.põlluMaa);
                meeles = Main.põlluMaa;
            }
            else if (rida.equalsIgnoreCase("hotell")){
                System.out.println("HOTELLID");
                tekst(Main.hotellMaa);
                meeles = Main.hotellMaa;
            }
        }
    }

    public static void inf(){
        System.out.println("ÜLDINFO");
        System.out.println("Teil on hetkel " + Main.getRaha() + " eurot.");
        System.out.println("Teil on hetkel " + Main.tühiMaa.getMaa() + " ha tühja maad.");
        System.out.println("Teil on hetkel " + Main.karjaMaa.getMaa() + " ha karjamaad.");
        System.out.println("Teil on hetkel " + Main.põlluMaa.getMaa() + " ha põllumaad.");
        System.out.println("Teil on hetkel " + Main.hotellMaa.getMaa() + " ha maad hotellide all.");
        System.out.println("Karjamaa toodab hetkel " + Main.karjaMaa.income() + " eurot tunnis.");
        System.out.println("Põllumaa toodab hetkel " + Main.põlluMaa.income() + " eurot tunnis.");
        System.out.println("Hotellide kvartal toodab hetkel " + Main.hotellMaa.income() + " eurot tunnis.");
        System.out.println("Terve maatükk toodab hetkel " + Main.kokkuIncome() + " eurot tunnis.");
        System.out.println("Kirjutage EXIT, et minna tagasi mängima.");
        System.out.println("Kirjutage TAGASI, et minna tagasi menüüssee.");
    }

    public static void tekst(Maa tüüp){
        System.out.println("Teil on hetkel " + Main.getRaha() + " eurot.");
        System.out.println("Üks ha seda maad toodab " + tüüp.getAlgIps() + " eurot tunnis.");
        System.out.println("Teil on hetkel " + tüüp.getMaa() + " ha seda maad.");
        System.out.println("See maa toodab hetkel " + tüüp.income() + " eurot tunnis.");
        System.out.println("Teil on hetkel " + Main.tühiMaa.getMaa() + " ha vaba maad.");
        System.out.println("Ühe ha selleks maaks muutmine maksaks " + tüüp.cost() + " eurot.");
        System.out.println("Kogu maatüki selleks maaks muutmine maksaks " + tüüp.cost() * Main.kokkuMaad() + " eurot.");
        System.out.println("Kirjutage MUUDAN + HA ARV, et muuta osa maatükist selleks maaks.");
        System.out.println("Kirjutage EXIT, et minna tagasi mängima.");
        System.out.println("Kirjutage TAGASI, et minna tagasi menüüssee.");
    }
}
