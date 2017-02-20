/**
 * Created by dritcher on 2/20/17.
 */
public enum Length {
    SHORT(1),
    LONG(3);

    private int maxTimesPencilCanBeSharpened;

    Length(int maxTimesPencilCanBeSharpened){
        this.maxTimesPencilCanBeSharpened = maxTimesPencilCanBeSharpened;
    }

    public int getMaxSharpenAmount(){
        return this.maxTimesPencilCanBeSharpened;
    }
}
