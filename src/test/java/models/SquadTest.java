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
        return new Squad("flash");
    }

    @Test
    public void NewPostObjectGetsCorrectlyCreated_true() throws Exception {
        Squad squad = new Squad("flash");
        assertEquals(true, squad instanceof Squad);
    }

    @After
    public void tearDown() throws Exception {
    }
}