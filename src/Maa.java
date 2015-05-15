/**
 * Created by Janek Timmas on 6.03.2015.
 */
public class Maa {
    private int maa;
    private int algIps;
    private int algHind;


    public int getMaa() {
        return maa;
    }

    public void setMaa(int maa) {
        this.maa = maa;
    }

    public void addMaa(int maa) {
        this.maa += maa;
    }

    public int getAlgIps() {
        return algIps;
    }

    public int getAlgHind() {
        return algHind;
    }

    public void setAlgHind(int Hind) {
        this.algHind = Hind;
    }

    public Maa(int faktor, int algHind) {
        this.algIps = faktor;
        this.algHind = algHind;
    }

    public int cost() {
        return (int) (this.algHind * 1.1);
    }

    public int income() {
        return maa * algIps;
    }

}
