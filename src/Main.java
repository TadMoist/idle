/**
 * Created by Janek Timmas on 6.03.2015.
 */
public class Main {
    private static int raha;

    public static int getRaha() {
        return raha;
    }

    public static void main(String[] args) {
        Main.newGame();
    }
    public static void newGame(){
        Main.raha = 0;
        Maa tühiMaa = new Maa(1);
        Maa karjaMaa = new Maa(0);
        Maa põlluMaa = new Maa(0);
        Maa hotellMaa = new Maa(0);
    }
}
