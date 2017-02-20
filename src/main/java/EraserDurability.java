/**
 * Created by dritcher on 2/20/17.
 */
public enum EraserDurability {
    LOW(2),
    HIGH(4);

    private int maxDurabilityLength;

    EraserDurability(int maxDurabilityLength){
        this.maxDurabilityLength = maxDurabilityLength;
    }

    public int getMaxDurabilityLength(){
        return this.maxDurabilityLength;
    }
}
