package com.rpg.selenium.steps;

import com.rpg.selenium.pageobjects.Google;
import com.rpg.selenium.pageobjects.TemperatureConversion;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class ConversionSteps {

    private Google mGoogle;
    private TemperatureConversion mTempConversion;
    private FirefoxDriver mDriver;
    private double mInput;

    @Given("^I want to  convert (\\d+).(\\d+) degree Fahrenheit to Celsius$")
    public void I_want_to_convert_degree_Fahrenheit_to_Celsius(int arg1, int arg2) throws Throwable {
        // Express the Regexp above with the code you wish you had
        System.setProperty("webdriver.gecko.driver","C:\\Users\\gulati\\Desktop\\geckodriver-v0.19.0-win64\\geckodriver.exe");

        mDriver = new FirefoxDriver();
        mInput = 98.6;
        mDriver.manage().window().maximize();
        mDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        mGoogle = new Google(mDriver);
        mTempConversion = mGoogle.navigateToTemperatureConversionPage();
    }

    @When("^I input the value of Fahrenheit as (\\d+).(\\d+) in text field$")
    public void I_input_the_value_of_Fahrenheit_as_in_text_field(int arg1, int arg2) throws Throwable {
        // Express the Regexp above with the code you wish you had
        if (mTempConversion != null){
            mTempConversion.inputFahrenheitValue(mInput);
        }
    }

    @Then("^It should be converted to Celsius as (\\d+) degree$")
    public void It_should_be_converted_to_Celsius_as_degree(int arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had
        if (mTempConversion != null){
            if (mTempConversion.getConvertedValue()!=(5*(mInput - 32)/9)){
                fail("Wrong value");
            }
        }
        mDriver.quit();
    }
}
