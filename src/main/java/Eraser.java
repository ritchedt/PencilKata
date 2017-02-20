/**
 * Created by dritcher on 2/20/17.
 */
public class Eraser {

    private int allowableEraseAmount;
    private final EraserDurability durability;

    public Eraser(){
        durability = EraserDurability.LOW;
        allowableEraseAmount = durability.getMaxDurabilityLength();
    }

    public Eraser(EraserDurability durability){
        this.durability = durability;
        allowableEraseAmount = this.durability.getMaxDurabilityLength();
    }

    public void erase(Paper paper, String lastOccuranceOfWrittenWord){
        if(allowableEraseAmount > 0) {
            paper.erase(lastOccuranceOfWrittenWord);
            allowableEraseAmount--;
        }
    }

    public int getAllowableEraseAmount(){
        return allowableEraseAmount;
    }
}
