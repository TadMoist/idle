public class Main {
    public static Maa tühiMaa = new Maa(1, 100);
    public static Maa karjaMaa = new Maa(10, 250);
    public static Maa põlluMaa = new Maa(50, 500);
    public static Maa hotellMaa = new Maa(100, 1000);
    private static int raha;

    private static boolean pressed = false;
    private static boolean end = false;
    public static final Thread lõime = new Thread(new Checker());

    public static void setEnd(boolean end) {
        Main.end = end;
    }

    public static void setPressed(boolean pressed) {
        Main.pressed = pressed;
    }

    public static int getRaha() {
        return raha;
    }

    public static void payDay(int x) {
        raha += x;
    }

    public static void main(String[] args) throws InterruptedException {
        Main.newGame();
        int tick = Update.getTick();
        while (true) {
            while(!pressed && !end) {
                Update.Tick();
                Thread.sleep(tick * 1000);
            }
            if (end)
                break;

            Menu.menu();
            Menu.maaom();
            pressed = false;
            synchronized (lõime) {
                lõime.notifyAll();
            }
        }
    }

    public static void newGame() {
        Main.raha = 10000;
        tühiMaa.setMaa(1);
        lõime.start();
    }

    public static int kokkuMaad() {
        return tühiMaa.getMaa() + karjaMaa.getMaa() + põlluMaa.getMaa() + hotellMaa.getMaa();
    }

    public static int kokkuIncome() {
        return tühiMaa.income() + karjaMaa.income() + põlluMaa.income() + hotellMaa.income();
    }
}
