package za.ac.nwu.ac.logic.flow.impl;

import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

import javax.management.RuntimeErrorException;

public class ModuloTest {

    private Modulo mod;

    @Before
    public void setUp() throws Exception {
        mod = new Modulo();
    }

    @Test
    public void testMod() {
        mod = new Modulo();
        Integer result = mod.doMod(9,5);
        assertNotNull( "Value should not be null",result);
        assertEquals( "Value should be 4",4,result.intValue());
    }

    @Test()
    public void testModByZero() throws Exception {
        try {
            mod = new Modulo();
            mod.doMod(9,0);
            fail("Should throw an exception");
        } catch (Exception e) {
            assertTrue("Test Failed",e.getMessage().equalsIgnoreCase("An error has occurred"));
        }
    }
}
