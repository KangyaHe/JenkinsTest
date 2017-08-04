package com.hky.verbalregex;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static com.hky.verbalregex.TestMatchMatcher.matchesTo;

public class BasicMethodTest2 {
	@Test
    public void testSomethingBut() {
        VerbalExpression testRegex = new VerbalExpression.Builder()
                .somethingButNot("a")
                .build();

        assertFalse("Null string", testRegex.testExact(null));
        assertFalse("empty string doesn't have something", testRegex.testExact(""));
        assertTrue("doesn't contain a", testRegex.testExact("b"));
        assertFalse("Contain a", testRegex.testExact("a"));
    }

    @Test
    public void testStartOfLine() {
        VerbalExpression testRegex = new VerbalExpression.Builder()
                .startOfLine()
                .then("a")
                .build();

        assertFalse("Null string", testRegex.testExact(null));
        assertFalse("empty string doesn't have something", testRegex.testExact(""));
        assertThat("Starts with a", testRegex, matchesTo("a"));
        assertThat("Starts with a", testRegex, matchesTo("ab"));
        assertThat("Doesn't start with a", testRegex, not(matchesTo("ba")));
    }

  

}
