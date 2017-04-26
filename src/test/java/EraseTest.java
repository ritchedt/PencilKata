import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EraseTest {

    private Pencil pencil;
    private Paper paper;
    private Eraser eraser;
    private String textToWrite;

    @Before()
    public void setUp(){
        pencil = new Pencil(PencilDurability.HIGH, Length.LONG);
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
    public void pencilShouldBeAbleToEraseCoolFromPaperContainingVeryCoolCool(){
        textToWrite = "Very Cool Cool";
        pencil.write(paper, textToWrite);
        eraser.erase(paper, "Cool");

        assertTrue(paper.getContent().equals("Very Cool     "));
    }

    @Test
    public void pencilShouldBeAbleToEraseTheFirstChuckThenTheSecondChuckFromPaperContainingWoodChuckChuckIfAWoodchuckCouldChuckWood(){
        textToWrite = "woodchuck chuck if a woodchuck could chuck wood";
        pencil.write(paper, textToWrite);

        eraser.erase(paper, "chuck");
        eraser.erase(paper, "chuck");

        assertTrue(paper.getContent().equals("woodchuck chuck if a wood      could       wood"));
    }

    @Test
    public void eraserShouldHaveALowEraserDurability(){
        assertEquals(2, eraser.getRemainingEraseAmount());
    }

    @Test
    public void eraserShouldHaveAHighEraserDurability(){
        eraser = new Eraser(EraserDurability.HIGH);
        assertEquals(4, eraser.getRemainingEraseAmount());
    }

    @Test
    public void eraserWithHighEraserDurablitilyShouldBeAbleToEraseUpToFourTimes(){
        eraser = new Eraser(EraserDurability.HIGH);
        textToWrite = "repeat1 repeat2 repeat3 repeat4 repeat5";
        pencil.write(paper, textToWrite);

        eraser.erase(paper, "repeat5");
        eraser.erase(paper, "repeat4");
        eraser.erase(paper, "repeat3");
        eraser.erase(paper, "repeat2");

        assertEquals(0, eraser.getRemainingEraseAmount());
        assertTrue(paper.getContent().equals("repeat1                                "));
    }

    @Test
    public void eraserWithHighEraserDurablitilyShouldNotBeAbleToEraseMoreThanFourTimes(){
        eraser = new Eraser(EraserDurability.HIGH);
        textToWrite = "repeat1 repeat2 repeat3 repeat4 repeat5";
        pencil.write(paper, textToWrite);

        eraser.erase(paper, "repeat5");
        eraser.erase(paper, "repeat4");
        eraser.erase(paper, "repeat3");
        eraser.erase(paper, "repeat2");
        eraser.erase(paper, "repeat1");

        assertTrue(paper.getContent().equals("repeat1                                "));
    }
}
