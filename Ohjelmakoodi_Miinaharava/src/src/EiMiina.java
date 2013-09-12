
package src;

public class EiMiina extends Nappi {
    private int xkoordinaatti;
    private int ykoordinaatti;
    private Boolean onNakyva;
    private String piilotettuTeksti;
    private int miinojaYmparilla;

    public EiMiina(int xkoordinaatti, int ykoordinaatti) {
        super(xkoordinaatti, ykoordinaatti, 0+"");
    }
    
    @Override
    public void lisaaMiinaViereen() {
        this.miinojaYmparilla++;
        setPiilotettuTeksti(this.miinojaYmparilla+"");
    }

    public int getMiinojaYmparilla() {
        return miinojaYmparilla;
    }
}
