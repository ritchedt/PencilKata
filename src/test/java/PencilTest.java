/**
 * Created by dritcher on 2/18/17.
 */
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PencilTest {

    Pencil pencil;
    Paper paper;

    @Before
    public void setUp(){
        pencil = new Pencil();
        paper = new Paper();
    }

    @Test
    public void paperShouldNotHaveAnythingWritten(){
        assertEquals(paper.getContent(), "");
    }

    @Test
    public void pencilShouldWriteMyNameIsDrewOnPaper(){
        pencil.write(paper, "My name is Drew");

        assertEquals(paper.getContent(), "My name is Drew");
    }

    @Test
    public void pencilShouldHaveALowPointDurability(){
        Pencil pencilWithLowDurability = new Pencil(Pencil.Durability.LOW);
        assertEquals(pencilWithLowDurability.getPointDurability(), 100);
    }

    @Test
    public void pencilShouldHaveAHighPointDurability(){
        Pencil pencilWithHighDurability = new Pencil(Pencil.Durability.HIGH);
        assertEquals(pencilWithHighDurability.getPointDurability(), 1000);
    }
}
