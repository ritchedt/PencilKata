/**
 * Created by dritcher on 2/20/17.
 */
public enum Durability {
    PENCIL_LOW(20),
    PENCIL_HIGH(40),
    ERASER_LOW(2),
    ERASER_HIGH(4);

    private int maxDurabilityLength;

    Durability(int maxDurabilityLength){
        this.maxDurabilityLength = maxDurabilityLength;
    }

    public int getMaxDurabilityLength(){
        return this.maxDurabilityLength;
    }
}
