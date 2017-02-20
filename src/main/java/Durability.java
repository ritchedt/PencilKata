/**
 * Created by dritcher on 2/20/17.
 */
public enum Durability {
    LOW (20),
    HIGH(40);

    private int maxCharLengthBeforeGoingDull;

    Durability(int maxCharLengthBeforeGoingDull){
        this.maxCharLengthBeforeGoingDull = maxCharLengthBeforeGoingDull;
    }

    public int getMaxCharLength(){
        return this.maxCharLengthBeforeGoingDull;
    }
}
