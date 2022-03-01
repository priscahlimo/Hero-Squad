package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {

    @Before
    public void setUp() throws Exception {
    }

    public Squad setupSquad(){
        return new Squad("flash", 7,"restore");
    }

    @Test
    public void NewPostObjectGetsCorrectlyCreated_true() throws Exception {
        Squad squad = new Squad("flash",7,"restore");
        assertEquals(true, squad instanceof Squad);
    }


    @Test
    public void SquadInstantiatesWithMaxSize_true() {
        Squad squad = setupSquad();
        assertEquals(7, squad.getMaxSize());
    }

    @Test
    public void SquadInstantiatesWithName_true() {
        Squad squad = setupSquad();
        assertEquals("flash", squad.getName());
    }


    @Test
    public void SquadInstantiatesWithCause_true() {
        Squad squad = setupSquad();
        assertEquals("restore", squad.getCause());
    }

    @After
    public void tearDown() throws Exception {
    }
}