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
    public void pencilShouldWriteMyNameIsDrewOnPaper(){
        pencil.write(paper, "My name is Drew");

        assertEquals(paper.getContent(), "My name is Drew");
    }
}
