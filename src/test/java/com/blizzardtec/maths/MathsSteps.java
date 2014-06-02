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

    private int val;

    @Given("^the number (\\d+)$")
    public void the_number(int arg1) throws Throwable {

        this.val = arg1;
    }

    @When("^you add (\\d+)$")
    public void you_add(int arg1) throws Throwable {

        this.val = this.val + arg1;
    }

    @Then("^the total is (\\d+)$")
    public void the_total_is(int arg1) throws Throwable {

        assertEquals("The result was not equal to the sum of the values", this.val, arg1);
    }
}
