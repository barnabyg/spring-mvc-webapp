/**
 *
 */
package com.blizzardtec.maths;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertEquals;

/**
 * @author Barnaby Golden
 *
 */
public final class MathsSteps {

    /**
     * val.
     */
    private int val;

    /**
     * blah.
     * @param arg1 param
     * @throws Throwable thrown
     */
    @Given("^the number (\\d+)$")
    public void theNumber(final int arg1)
                            throws Throwable {

        this.val = arg1;
    }

    /**
     * blah.
     * @param arg1 param
     * @throws Throwable thrown
     */
    @When("^you add (\\d+)$")
    public void youAdd(final int arg1)
                            throws Throwable {

        this.val = this.val + arg1;
    }

    /**
     * blah.
     * @param arg1 param
     * @throws Throwable thrown
     */
    @Then("^the total is (\\d+)$")
    public void theTotalIs(final int arg1)
                            throws Throwable {

        assertEquals(
                "The result was not equal to the sum of the values",
                                                        this.val, arg1);
    }
}
