/**
 * Created by dritcher on 2/20/17.
 */
public enum PencilDurability {
    LOW(20),
    HIGH(40);

    private int maxDurabilityLength;

    PencilDurability(int maxDurabilityLength){
        this.maxDurabilityLength = maxDurabilityLength;
    }

    public int getMaxDurabilityLength(){
        return this.maxDurabilityLength;
    }
}
