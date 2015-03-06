/**
 * Created by Janek Timmas on 6.03.2015.
 */
public class Main {
    public static Maa tühiMaa = new Maa(1);
    public static Maa karjaMaa = new Maa(10);
    public static Maa põlluMaa = new Maa(50);
    public static Maa hotellMaa = new Maa(100);
    private static int raha;

    public static int getRaha() {
        return raha;
    }

    public static void payDay(int x) {
        raha += x;
    }

    public static void main(String[] args) throws InterruptedException {
        Main.newGame();
        int tick = Update.getTick();
        for (int i = 0; i < 100; i++) {
            Update.Tick();
            Thread.sleep(tick * 1000);
        }
    }

    public static void newGame() {
        Main.raha = 0;
        tühiMaa.setMaa(1);
    }

    public static int kokkuMaad() {
        return tühiMaa.getMaa() + karjaMaa.getMaa() + põlluMaa.getMaa() + hotellMaa.getMaa();
    }

    public static int kokkuIncome() {
        return tühiMaa.income() + karjaMaa.income() + põlluMaa.income() + hotellMaa.income();
    }
}
