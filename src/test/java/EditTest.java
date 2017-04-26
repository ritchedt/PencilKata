import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EditTest {

    private Pencil pencil;
    private Paper paper;
    private Eraser eraser;
    private String textToWrite;

    @Before()
    public void setUp(){
        pencil = new Pencil(PencilDurability.HIGH, Length.SHORT);
        paper = new Paper();
        eraser = new Eraser();
        textToWrite = "";
    }

    @After
    public void tearDown(){
        pencil = null;
        paper = null;
        eraser = null;
        textToWrite = null;
    }

    @Test
    public void previouslyErasedWordOrangeFromPaperShouldBeAppleWhenEditIsAppliedToPaperContent(){
        textToWrite = "An orange a day keeps the doctor away";
        pencil.write(paper, textToWrite);

        eraser.erase(paper, "orange");
        pencil.editFromMostRecentErasedEntry(paper, "apple");

        assertTrue(paper.getContent().equals("An apple a day keeps the doctor away"));
    }


    @Test
    public void mostRecentlyErasedWordFromPaperShouldBeTheFirstToReceiveEdit(){
        textToWrite = "I eat an orange then another orange";
        pencil.write(paper, textToWrite);

        eraser.erase(paper, "orange");
        eraser.erase(paper, "orange");
        pencil.editFromMostRecentErasedEntry(paper, "apple");

        assertTrue(paper.getContent().equals("I eat an apple then another       "));
    }
}
