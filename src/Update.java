/**
 * Created by Janek Timmas on 6.03.2015.
 */
public class Update {
    private static int tick = 5;

    public static int getTick() {
        return tick;
    }

    public static void Tick() {
        Main.payDay(Main.kokkuIncome() * tick);
        System.out.println("--------------------");
        System.out.println("Raha on hetkel: " + Main.getRaha() + " eurot.");
        System.out.println("Kogumaad on hetkel: " + Main.kokkuMaad() + " ha.");
        System.out.println("Kogu sissetulek on hetkel: " + Main.kokkuIncome() + " eur/t.");
    }
}
