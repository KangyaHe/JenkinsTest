package com.hky.verbalregex;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static com.hky.verbalregex.TestMatchMatcher.matchesTo;


public class BasicMethodTest {

	@Test
    public void testSomething() {
        VerbalExpression testRegex = new VerbalExpression.Builder().something().build();

        assertThat("Null object doesn't have something", testRegex, not(matchesTo(null)));
        assertThat("empty string doesn't have something", testRegex, not(matchesTo("")));
        assertThat("a", testRegex, matchesTo("a"));
    }

    @Test
    public void testAnything() {
        VerbalExpression testRegex = new VerbalExpression.Builder()
                .startOfLine()
                .anything()
                .build();

        assertThat(testRegex, matchesTo("what"));
        assertThat(testRegex, not(matchesTo("")));
        assertThat(testRegex, matchesTo(" "));
    }

    @Test
    public void testAnythingBut() {
        VerbalExpression testRegex = new VerbalExpression.Builder()
                .startOfLine()
                .anythingBut("w")
                .build();

        assertFalse("starts with w", testRegex.testExact("what"));
        assertTrue("Not contain w", testRegex.testExact("that"));
        assertTrue("Not contain w", testRegex.testExact(" "));
        assertFalse("Null object", testRegex.testExact(null));
    }

}
