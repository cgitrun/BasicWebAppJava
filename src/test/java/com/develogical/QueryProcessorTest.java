package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsTeamName() throws Exception {
        assertThat(queryProcessor.process("What is your name?"), containsString("RobTest"));
    }

    @Test
    public void findsPrimeNums() throws Exception {
        assertThat(queryProcessor.process("Which of the following numbers are primes: 67, 29, 53, 10, 18"), containsString("67 29 53"));
    }

    @Test
    public void findDifference() throws Exception {
        assertThat(queryProcessor.process("What is 80 minus 37"), containsString("43"));
    }

    @Test
    public void findSum() throws Exception {
        assertThat(queryProcessor.process("What is 89 plus 39 plus 19"), containsString("147"));
    }

    @Test
    public void findExponential() throws Exception {
        assertThat(queryProcessor.process("What is 12 to the power of 2"), containsString("144"));
    }
}
