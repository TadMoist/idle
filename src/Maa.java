/**
 * Created by Janek Timmas on 6.03.2015.
 */
public class Maa {
    private int maa;
    private int ips;

    public int getMaa() {
        return maa;
    }

    public void setMaa(int maa) {
        this.maa = maa;
    }

    public void addMaa(int maa) {
        this.maa += maa;
    }

    public int getIps() {
        return ips;
    }

    public Maa(int faktor) {
        this.ips = faktor;
    }

    public int income() {
        return maa * ips;
    }

}
