/**
 * Created by dritcher on 2/20/17.
 */
public class Eraser {

    private int remainingEraseAmount;
    private final EraserDurability durability;

    public Eraser(){
        durability = EraserDurability.LOW;
        remainingEraseAmount = durability.getMaxDurabilityLength();
    }

    public Eraser(final EraserDurability durability){
        this.durability = durability;
        remainingEraseAmount = this.durability.getMaxDurabilityLength();
    }

    public void erase(final Paper paper, final String lastOccuranceOfWrittenWord){
        if(remainingEraseAmount > 0) {
            paper.erase(lastOccuranceOfWrittenWord);
            remainingEraseAmount--;
        }
    }

    public int getRemainingEraseAmount(){
        return remainingEraseAmount;
    }
}
