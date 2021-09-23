package za.ac.nwu.ac.logic.flow.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
    import static org.junit.jupiter.api.Assertions.assertTrue;

class FetchAccountTypeFlowImplTest {

    private FetchAccountTypeFlowImpl testClass;

    @BeforeEach
    void setUp() {
        testClass = new FetchAccountTypeFlowImpl(null);
    }

    @AfterEach
    void tearDown() {
        testClass = null;
    }

    @Test
    void methodToTest() {
        assertTrue(testClass.methodToTest());
    }
}