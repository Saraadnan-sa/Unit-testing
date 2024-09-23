/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package rules;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit tests for RulesOf6005.
 */
public class RulesOf6005Test {
    
    /**
     * Tests the mayUseCodeInAssignment method.
     */
    @Test
    public void testMayUseCodeInAssignment() {
        assertFalse("Expected false: un-cited publicly-available code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
        assertTrue("Expected true: self-written required code",
                RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));
    }
    
    /**
     * Additional test case: Cited code that is not self-written and implementation is not required.
     */
    @Test
    public void testCitedCodeNotWrittenBySelf() {
        assertTrue("Expected true: cited non-self-written code, implementation not required",
                RulesOf6005.mayUseCodeInAssignment(false, false, false, true, false));
    }
    
    /**
     * Additional test case: Implementation is required but the code is not self-written.
     */
    @Test
    public void testImplementationRequiredButNotWrittenBySelf() {
        assertFalse("Expected false: non-self-written code, implementation required",
                RulesOf6005.mayUseCodeInAssignment(false, false, false, true, true));
    }
}
