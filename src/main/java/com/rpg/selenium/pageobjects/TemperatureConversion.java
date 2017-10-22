package com.rpg.selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TemperatureConversion {
//    private WebDriver mDriver;

    @FindBy(xpath = "//*[@id=\"_Aif\"]/input")
    private WebElement mInput;

    @FindBy(xpath = "//*[@id=\"_Cif\"]/input")
    private WebElement mOutput;

    public TemperatureConversion(WebDriver driver) {
//        this.mDriver = driver;
        PageFactory.initElements(driver,this);
    }

    public void inputFahrenheitValue(double fVal){
        mInput.clear();
        mInput.sendKeys(String.valueOf(fVal));
    }

    public double getConvertedValue(){
        try {
            return Double.parseDouble(mOutput.getAttribute("value"));
        }catch (Exception e){
            return new Double("0.0");
        }
    }
}
